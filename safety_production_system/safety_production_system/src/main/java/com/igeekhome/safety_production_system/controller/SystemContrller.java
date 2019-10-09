package com.igeekhome.safety_production_system.controller;

import com.igeekhome.safety_production_system.util.ResultObject;
import com.igeekhome.safety_production_system.util.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/sys")
public class SystemContrller
{

    //登录
    @RequestMapping("/login")
    public ResultObject login(String username, String password, HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        Subject subject = SecurityUtils.getSubject();

        ShiroUser user = null;
        try {
            subject.login(token);
            user = (ShiroUser) subject.getPrincipal();

        } catch (AuthenticationException e){
            //用户名或密码不正确
            System.out.println("用户名或密码不正确");
            return ResultObject.fail(ResultObject.FAIL_STATUS,"用户名或密码不正确");
        }

        return ResultObject.ok(user);


    }

    //注销
    @RequestMapping("/logout")
    public String logout(){
        /*
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        */
        return "redirect:/toLogin";
    }
}
