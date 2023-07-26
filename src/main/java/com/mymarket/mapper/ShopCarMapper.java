package com.mymarket.mapper;

import com.mymarket.pojo.Commodity;
import com.mymarket.pojo.ShopCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface ShopCarMapper {
    void put(ShopCar shopCar);
    void delete(Integer id) throws DataAccessException;
    List<ShopCar> getByUserId(Integer userId);
    List<ShopCar> get(Integer userId, Commodity commodity);
    @Select("select * from shop_car")
    List<ShopCar> getAll();

    void update(ShopCar shopCar);
    @Select("select * from shop_car where id = #{id}")
    ShopCar get(Integer id);
}
