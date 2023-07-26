package com.mymarket.service;

import com.mymarket.mapper.AdminMapper;
import com.mymarket.pojo.Admin;
import com.mymarket.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    final
    AdminMapper adminMapper;

    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public Admin login(Admin admin){
        return adminMapper.getByAdminNameAndPassword(admin);
    }
    public void register(Admin admin) {
        adminMapper.register(admin);
    }
    public void update(Admin admin){adminMapper.update(admin);}
    public void addUser(User user) {
        adminMapper.addUser(user);
    }
    public void delUser(List<Integer>ids){
        adminMapper.delUser(ids);
    }
    public void alterUser(User user) throws DataAccessException {
        adminMapper.alterUser(user);
    }
    public List<User> getUserById(String name, String phone, String email){
        List<User> userlist = adminMapper.getUsers(name, phone, email);
        return userlist;
    }
}
