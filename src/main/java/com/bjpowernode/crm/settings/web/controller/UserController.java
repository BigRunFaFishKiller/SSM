package com.bjpowernode.crm.settings.web.controller;

import com.bjpowernode.crm.commons.constant.Constants;
import com.bjpowernode.crm.commons.domain.ReturnObject;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.UserService;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.bjpowernode.crm.commons.utils.DataUtils;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/4 21:47 crm-project
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //跳转登录界面
    @RequestMapping("/settings/qx/user/toLogin.do")
    public String toLogin() {
        return "settings/qx/user/login";
    }

    @RequestMapping("/settings/qx/user/login.do")
    @ResponseBody
    public Object login(String loginAct, String loginPwd, String isRemPwd, HttpServletRequest request,HttpServletResponse response, HttpSession session) {
        //封装参数
        Map<String, Object> map = new HashMap<>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);
        //调用Service查询数据
        User user = userService.queryUserByLoginActAndPwd(map);
        //根据查询结果生成响应信息
        ReturnObject returnObject = new ReturnObject();
        if(user == null) {
            //登录失败,用户名或密码错误
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名或密码错误");
        } else {                    //进一步判断账号是否合法可用
            String expireTime = user.getExpireTime();           //获取过期时间
            String now = DataUtils.formateDateTime(new Date(), "yyyy-MM-dd HH:mm:ss"); //获取当前时间
            if((now.compareTo(expireTime) > 0)) {
                //登录失败， 账号过期
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账号已过期");
            } else if("0".equals(user.getLockState())) {
                //登录四失败，状态锁定
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("用户状态锁定");
            } else if(!user.getAllowIps().contains(request.getRemoteAddr())) {
                //登录失败，ip不合法
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("ip受限");
            } else {
                //登录成功
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
                //将User保存在Session中
                session.setAttribute( Constants.SESSION_USER, user);
                //如果需要记住密码则需要写cookie
                if("true".equals(isRemPwd)) {
                    //用户名Cookie
                    Cookie c1 = new Cookie("loginAct", user.getLoginAct());
                    c1.setMaxAge(10 * 24 * 60 * 60);
                    response.addCookie(c1);
                    Cookie c2 = new Cookie("loginPwd", user.getLoginPwd());
                    c1.setMaxAge(10 * 24 * 60 * 60);
                    response.addCookie(c2);
                } else {
                    //删除未过期的cookie
                    Cookie c1 = new Cookie("loginAct", "1");
                    c1.setMaxAge(0);
                    response.addCookie(c1);
                    Cookie c2 = new Cookie("loginPwd", "1");
                    c1.setMaxAge(0);
                    response.addCookie(c2);
                }
            }
        }
        return returnObject;
    }

}
