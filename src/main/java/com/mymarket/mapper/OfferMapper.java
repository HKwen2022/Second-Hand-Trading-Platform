package com.mymarket.mapper;

import com.mymarket.pojo.Commodity;
import com.mymarket.pojo.Offer;
import com.mymarket.pojo.ShopCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface OfferMapper {
    public void put(Offer offer);

    void deleteAll(Integer userId) throws DataAccessException;

    void delete(Integer id) throws DataAccessException;
    @Select("select * from offer where uid = #{id}")
    List<Offer> getByUserId(Integer id);
    @Select("select * from offer")
    List<Offer> getAll();

    List<Offer> get(Integer userId, Commodity commodity);
}
