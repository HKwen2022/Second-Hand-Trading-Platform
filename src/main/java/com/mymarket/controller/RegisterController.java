package com.mymarket.controller;

import com.mymarket.pojo.Result;
import com.mymarket.pojo.User;
import com.mymarket.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    public final UserService userService;
    public RegisterController(UserService userService) {
        this.userService = userService;
    }
    //    @PostMapping("/login")
//    public Result login(@RequestBody User loginUser){
//        User user = userService.login(loginUser);
//        if(user != null) return Result.success(user);
//        else return Result.error("用户名或密码错误！");
//    }
    @PostMapping("/register")
    public Result login(String username,String email, String telephone, String password) {
        System.out.println(username);
        System.out.println(email);
        System.out.println(telephone);
        System.out.println(password);
        return Result.error("用户名或密码错误！");
    }
}
