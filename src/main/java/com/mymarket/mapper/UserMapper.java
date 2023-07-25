package com.mymarket.mapper;

import com.mymarket.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where name = #{name} and password = #{password}")
    User getByUsernameAndPassword(User user);
    @Select("select * from user")
    List<User> getAllUsers();
    void update(User user);
    @Insert("insert into user(name,password,phone,email,image_url)"  +
            "values (#{name},#{password},#{phone},#{email},#{imageUrl})")
    void register(User user);
    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);
}
