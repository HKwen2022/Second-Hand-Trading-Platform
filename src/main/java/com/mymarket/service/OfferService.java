package com.mymarket.service;

import com.mymarket.mapper.OfferMapper;
import com.mymarket.pojo.Commodity;
import com.mymarket.pojo.Offer;
import com.mymarket.pojo.ShopCar;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class OfferService {
    final OfferMapper offerMapper;
    final CommodityService commodityService;
    public OfferService(OfferMapper offerMapper,CommodityService commodityService)
    {
        this.offerMapper = offerMapper;
        this.commodityService = commodityService;
    }
    public void put(Offer offer) throws Exception {
        var commodity =  commodityService.get(offer.getCid());
        if(commodity.getStock() < offer.getNumber()) throw new Exception("商品库存不足!");
        commodity.setStock(commodity.getStock()-offer.getNumber());
        offer.setPrice(commodity.getPrice().multiply(BigDecimal.valueOf(offer.getNumber())));
        offer.orderDate = LocalDate.now();
        offer.deliverDate = null;
        offer.shippingAddress = null;
        offerMapper.put(offer);
        commodityService.update(commodity);
    }
    public void delete(Integer id) {
        offerMapper.delete(id);
    }
    public void deleteAll(Integer userId) {
        offerMapper.deleteAll(userId);
    }

    public List<Offer> getByUserId(Integer id) {
        var list = offerMapper.getByUserId(id);
        setCommodityData(list);
        return list;
    }
    public List<Offer> getAll() {
        var list = offerMapper.getAll();
        setCommodityData(list);
        return list;
    }
    public List<Offer> get(Integer userId, Commodity commodity) {
        var list = offerMapper.get(userId,commodity);
        setCommodityData(list);
        return list;
    }
    public void setCommodityData(List<Offer> list){
        for(var o : list){ //购物车附加商品数据
            var c = commodityService.get(o.getCid());
            if(c != null){
                o.setPrice(c.getPrice());
                o.setName(c.getName());
                o.setImage_url(c.getImageUrl1());
            }
        }
    }
}
