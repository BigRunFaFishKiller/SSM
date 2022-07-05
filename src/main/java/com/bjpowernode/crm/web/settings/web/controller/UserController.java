package com.bjpowernode.crm.web.settings.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/4 21:47 crm-project
 */

@Controller
public class UserController {

    //跳转登录界面
    @RequestMapping("/settings/qx/user/login")
    public String toLogin() {
        return "settings/qx/user/login";
    }




}
