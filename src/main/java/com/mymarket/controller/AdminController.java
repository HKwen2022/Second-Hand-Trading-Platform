package com.mymarket.controller;

import com.mymarket.pojo.Admin;
import com.mymarket.pojo.Result;
import com.mymarket.pojo.User;
import com.mymarket.service.AdminService;
import com.mymarket.service.UserService;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    public final AdminService adminService;
    public AdminController(AdminService adminService){this.adminService = adminService;}
    @PostMapping("/admin/login")
    public Result login(String name, String password){
        Admin admin = adminService.login(name,password);
        if(admin != null) return Result.success(admin);
        else return Result.error("用户名或密码错误！");
    }
    @PostMapping("/admin/register")
    public Result register(@RequestBody Admin admin){
        adminService.register(admin);
        return Result.success(admin);
    }

    @PostMapping("/admin/administrate")
    public Result addUser(@RequestBody User user){
        System.out.println(user);
        adminService.addUser(user);
        return Result.success();
    }
    @PutMapping("/admin/administrate")
    public Result alterUser(@RequestBody User user){
        try{adminService.alterUser(user);}
        catch (DataAccessException e){return Result.error("修改失败！");}
        return Result.success();
    }

    @DeleteMapping("/admin/administrate")
    public Result delUser(Integer id){
        adminService.delUser(id);
        return Result.success();
    }
}
