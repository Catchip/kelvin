package grp.team7.kelvin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import grp.team7.kelvin.service.impl.*;
import grp.team7.kelvin.entity.*;

@Controller
@RequestMapping(value = "/collect", produces = "application/json;charset=utf-8")
public class CollectController {
    @Autowired
    UserServiceImp userService;


    @RequestMapping("/add")
    public @ResponseBody String addCollect(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = jsonObject.getInteger("userId");
        Integer dishId = jsonObject.getInteger("dishId");
        Integer shopId = jsonObject.getInteger("shopId");
        int flag = 1;
        if (dishId != null)
            flag = userService.addDishCollect(dishId, userId);
        else
            flag = userService.addShopCollect(shopId, userId);

        if (flag == 1) return "OK";
        else return "NOT OK";
    }

    @RequestMapping("/list")
    public @ResponseBody String listCollect(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = jsonObject.getInteger("userId");
        Integer shopOrDish = jsonObject.getInteger("shopOrDish");
        String result = null;
        if (shopOrDish == 1) {
            List<Shop> shops = userService.getShopCollect(userId);
            result = JSON.toJSONString(shops);
        } else {
            List<Dish> dishes = userService.getDishCollect(userId);
            result = JSON.toJSONString(dishes);
        }
        return result;

    }

}
