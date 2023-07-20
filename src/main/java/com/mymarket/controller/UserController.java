package com.mymarket.controller;

import com.mymarket.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    public final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
