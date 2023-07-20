package com.mymarket.mapper;

import com.mymarket.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where u_name = #{username} and u_password = #{password}")
    User getByUsernameAndPassword(String username, String password);
    @Select("select * from user")
    List<User> getAllUsers();
}
