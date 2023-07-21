package com.mymarket.mapper;

import com.mymarket.pojo.Admin;
import com.mymarket.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where name = #{name} and password = #{password}")
    Admin getByAdminNameAndPassword(String name, String password);

    @Insert("insert into admin(name,password,phone,email,image_url) " +
            "values (#{name},#{password},#{phone},#{email},#{imageUrl})")
    void register(Admin admin);

    @Insert("insert into user(name,password,phone,email,image_url)"  +
            "values (#{name},#{password},#{phone},#{email},#{imageUrl})")
    void addUser(User user);

    @Delete("delete from user where id = #{id}")
    void delUser(Integer id);

    @Update("update user set name = #{name}, password = #{password}, phone = #{phone}," +
            "email = #{email}, image_url = #{imageUrl} where id = #{id}")
    void alterUser(User user) throws DataAccessException;
}
