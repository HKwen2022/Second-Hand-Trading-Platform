package com.mymarket.controller;

import com.mymarket.pojo.Admin;
import com.mymarket.pojo.Result;
import com.mymarket.pojo.User;
import com.mymarket.service.AdminService;
import com.mymarket.service.UserService;
import com.mymarket.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    private final UserService userService;
    private final AdminService adminService;
    public LoginController(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }
    @PostMapping("/user/login")
    public Result login(@RequestBody User user){
        User u = userService.login(user);
        if(u != null){
            Map<String, Object>claims = new HashMap<>();
            claims.put("type",0);
            claims.put("id",u.getId());
            claims.put("name",u.getName());
            claims.put("password",u.getPassword());
            return Result.success(JwtUtils.generateJwt(claims));
        }
        return Result.error("用户名或密码错误！");
    }
    @PostMapping("/admin/login")
    public Result login(@RequestBody Admin admin){
        Admin a = adminService.login(admin);
        if(a != null) {
            Map<String, Object>claims = new HashMap<>();
            claims.put("type",1);
            claims.put("id",a.getId());
            claims.put("name",a.getName());
            claims.put("password",a.getPassword());
            return Result.success(JwtUtils.generateJwt(claims));
        }
        else return Result.error("用户名或密码错误！");
    }
}
