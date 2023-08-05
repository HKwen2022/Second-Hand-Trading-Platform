package com.mymarket.controller;

import com.mymarket.mapper.ShopCarMapper;
import com.mymarket.pojo.*;
import com.mymarket.service.CommodityService;
import com.mymarket.service.OfferService;
import com.mymarket.service.ShopCarService;
import com.mymarket.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ShopCarController {
    final ShopCarService shopCarService;

    public ShopCarController(ShopCarService shopCarService) {
        this.shopCarService = shopCarService;
    }
    @PostMapping("/shop_car")
    public Result put(@RequestBody ShopCar shopCar) {
        try {
            shopCarService.put(shopCar);
        } catch (DataAccessException e) {
            return Result.error("添加购物车失败！");
        }
        return Result.success();
    }
    @GetMapping("/shop_car/{id}")
    public Result getByUserId(@PathVariable Integer id) {
        List<ShopCar> ret = null;
        try {
            ret = shopCarService.getByUserId(id);
        } catch (DataAccessException e) {
            return Result.error("请求该用户的购物车信息失败！");
        }
        return Result.success(ret);
    }
    @GetMapping("/shop_car")
    public Result getByUserId(HttpServletRequest request) {
        List<ShopCar> ret = null;
        try {
            var token = JwtUtils.checkToken(request);
            if(token[0]==1) return Result.error("请前往管理员网页查看用户信息！");
            ret = shopCarService.getByUserId(token[1]);
        } catch (DataAccessException e) {
            return Result.error("请求该用户的购物车信息失败！");
        }
        return Result.success(ret);
    }
    @GetMapping("/shop_car/all")
    public Result getAllShopCar() {
        List<ShopCar> ret = null;
        try {
            ret = shopCarService.getAll();
        } catch (DataAccessException e) {
            return Result.error("请求购物车信息失败！");
        }
        return Result.success(ret);
    }
    @PostMapping("/shop_car/all")
    public Result get(Integer userId, @RequestBody Commodity commodity) {
        List<ShopCar> ret = null;
        try {
            ret = shopCarService.get(userId, commodity);
        } catch (DataAccessException e) {
            return Result.error("请求购物车信息失败！");
        }
        return Result.success(ret);
    }
    @DeleteMapping("/shop_car/{id}")
    public Result delete(@PathVariable Integer id) {
        try {
            shopCarService.delete(id);
        } catch (DataAccessException e) {
            return Result.error("删除购物车失败！");
        }
        return Result.success();
    }
    @DeleteMapping("/shop_car")
    public Result delete(@RequestBody List<Integer> list) {
        try {
            for(Integer id : list) shopCarService.delete(id);
        } catch (DataAccessException e) {
            return Result.error("删除购物车失败！");
        }
        return Result.success();
    }
    @DeleteMapping("/shop_car/all")
    public Result delete(HttpServletRequest request) {
        try {
            Integer userId = JwtUtils.checkToken(request)[1];
            shopCarService.deleteAll(userId);
        } catch (DataAccessException e) {
            return Result.error("删除购物车失败！");
        }
        return Result.success();
    }
    @PutMapping("/shop_car")
    public Result update(@RequestBody ShopCar shopCar) {
        if (shopCar.getId() == null) return Result.error("修改购物车失败！未提供购物车id。");
        try {
            shopCarService.update(shopCar);
        } catch (DataAccessException e) {
            return Result.error("修改购物车失败！");
        }
        return Result.success();
    }
    //结算购物车
    @PostMapping("/shop_car/settlement")
    public Result settlement(@RequestBody SettlementData data) {
        try {
            shopCarService.settlement(data);
        }
        catch (Exception e){
            if(e.getMessage().equals("商品库存不足!")) return Result.error(e.getMessage());
            e.printStackTrace();
            return Result.error("购物车结算失败!");
        }
        return Result.success();
    }
    @PostMapping("/shop_car/settlement/all")
    public Result settlementAll(@RequestBody String address, HttpServletRequest request){
        try{
            Integer userId = JwtUtils.checkToken(request)[1];
            shopCarService.settlementAll(userId,address);
        }
        catch (Exception e){
            if(e.getMessage().equals("商品库存不足!")) return Result.error(e.getMessage());
            return Result.error("购物车结算失败!");
        }
        return Result.success();
    }
}
