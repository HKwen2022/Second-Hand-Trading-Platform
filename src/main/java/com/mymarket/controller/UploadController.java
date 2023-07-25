package com.mymarket.controller;

import com.mymarket.pojo.Result;
import com.mymarket.pojo.User;
import com.mymarket.service.UserService;
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

    public UploadController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/upload")
    public Result upload(Integer id, MultipartFile image) throws IOException {
        String filename = UUID.randomUUID() + image.getOriginalFilename().
                substring(image.getOriginalFilename().lastIndexOf("."));
        image.transferTo(new File("D:\\images\\"+filename));
        User user = new User();
        user.setId(id);
        user.setImageUrl("D:\\images\\"+filename);
        userService.update(user);
        return Result.success();
    }
}
