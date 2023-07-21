package com.mymarket.controller;

import com.mymarket.pojo.Commodity;
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
    @PutMapping("/user/update")
    public Result updateInfo(@RequestBody User user){
        try{userService.updateInfo(user);}
        catch (DataAccessException e){return Result.error("修改失败！");}
        return Result.success();
    }
    @PostMapping("/user/login")
    public Result login(String username, String password){
        System.out.println(username + " " + password);
        User user = userService.login(username,password);
        if(user != null) return Result.success(user);
        else return Result.error("用户名或密码错误！");
    }
    @PostMapping("/user/register")
    public Result register(@RequestBody User user){
        userService.register(user);
        return Result.success();
    }
}
