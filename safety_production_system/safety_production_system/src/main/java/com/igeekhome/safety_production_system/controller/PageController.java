package com.igeekhome.safety_production_system.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/system/login";
    }

    @RequestMapping("/toIndex")
    public String toHome(){
        return "/system/index";
    }



}
