package com.mymarket;

import com.mymarket.mapper.UserMapper;
import com.mymarket.pojo.User;
import com.mymarket.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@SpringBootTest
public class SecondHandTradingPlatformApplicationTests {
//    @Autowired
//    private UserMapper userMapper;
    @Test
    public void contextLoads() {
        String url = "/user/9";
        System.out.println(url.contains("admin") && !url.contains("login") && !url.contains("register"));
    }
}
