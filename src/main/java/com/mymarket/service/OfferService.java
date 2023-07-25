package com.mymarket.service;

import com.mymarket.mapper.OfferMapper;
import com.mymarket.pojo.Offer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OfferService {
    final OfferMapper offerMapper;
    public OfferService(OfferMapper offerMapper)
    {
        this.offerMapper = offerMapper;
    }
    public void put(Offer offer) {
        offer.orderDate = LocalDate.now();
        offer.deliverDate = null;
        offer.deliveryAddress = null;
        offer.shippingAddress = null;
        offerMapper.put(offer);
    }
}
