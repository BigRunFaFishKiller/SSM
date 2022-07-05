package com.bjpowernode.crm.settings.web.intercepter;

import com.bjpowernode.crm.commons.constant.Constants;
import com.bjpowernode.crm.settings.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/5 20:43 crm-project
 */


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //登录验证
        //user非空则已经登录
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute(Constants.SESSION_USER);
        if(user == null) {  //没有登录成功
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath());   //动态获取项目路径
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
