package com.cdu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    //springboot 默认异常处理 默认跳转error页面
    public String hello() throws Exception{
        throw new Exception();
    }

    @RequestMapping("/test")
    public String test() throws Exception {
        System.out.println("test()----------");
        int i = 5/0;
        return "success";
    }

    /**
     * controller会使用@ExceptionHandler注解处理异常，而且不会抛给servlet
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String testErrorHandler(Exception e){
        System.out.println("testErrorHandlertestErrorHandler()--------------");
        return "服务器异常，请联系管理员。";
    }
}
