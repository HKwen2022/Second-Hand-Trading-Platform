package com.mymarket.service;

import com.mymarket.mapper.CommodityMapper;
import com.mymarket.pojo.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityService {
    final CommodityMapper commodityMapper;
    public CommodityService(CommodityMapper commodityMapper) {
        this.commodityMapper = commodityMapper;
    }

    public void put(Commodity commodity) throws DataAccessException {
        commodityMapper.put(commodity);
    }
    public void delete(Integer id) throws DataAccessException{
        commodityMapper.delete(id);
    }
    public void update(Commodity commodity) throws  DataAccessException{
        commodityMapper.update(commodity);
    }
    public List<Commodity> getCommodityByUserIdAndName(Integer userId, String name){
        return commodityMapper.getCommodityByUserIdAndName(userId,name);
    }
    public List<Commodity> getAllCommodities(){
        return commodityMapper.getAllCommodities();
    }
}
