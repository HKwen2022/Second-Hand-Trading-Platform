package com.mymarket.service;

import com.mymarket.mapper.ShopCarMapper;
import com.mymarket.pojo.Commodity;
import com.mymarket.pojo.ShopCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCarService {
    final ShopCarMapper shopCarMapper;
    public ShopCarService(ShopCarMapper shopCarMapper) {
        this.shopCarMapper = shopCarMapper;
    }
    public void put(ShopCar shopCar){
        shopCarMapper.put(shopCar);
    }
    public List<ShopCar> getByUserId(Integer userId){
        return shopCarMapper.getByUserId(userId);
    }
    public List<ShopCar> get(Integer userId, Commodity commodity){
        return shopCarMapper.get(userId,commodity);
    }
    public List<ShopCar> getAll(){
        return shopCarMapper.getAll();
    }
    public void delete(Integer id){
        shopCarMapper.delete(id);
    }
}
