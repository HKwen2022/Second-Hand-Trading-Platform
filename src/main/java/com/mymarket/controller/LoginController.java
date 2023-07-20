package com.mymarket.controller;

import com.mymarket.pojo.Result;
import com.mymarket.pojo.User;
import com.mymarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    public final UserService userService;
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/")
    public String index(){
        return "forward:html/index.html";
    }
    @PostMapping("/login")
    public Result login(@RequestBody User loginUser){
        User user = userService.login(loginUser);
        if(user != null) return Result.success(user);
        else return Result.error("用户名或密码错误！");
    }
}
