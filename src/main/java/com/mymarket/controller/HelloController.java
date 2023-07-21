package com.mymarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String index(){
        //跳转页面至用户登录界面
        return "forward:html/index.html";
    }
}
