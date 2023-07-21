package com.mymarket.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mymarket.mapper.AdminMapper;
import com.mymarket.pojo.Admin;
import com.mymarket.pojo.PageBean;
import com.mymarket.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void delUser(List<Integer>ids){
        adminMapper.delUser(ids);
    }
    public void alterUser(User user) throws DataAccessException {
        adminMapper.alterUser(user);
    }
    public PageBean getUserById(Integer page, String name, String phone, String email){
        PageHelper.startPage(page, 10);
        List<User> userlist = adminMapper.getUsers(name, phone, email);
        Page<User> p =(Page<User>) userlist;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }
}
