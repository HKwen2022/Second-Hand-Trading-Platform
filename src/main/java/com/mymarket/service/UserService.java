package com.mymarket.service;

import com.mymarket.mapper.UserMapper;
import com.mymarket.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User login(User user){return userMapper.getByUsernameAndPassword(user);}
    public void update(User user) throws DataAccessException {userMapper.update(user);}

    public void register(User user) {
        userMapper.register(user);
    }

    public User getUserById(Integer id) {return userMapper.getUserById(id);}
}
