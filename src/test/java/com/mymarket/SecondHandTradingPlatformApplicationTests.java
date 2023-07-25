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
        Map<String, Object> map = new HashMap<>();
        map.put("1","a");
        map.put("2","b" );
        JwtUtils.parseJwt(JwtUtils.generateJwt(map));
    }
}
