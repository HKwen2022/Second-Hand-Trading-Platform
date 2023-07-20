package com.mymarket.service;

import com.mymarket.mapper.CommodityMapper;
import com.mymarket.mapper.UserMapper;
import com.mymarket.pojo.Commodity;
import com.mymarket.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    CommodityMapper commodityMapper;
    public User login(String username, String password){
        return userMapper.getByUsernameAndPassword(username, password);
    }
    public void put(Commodity commodity){
        commodityMapper.put(commodity);
    }

    public void updateInfo(User user) throws DataAccessException {
        userMapper.updateInfo(user);
    }

    public void register(User user) {
        userMapper.register(user);
    }
}
