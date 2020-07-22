package grp.team7.kelvin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import grp.team7.kelvin.entity.*;
import grp.team7.kelvin.service.impl.ShopServiceImp;
import grp.team7.kelvin.service.impl.OrderServiceImp;
import grp.team7.kelvin.service.impl.UserServiceImp;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping(value = "/shop", produces = "application/json;charset=utf-8")
public class ShopController {
    @Autowired
    ShopServiceImp shopService;

    @Autowired
    OrderServiceImp orderService;

    @Autowired
    UserServiceImp userService;


    @RequestMapping("/add")
    public @ResponseBody String userAddShop(@RequestBody String  data) {
        Shop shop = JSON.parseObject(data, Shop.class);
        int flag = userService.addShop(shop);
        if (flag == 1)
            return "OK";
        else return "NOT OK";
    }

    @RequestMapping("/edit")
    public @ResponseBody String editShop(@RequestBody String data) {
        Shop shop = JSON.parseObject(data, Shop.class);
        int flag = shopService.updateInfo(shop);
        if (flag == 1)
            return "OK";
        else return "NOT OK";
    }

    @RequestMapping("/delete")
    public @ResponseBody String deleteShop(@RequestParam(value = "shopid", required = true) Integer shopId) {
        shopService.deleteAllDish(shopId);
        userService.deleteShop(shopId);
        return "OK";
    }

    @RequestMapping("/info")
    public @ResponseBody String getShopInfo(@RequestParam(value = "shopid", required = true) Integer shopId) {
        Shop shop = shopService.getInfo(shopId);
        String result = JSON.toJSONString(shop);
        return result;
    }

    @RequestMapping("/search")
    public @ResponseBody String searchShop(@RequestBody String data ) {
        Shop shop = JSONObject.parseObject(data, Shop.class);
        List<Shop> shops = shopService.search(shop);
        String result = JSON.toJSONString(shops);
        return result;
    }




    @RequestMapping("/list")
    public @ResponseBody String getShops(@RequestParam(value = "userid") Integer userId) {
        List<Shop> shops = new ArrayList<>();
        if (userId != null)
            shops = userService.getShops(userId);
        else
            shops = userService.getAllShops();
        String result = JSON.toJSONString(shops);
        return result;
    }


}
