package com.mymarket.service;

import com.mymarket.mapper.UserMapper;
import com.mymarket.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final UserMapper userMapper;
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User login(User user){
        return userMapper.getByUsernameAndPassword(user);
    }
}
