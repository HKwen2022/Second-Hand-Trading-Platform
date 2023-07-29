package com.mymarket.service;

import com.mymarket.mapper.OfferMapper;
import com.mymarket.pojo.Offer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OfferService {
    final OfferMapper offerMapper;
    final CommodityService commodityService;
    public OfferService(OfferMapper offerMapper,CommodityService commodityService)
    {
        this.offerMapper = offerMapper;
        this.commodityService = commodityService;
    }
    public void put(Offer offer) {
        offer.orderDate = LocalDate.now();
        offer.deliverDate = null;
        offer.deliveryAddress = null;
        offer.shippingAddress = null;
        offerMapper.put(offer);
    }
}
