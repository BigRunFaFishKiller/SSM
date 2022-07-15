package com.bjpowernode.crm.workbench.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/5 12:11 crm-project
 */
@Controller
public class WorkbenchIndexController {

    //跳转到业务页面
    @RequestMapping("/workbench/index.do")
    public String index() {
        return "workbench/index";
    }
}
