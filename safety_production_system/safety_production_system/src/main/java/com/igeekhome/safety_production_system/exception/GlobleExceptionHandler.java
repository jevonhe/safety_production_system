package com.igeekhome.safety_production_system.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobleExceptionHandler{

    //@ExceptionHandler 声明处理指定异常
    @ExceptionHandler(AuthorizationException.class)
    public String handleAuthorizationException(Model model){
        model.addAttribute("msg","对不起，您未获得该操作权限");
        return "error";
    }

    //...



}
