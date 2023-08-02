package com.mymarket.service;

import com.mymarket.mapper.ShopCarMapper;
import com.mymarket.pojo.Commodity;
import com.mymarket.pojo.Offer;
import com.mymarket.pojo.SettlementData;
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
        return shopCarMapper.getById(id);
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
    public void settlement(SettlementData data) throws Exception {
        for (Integer id : data.getList()) {
            ShopCar shopCar = get(id);
            settlement(shopCar,data.getDeliveryAddress());
        }
    }
    public void settlementAll(Integer userId, String address) throws Exception {
        List<ShopCar> list = getByUserId(userId);
        for(ShopCar shopCar : list){
            settlement(shopCar,address);
        }
    }
    private void settlement(ShopCar shopCar, String address) throws Exception {
        Offer offer = new Offer();
        offer.setCid(shopCar.getCid());
        offer.setUid(shopCar.getUid());
        offer.setNumber(shopCar.getCNumber());
        offer.setDeliveryAddress(address);
        offerService.put(offer);
        delete(shopCar.getId());
    }

    public void deleteAll(Integer userId) {
        shopCarMapper.deleteAll(userId);
    }
}
