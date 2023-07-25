package com.mymarket.controller;

import com.mymarket.mapper.ShopCarMapper;
import com.mymarket.pojo.Commodity;
import com.mymarket.pojo.Result;
import com.mymarket.pojo.ShopCar;
import com.mymarket.service.ShopCarService;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopCarController {
    final ShopCarService shopCarService;
    public ShopCarController(ShopCarService shopCarService){
        this.shopCarService = shopCarService;
    }
    @PostMapping("/shop_car")
    public Result put(@RequestBody ShopCar shopCar){
        try{
            shopCarService.put(shopCar);
        }
        catch (DataAccessException e){
            return Result.error("添加购物车失败！");
        }
        return Result.success();
    }
    @GetMapping("/shop_car/{id}")
    public Result getByUserId(@PathVariable Integer id){
        List<ShopCar> ret = null;
        try{
            ret = shopCarService.getByUserId(id);
        }
        catch (DataAccessException e){
            return Result.error("请求该用户的购物车信息失败！");
        }
        return Result.success(ret);
    }
    @GetMapping("/shop_car/all")
    public Result getAllShopCar(){
        List<ShopCar> ret = null;
        try{
            ret = shopCarService.getAll();
        }
        catch (DataAccessException e){
            return Result.error("请求购物车信息失败！");
        }
        return Result.success(ret);
    }
    @PostMapping("/shop_car/all")
    public Result get(Integer userId, @RequestBody Commodity commodity){
        List<ShopCar> ret = null;
        try{
            ret = shopCarService.get(userId,commodity);
        }
        catch (DataAccessException e){
            return Result.error("请求购物车信息失败！");
        }
        return Result.success(ret);
    }
    @DeleteMapping("/shop_car/{id}")
    public Result delete(@PathVariable Integer id){
        try{
            shopCarService.delete(id);
        }
        catch (DataAccessException e){
            return Result.error("删除购物车失败！");
        }
        return Result.success();
    }
}
