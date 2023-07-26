package com.mymarket.service;

import com.mymarket.mapper.ShopCarMapper;
import com.mymarket.pojo.Commodity;
import com.mymarket.pojo.Offer;
import com.mymarket.pojo.ShopCar;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShopCarService {
    final ShopCarMapper shopCarMapper;
    final OfferService offerService;
    final CommodityService commodityService;
    public ShopCarService(ShopCarMapper shopCarMapper,OfferService offerService, CommodityService commodityService) {
        this.shopCarMapper = shopCarMapper;
        this.offerService = offerService;
        this.commodityService = commodityService;
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
    public ShopCar get(Integer id){
        return shopCarMapper.get(id);
    }
    public List<ShopCar> getAll(){
        return shopCarMapper.getAll();
    }
    public void delete(Integer id){
        shopCarMapper.delete(id);
    }
    public void update(ShopCar shopCar) {
        shopCarMapper.update(shopCar);
    }
    public void settlement(List<Integer> list){
        for (Integer id : list) {
            ShopCar shopCar = get(id);
            settlement(shopCar);
        }
    }
    public void settlementAll(Integer userId){
        List<ShopCar> list = getByUserId(userId);
        for(ShopCar shopCar : list){
            settlement(shopCar);
        }
    }
    private void settlement(ShopCar shopCar){
        Commodity commodity = commodityService.get(shopCar.getCid());
        Offer offer = new Offer();
        offer.setCid(shopCar.getCid());
        offer.setUid(shopCar.getUid());
        offer.setNumber(shopCar.getCNumber());
        offer.setPrice(commodity.getPrice().multiply(BigDecimal.valueOf(shopCar.getCNumber())));
        offerService.put(offer);
        delete(shopCar.getId());
    }
}
