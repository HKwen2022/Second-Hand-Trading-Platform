package com.mymarket.service;

import com.mymarket.mapper.AdminMapper;
import com.mymarket.pojo.Admin;
import com.mymarket.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;
    public Admin login(String name, String password){
        return adminMapper.getByAdminNameAndPassword(name, password);
    }

    public void register(Admin admin) {
        adminMapper.register(admin);
    }

    public void addUser(User user) {
        adminMapper.addUser(user);
    }

    public void delUser(Integer id){
        adminMapper.delUser(id);
    }

    public void alterUser(User user) throws DataAccessException {
        adminMapper.alterUser(user);
    }
}