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
    public boolean put(ShopCar shopCar){
        var ret = shopCarMapper.getByUserId(shopCar.getUid());
        for(var s : ret){
            if(s.getCid().equals(shopCar.getCid())) return false; //已经添加过的不能再添加
        }
        shopCarMapper.put(shopCar);
        return true;
    }
    public List<ShopCar> getByUserId(Integer userId){
        var list = shopCarMapper.getByUserId(userId);
        setCommodityData(list);
        return list;
    }
    public List<ShopCar> get(Integer userId, Commodity commodity){
        var list = shopCarMapper.get(userId,commodity);
        setCommodityData(list);
        return list;
    }
    public ShopCar get(Integer id){
        var s = shopCarMapper.getById(id);
        var c = commodityService.get(s.getCid());
        if(c != null) {
            s.setPrice(c.getPrice());
            s.setName(c.getName());
            s.setImage_url(c.getImageUrl1());
        }
        return s;
    }
    public List<ShopCar> getAll(){
        var list = shopCarMapper.getAll();
        setCommodityData(list);
        return list;
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
    public void setCommodityData(List<ShopCar> list){
        for(var s : list){ //购物车附加商品数据
            var c = commodityService.get(s.getCid());
            if(c != null){
                s.setPrice(c.getPrice());
                s.setName(c.getName());
                s.setImage_url(c.getImageUrl1());
            }
        }
    }
}
