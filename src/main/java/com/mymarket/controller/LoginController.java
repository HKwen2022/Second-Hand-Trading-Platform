package com.mymarket.controller;

import com.mymarket.pojo.Result;
import com.mymarket.pojo.User;
import com.mymarket.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    public final UserService userService;
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user/login")
    public Result login(String username, String password){
        User user = userService.login(username,password);
        if(user != null) return Result.success(user);
        else return Result.error("用户名或密码错误！");
    }
//    @PostMapping("/adminLogin")
//    public Result adminLogin(String username, String password){
//        User user = adminService.login(username,password);
//        if(user != null) return Result.success(user);
//        else return Result.error("用户名或密码错误！");
//    }
}
