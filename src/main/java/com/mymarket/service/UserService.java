package com.mymarket.service;

import com.mymarket.mapper.UserMapper;
import com.mymarket.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired(required = false)
    UserMapper userMapper;
//    public UserService(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }
    public User login(String username, String password){
        return userMapper.getByUsernameAndPassword(username, password);
    }
}
