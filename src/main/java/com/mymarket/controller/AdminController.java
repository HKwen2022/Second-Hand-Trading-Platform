package com.mymarket.controller;

import com.mymarket.pojo.Admin;
import com.mymarket.pojo.Result;
import com.mymarket.pojo.User;
import com.mymarket.service.AdminService;
import com.mymarket.service.UserService;
import com.mymarket.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class AdminController {
    public final AdminService adminService;
    public AdminController(AdminService adminService){this.adminService = adminService;}
    @PostMapping("/admin/register")
    public Result register(@RequestBody Admin admin){
        adminService.register(admin);
        return Result.success(admin);
    }
    @PostMapping("/admin")
    public Result addUser(@RequestBody User user){
        adminService.addUser(user);
        return Result.success();
    }
    @PutMapping("/admin/update")
    public Result update(HttpServletRequest request, @RequestBody Admin admin){
        Claims claims = JwtUtils.parseJwt(request.getHeader("token"));
        if(!Objects.equals(admin.getId(), claims.get("id", Integer.class))) return Result.error("id不匹配！");
        adminService.update(admin);
        return Result.success();
    }
    @PutMapping("/admin")
    public Result alterUser(@RequestBody User user){
        try{adminService.alterUser(user);}
        catch (DataAccessException e){return Result.error("修改失败！");}
        return Result.success();
    }
    @DeleteMapping("/admin/{ids}")
    public Result delUser(@PathVariable List<Integer> ids){
        adminService.delUser(ids);
        return Result.success();
    }
    @GetMapping("/admin")
    public Result getUserById(String name, String phone, String email){
        return Result.success(adminService.getUserById(name, phone, email));
    }
}
