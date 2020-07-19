package grp.team7.kelvin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import grp.team7.kelvin.entity.*;
import grp.team7.kelvin.service.impl.*;

import java.util.List;

@Controller
@RequestMapping(value = "/shop", produces = "application/json;charset=utf-8")
public class ShopController {
    @Autowired
    ShopServiceImp shopService;

    @Autowired
    OrderServiceImp orderService;

    @RequestMapping(value = "/dishes")
    public @ResponseBody String getDishes(@RequestParam(value = "shopid", required = true) Integer shopId) {
        List<Dish> dishes = shopService.getDishes(shopId);
        String result = JSON.toJSONString(dishes, SerializerFeature.BeanToArray);
        System.out.println(result);
        return result;
    }


    @RequestMapping("/orders")
    public @ResponseBody String getOrders(@RequestParam(value = "shopid", required = true) Integer shopId) {
        List<Order> orders = shopService.getOrders(shopId);
        String result = JSON.toJSONString(orders, SerializerFeature.BeanToArray);
        System.out.println(result);
        return result;
    }

    @RequestMapping("/orders/orderitems")
    public @ResponseBody String getOrderItems(@RequestParam(value = "orderid", required = true) Integer orderId) {
        List<OrderItem> orderitems = orderService.getOrderItems(orderId);
        String result = JSON.toJSONString(orderitems, SerializerFeature.BeanToArray);
        return result;
    }

    @RequestMapping("/adddish.do")
    public @ResponseBody String addDish(@RequestBody String data) {
        Dish dish = JSONObject.parseObject(data, Dish.class);
        int flag = shopService.addDish(dish);
        String result = String.format("{\"adddishflag\":%d}", flag);
        return result;
    }

    @RequestMapping("/putondish.do")
    public @ResponseBody String putOnDish(@RequestParam(value = "dishid", required = true) Integer dishId) {
        int flag = shopService.putOnDish(dishId);
        String result = String.format("{\"putondishflag\":%d}", flag);
        return result;
    }

    @RequestMapping("/pulldowndish.do")
    public @ResponseBody String pullDownDish(@RequestParam(value = "dishid", required = true) Integer dishId) {
        int flag = shopService.pullDownDish(dishId);
        String result = String.format("{\"putondishflag\":%d}", flag);
        return result;
    }

    @RequestMapping("/deletedish.do")
    public @ResponseBody String deleteDish(@RequestParam(value = "dishid", required = true) Integer dishId) {
        int flag = shopService.deleteDish(dishId);
        String result = String.format("{\"deleteflag\":%d}", flag);
        return result;
    }

}
