package grp.team7.kelvin.controller;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import grp.team7.kelvin.entity.Dish;
import grp.team7.kelvin.service.impl.*;

@CrossOrigin("*")
@Controller
@RequestMapping(value = "/dish", produces = "application/json;charset=utf-8")
public class DishController {
    @Autowired
    UserServiceImp userService;

    @Autowired
    ShopServiceImp shopService;

    @RequestMapping("/add")
    public @ResponseBody String addDish(@RequestBody String data) {
        Dish dish = JSONObject.parseObject(data, Dish.class);
        int flag = shopService.addDish(dish);
        if (flag == 1 )
            return "OK";
        else return "NOT OK";
    }

    @RequestMapping("/delete")
    public @ResponseBody String deleteDish(@RequestParam(value = "dishid", required = true) Integer dishId) {
        int flag = shopService.deleteDish(dishId);
        if (flag == 1 )
            return "OK";
        else return "NOT OK";
    }

    @RequestMapping("/puton")
    public @ResponseBody String putOnDish(@RequestParam(value = "dishid", required = true) Integer dishId) {
        int flag = shopService.putOnDish(dishId);
        if (flag == 1 )
            return "OK";
        else return "NOT OK";
    }

    @RequestMapping("/pulldown")
    public @ResponseBody String pullDownDish(@RequestParam(value = "dishid", required = true) Integer dishId) {
        int flag = shopService.pullDownDish(dishId);
        if (flag == 1 )
            return "OK";
        else return "NOT OK";
    }

    @RequestMapping("/list")
    public @ResponseBody String getShopDishes(@RequestParam(value = "shopid") Integer shopId ) {
        List<Dish> dishes = new ArrayList<>();
        if (shopId != null)
            dishes = shopService.getDishes(shopId);
        else
            dishes = userService.getAllDishes();
        String result = JSON.toJSONString(dishes);
        return result;
    }


    @RequestMapping(value = "/edit")
    public @ResponseBody String editDish(@RequestBody String data) {
        Dish dish = JSONObject.parseObject(data, Dish.class);
        int flag = shopService.updateDishInfo(dish);
        if (flag == 1 )
            return "OK";
        else return "NOT OK";
    }
}
