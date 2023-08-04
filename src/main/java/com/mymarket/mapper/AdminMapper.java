package com.mymarket.mapper;

import com.mymarket.pojo.Admin;
import com.mymarket.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where name = #{name} and password = #{password}")
    Admin getByAdminNameAndPassword(Admin admin);

    @Insert("insert into admin(name,password,phone,email,image_url) " +
            "values (#{name},#{password},#{phone},#{email},#{imageUrl})")
    void register(Admin admin);
    void update(Admin admin);
    @Insert("insert into user(name,password,phone,email,image_url)"  +
            "values (#{name},#{password},#{phone},#{email},#{imageUrl})")
    void addUser(User user);
    void delUser(List<Integer>ids);
    void alterUser(User user) throws DataAccessException;
    List<User> getUsers(String name, String phone, String email);
    @Select("select * from admin where id = #{id}")
    Admin getAdminById(Integer id);
}
