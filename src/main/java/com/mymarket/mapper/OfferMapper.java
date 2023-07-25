package com.mymarket.mapper;

import com.mymarket.pojo.Offer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OfferMapper {
    public void put(Offer offer);
}
