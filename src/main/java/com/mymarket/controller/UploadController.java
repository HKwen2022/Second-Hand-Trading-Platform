package com.mymarket.controller;

import com.mymarket.pojo.Admin;
import com.mymarket.pojo.Commodity;
import com.mymarket.pojo.Result;
import com.mymarket.pojo.User;
import com.mymarket.service.AdminService;
import com.mymarket.service.CommodityService;
import com.mymarket.service.UserService;
import com.mymarket.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final CommodityService commodityService;
    private final String path = "D:\\images\\";
    public UploadController(UserService userService, AdminService adminService, CommodityService commodityService) {
        this.userService = userService;
        this.adminService = adminService;
        this.commodityService = commodityService;
    }
    @PostMapping("/upload")
    public Result upload(HttpServletRequest request, MultipartFile image) throws IOException {
        if(image == null) return Result.error("图片不能为空");
        Integer[] res = JwtUtils.checkToken(request);
        Integer type = res[0];
        Integer id = res[1];
        String filename = UUID.randomUUID() + image.getOriginalFilename().
                substring(image.getOriginalFilename().lastIndexOf("."));
        image.transferTo(new File(path + filename));
        switch (type){
            case 0 ->{  //上传用户图片
                User user = new User();
                user.setId(id);
                user.setImageUrl(path + filename);
                userService.update(user);
                return Result.success(path + filename);
            }
            case 1 ->{  //上传管理员图片
                Admin admin = new Admin();
                admin.setId(id);
                admin.setImageUrl(path + filename);
                adminService.update(admin);
                return Result.success(path + filename);
            }
            default -> {
                return Result.error("用户类型错误！");
            }
        }
    }
    @PostMapping("/upload/{id}")
    public Result uploadCommodityImages(HttpServletRequest request, @PathVariable Integer id, MultipartFile[] images) throws IOException {
        if(images == null) return Result.error("图片不能为空");
        if(JwtUtils.check(id ,request)) return Result.error("用户id不匹配！");
        Commodity commodity = new Commodity();
        commodity.setId(id);
        String[] filenames = new String[4];
        int length = images.length;
        for(int i=0;i<length;i++){
            filenames[i] = UUID.randomUUID() + images[i].getOriginalFilename().
                    substring(images[i].getOriginalFilename().lastIndexOf("."));
            images[i].transferTo(new File(path + filenames[i]));
        }
        if(filenames[0] != null) commodity.setImageUrl1(filenames[0]);
        if(filenames[1] != null) commodity.setImageUrl2(filenames[1]);
        if(filenames[2] != null) commodity.setImageUrl3(filenames[2]);
        if(filenames[3] != null) commodity.setImageUrl4(filenames[3]);
        commodityService.update(commodity);
        return Result.success();
    }
}
