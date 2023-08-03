package com.mymarket.controller;

import com.mymarket.pojo.Result;
import com.mymarket.pojo.User;
import com.mymarket.service.UserService;
import com.mymarket.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class UserController {
    public final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PutMapping("/user")
    public Result update(HttpServletRequest request, @RequestBody User user){
//        Integer type = JwtUtils.checkToken(request)[0];
//        if(type == 1) return Result.error("请前往管理员网页修改用户信息！");
//        if(JwtUtils.check(user.getId(), request)) return Result.error("id不匹配！");
        Integer id = JwtUtils.checkToken(request)[1];
        user.setId(id);
        try{userService.update(user);}
        catch (DataAccessException e){
            e.printStackTrace();
            return Result.error("修改失败！");}
        return Result.success();
    }
    @GetMapping("/user")
    public Result getUserInfo(HttpServletRequest request){
        Integer id = JwtUtils.checkToken(request)[1];
        return Result.success(userService.getUserById(id));
    }
    @PostMapping("/user/register")
    public Result register(@RequestBody User user){
        userService.register(user);
        return Result.success();
    }
    @GetMapping("/user/{id}")
    public Result getUserById(@PathVariable Integer id){
        return Result.success(userService.getUserById(id));
    }
}
