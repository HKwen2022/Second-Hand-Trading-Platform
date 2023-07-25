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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    private final UserService userService;
    private final AdminService adminService;
    private final String path = "D:\\images\\";
    public UploadController(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }
    @PostMapping("/upload")
    public Result upload(HttpServletRequest request, MultipartFile image) throws IOException {
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJwt(jwt);
        Integer type = claims.get("type", Integer.class);
        Integer id = claims.get("id", Integer.class);
        String filename = UUID.randomUUID() + image.getOriginalFilename().
                substring(image.getOriginalFilename().lastIndexOf("."));
        image.transferTo(new File(path + filename));
        switch (type){
            case 0 ->{  //上传用户图片
                User user = new User();
                user.setId(id);
                user.setImageUrl(path + filename);
                userService.update(user);
                return Result.success();
            }
            case 1 ->{  //上传管理员图片
                Admin admin = new Admin();
                admin.setId(id);
                admin.setImageUrl(path + filename);
                adminService.update(admin);
                return Result.success();
            }
            default -> {
                return Result.error("用户类型错误！");
            }
        }
    }
}
