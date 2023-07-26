package com.mymarket.controller;

import com.mymarket.pojo.Offer;
import com.mymarket.pojo.Result;
import com.mymarket.service.OfferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {
    final OfferService offerService;
    public OfferController(OfferService offerService){
        this.offerService = offerService;
    }
    @PostMapping("/offer")
    public Result put(@RequestBody Offer offer){
        try{
            offerService.put(offer);
        }
        catch (Exception e){
            return Result.error("添加订单失败！");
        }
        return Result.success();
    }

}
