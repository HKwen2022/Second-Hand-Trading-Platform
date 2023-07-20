package com.mymarket.mapper;

import com.mymarket.pojo.Commodity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommodityMapper {
    @Insert("insert into commodity(name, description, publisher, type, price, stock) values (#{name},#{description},#{publisher},#{type},#{price},#{stock})")
    void put(Commodity commodity);
}
