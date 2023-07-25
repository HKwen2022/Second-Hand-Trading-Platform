package com.mymarket.controller;

import com.mymarket.pojo.Result;
import com.mymarket.pojo.User;
import com.mymarket.service.UserService;
import com.mymarket.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/user/login")
    public Result login(@RequestBody User user){
        User u = userService.login(user);
        if(u != null){
            Map<String, Object>claims = new HashMap<>();
            claims.put("id",u.getId());
            claims.put("name",u.getName());
            claims.put("password",u.getPassword());
            return Result.success(JwtUtils.generateJwt(claims));
        }
        return Result.error("用户名或密码错误！");
    }
}
