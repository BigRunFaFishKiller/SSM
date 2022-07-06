package com.bjpowernode.crm.workbench.web.controller;

import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/6 9:42 crm-project
 */

@Controller
public class ActivityController {

    @Autowired
     private UserService userService;

    @RequestMapping("/workbench/activity/index.do")
    public String index(HttpServletRequest request) {
        //查询所有用户
        List<User> userList = userService.queryAllUsers();
        //将数据存入request域中
        request.setAttribute("userList", userList);
        //请求转发到市场活动主页面
        return "workbench/activity/index";
    }

}
