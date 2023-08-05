package com.mymarket.controller;

import com.mymarket.pojo.Commodity;
import com.mymarket.pojo.Offer;
import com.mymarket.pojo.Result;
import com.mymarket.pojo.ShopCar;
import com.mymarket.service.OfferService;
import com.mymarket.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfferController {
    final OfferService offerService;
    public OfferController(OfferService offerService){
        this.offerService = offerService;
    }
    @PostMapping("/offer")
    public Result put(@RequestBody Offer offer, HttpServletRequest request){
        try{
            var ret = JwtUtils.checkToken(request);
            if(ret[0] == 0) offer.setUid(ret[1]);
            else if(ret[0] == 1 && offer.getUid() == null) return Result.error("未指定发布者id!");
            offerService.put(offer);
        }
        catch (Exception e){
            return Result.error("添加订单失败！");
        }
        return Result.success();
    }
    @GetMapping("/offer/{id}")
    public Result getByUserId(@PathVariable Integer id) {
        List<Offer> ret = null;
        try {
            ret = offerService.getByUserId(id);
        } catch (DataAccessException e) {
            return Result.error("请求该用户的订单信息失败！");
        }
        return Result.success(ret);
    }
    @GetMapping("/offer")
    public Result getByUserId(HttpServletRequest request) {
        List<Offer> ret = null;
        try {
            var token = JwtUtils.checkToken(request);
            if(token[0]==1) return Result.error("请前往管理员网页查看用户信息！");
            ret = offerService.getByUserId(token[1]);
        } catch (DataAccessException e) {
            return Result.error("请求该用户的所有订单信息失败！");
        }
        return Result.success(ret);
    }
    @GetMapping("/offer/all")
    public Result getAllShopCar() {
        List<Offer> ret = null;
        try {
            ret = offerService.getAll();
        } catch (DataAccessException e) {
            return Result.error("请求订单信息失败！");
        }
        return Result.success(ret);
    }
    @PostMapping("/offer/all")
    public Result get(Integer userId, @RequestBody Commodity commodity) {
        List<Offer> ret = null;
        try {
            ret = offerService.get(userId, commodity);
        } catch (DataAccessException e) {
            return Result.error("请求购物车信息失败！");
        }
        return Result.success(ret);
    }
    @DeleteMapping("/offer/{id}")
    public Result delete(@PathVariable Integer id) {
        try {
            offerService.delete(id);
        } catch (DataAccessException e) {
            return Result.error("删除订单失败！");
        }
        return Result.success();
    }
    @DeleteMapping("/offer")
    public Result delete(@RequestBody List<Integer> list) {
        try {
            for(Integer id : list) offerService.delete(id);
        } catch (DataAccessException e) {
            return Result.error("删除订单失败！");
        }
        return Result.success();
    }
    @DeleteMapping("/offer/all")
    public Result delete(HttpServletRequest request) {
        try {
            Integer userId = JwtUtils.checkToken(request)[1];
            offerService.deleteAll(userId);
        } catch (DataAccessException e) {
            return Result.error("删除订单失败！");
        }
        return Result.success();
    }
}
