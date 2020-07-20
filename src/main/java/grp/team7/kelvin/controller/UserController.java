package grp.team7.kelvin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import grp.team7.kelvin.service.UserService;
import grp.team7.kelvin.service.impl.*;
import grp.team7.kelvin.entity.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/user", produces = "application/json;charset=utf-8")
public class UserController {
    @Autowired
    UserServiceImp userService;

    @Autowired
    OrderServiceImp orderService;


    @RequestMapping("/login")
    @CrossOrigin("*")
    public @ResponseBody String userSignIn(@RequestBody String data) {
        JSONObject jsObject = JSONObject.parseObject(data);
        String userAccount = jsObject.getString("userAccount");
        String userPassword = jsObject.getString("userPassword");
        User user = userService.signIn(userAccount, userPassword);
        if (user != null) {
            String userjson = JSON.toJSONString(user);
            return userjson;
        }
        return null;
    }

    @RequestMapping("/register")
    public @ResponseBody String userSignup(@RequestBody String data) {
        User user = JSON.parseObject(data, User.class);
        int flag = userService.signUp(user);
        String result = String.format("{\"registerflag\":%d}", flag);
        return result;
    }

    @RequestMapping("/edit")
    public @ResponseBody String userUpdateInfo(@RequestBody String data) {
        User user = JSON.parseObject(data, User.class);
        User newuser = userService.updateInformation(user);
        String result = JSON.toJSONString(newuser);
        return result;
    }

    @RequestMapping("/getinfo")
    public @ResponseBody String userInfo(@RequestBody String data) {
        JSONObject jsObject = JSONObject.parseObject(data);
        Integer userId = jsObject.getInteger("userId");
        User user = userService.getInformation(userId);
        if (user != null) {
            String userjson = JSON.toJSONString(user);
            return userjson;
        }
        return null;
    }



    @RequestMapping("/updatepassword")
    public @ResponseBody String userUpdatePassword(@RequestBody String data) {
        User user = JSON.parseObject(data, User.class);
        int flag = userService.updatePassword(user);
        String result = String.format("{\"updatepasswordflag\":%d}", flag);
        return result;
    }






    // not tested
    @RequestMapping("/getdishcollect.do")
    public @ResponseBody String getDishCollect(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = jsonObject.getInteger("userId");
        List<Dish> dishes = userService.getDishCollect(userId);
        String result = JSON.toJSONString(dishes);
        return result;
    }

    // not tested
    @RequestMapping("/adddishcollect.do")
    public @ResponseBody String addDishCollect(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = jsonObject.getInteger("userId");
        Integer dishId = jsonObject.getInteger("dishId");
        int flag = userService.addDishCollect(dishId, userId);
        if (flag == 1) return "OK";
        else return "NOT OK";
    }

    // not tested
    @RequestMapping("/addshopcollect.do")
    public @ResponseBody String addShopCollect(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = jsonObject.getInteger("userId");
        Integer shopId = jsonObject.getInteger("shopId");
        int flag = userService.addShopCollect(shopId, userId);
        if (flag == 1) return "OK";
        else return "NOT OK";
    }

    // not tested
    @RequestMapping("/getshopcollect.do")
    public @ResponseBody String getShopCollect(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = jsonObject.getInteger("userId");
        List<Shop> shops = userService.getShopCollect(userId);
        String result = JSON.toJSONString(shops);
        return result;
    }

    @RequestMapping("/getcollectstausofshop")
    public @ResponseBody String getShopCollectStatus(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = jsonObject.getInteger("userId");
        Integer shopId = jsonObject.getInteger("shopId");
        int flag = userService.getShopCollectStatus(userId, shopId);
        String result = String.format("{\"collected\":%d}", flag);
        return result;

    }

    @RequestMapping("/getcollectstausofdish")
    public @ResponseBody String getDishCollectStatus(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = jsonObject.getInteger("userId");
        Integer dishId = jsonObject.getInteger("dishId");
        int flag = userService.getDishCollectStatus(userId, dishId);
        String result = String.format("{\"collected\":%d}", flag);
        return result;
    }

    // not tested
    @RequestMapping("/orderitems")
    public @ResponseBody String getorderitems(@RequestParam(value = "orderid") Integer orderId) {
        List<OrderItem> orderitems = orderService.getOrderItems(orderId);
        String result = JSON.toJSONString(orderitems);
        return result;
    }
}
