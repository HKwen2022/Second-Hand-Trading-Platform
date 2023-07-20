package com.mymarket.controller;

import com.mymarket.pojo.Commodity;
import com.mymarket.pojo.Result;
import com.mymarket.service.CommodityService;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommodityController {
    public final CommodityService commodityService;
    public CommodityController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }
    @PostMapping("/commodity")
    public Result put(@RequestBody Commodity commodity){
        try {
            commodityService.put(commodity);
        }
        catch (DataAccessException e){
            return Result.error("发布商品失败！");
        }
        return Result.success();
    }
    @DeleteMapping("/commodity")
    public Result delete(Integer id){
        try{
            commodityService.delete(id);
        }
        catch (DataAccessException e){
            //实际上不存在对应id的商品也不会返回错误
            return Result.error("删除失败！不存在该商品。");
        }
        return Result.success();
    }
    @PutMapping("/commodity")
    public Result update(@RequestBody Commodity commodity){
        try{
            commodityService.update(commodity);
        }
        catch (DataAccessException e){
            //实际上不存在对应id的商品也不会返回错误
            return Result.error("修改商品失败！");
        }
        return Result.success();
    }
    @GetMapping("/commodity")
    public Result getCommodityByUserIdAndName(Integer id, String name){
        List<Commodity> ret = commodityService.getCommodityByUserIdAndName(id,name);
        return Result.success(ret);
    }
}
