package com.mymarket.mapper;

import com.mymarket.pojo.Commodity;
import com.mymarket.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface CommodityMapper {
    @Options(keyProperty = "id", useGeneratedKeys = true) //返回插入的主键id到commodity对象的id中
    @Insert("insert into commodity(name, description, publisher, type, price, stock) values (#{name},#{description},#{publisher},#{type},#{price},#{stock})")
    void put(Commodity commodity) throws DataAccessException;
    @Select("select * from commodity where id = #{id}")
    List<Commodity> getCommodityByUser(User user);
    @Delete("delete from commodity where id = #{id}")
    void delete(Integer id) throws DataAccessException;
    //@Update("update commodity set name=#{name},description=#{description},publisher=#{publisher},type=#{type},price=#{price},stock=#{stock} where id = #{id}")
    void update(Commodity commodity) throws DataAccessException;
    //@Select("select * from commodity where publisher = #{userId} and name like #{commodityName}")
    List<Commodity> getCommodityByUserIdAndName(Integer userId, String commodityName);
    @Select("select * from commodity")
    List<Commodity> getAllCommodities();
}
