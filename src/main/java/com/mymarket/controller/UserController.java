package com.mymarket.controller;

import com.mymarket.pojo.Result;
import com.mymarket.pojo.User;
import com.mymarket.service.UserService;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    public final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PutMapping("/user")
    public Result update(@RequestBody User user){
        try{userService.update(user);}
        catch (DataAccessException e){return Result.error("修改失败！");}
        return Result.success();
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
