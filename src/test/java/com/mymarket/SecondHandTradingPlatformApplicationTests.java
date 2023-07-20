package com.mymarket;

import com.mymarket.mapper.UserMapper;
import com.mymarket.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SecondHandTradingPlatformApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void contextLoads() {
        System.out.println("Test:");
        List<User> list = userMapper.getAllUsers();
        list.forEach(System.out::println);
    }
}
