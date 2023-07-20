package com.mymarket.mapper;

import com.mymarket.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where name = #{username} and password = #{password}")
    User getByUsernameAndPassword(String username, String password);
    @Select("select * from user")
    List<User> getAllUsers();
}
