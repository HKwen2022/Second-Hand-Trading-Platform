package com.mymarket.mapper;

import com.mymarket.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapper {
    //@Select("select * from user where ")
    public User getByUsernameAndPassword(User user) {
        return null;
    }
}
