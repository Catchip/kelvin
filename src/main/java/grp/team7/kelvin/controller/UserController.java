package grp.team7.kelvin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import grp.team7.kelvin.service.UserService;
import grp.team7.kelvin.service.impl.*;
import grp.team7.kelvin.entity.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user", produces = "application/json;charset=utf-8")
public class UserController {
    @Autowired
    UserServiceImp userService;

    @Autowired
    OrderServiceImp orderService;


    @RequestMapping("/login")
    public @ResponseBody String userSignIn(@RequestBody String data) {
        System.out.println("进入测试");
        JSONObject jsObject = JSONObject.parseObject(data);
        String userAccount = jsObject.getString("userAccount");
        String userPassword = jsObject.getString("userPasswordsha256");
        User user = userService.signIn(userAccount, userPassword);
        System.out.println(user);
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

    @RequestMapping("/info")
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

    // not tested
    @RequestMapping("/orders")
    public @ResponseBody String userOrders(@RequestBody String data) {
        JSONObject jsObject = JSONObject.parseObject(data);
        Integer userId = jsObject.getInteger("userId");
        List<Order> orders = userService.getOrders(userId);
        //还不知道如何返回List
        String result = JSON.toJSONString(orders, SerializerFeature.BeanToArray);
        return result;
    }

    @RequestMapping("/shops")
    public @ResponseBody String userShops(@RequestBody String data) {
        JSONObject jsObject = JSONObject.parseObject(data);
        Integer userId = jsObject.getInteger("userId");
        List<Shop> shops = userService.getShops(userId);
        //还不知道如何返回List
        String result = JSON.toJSONString(shops, SerializerFeature.BeanToArray);
        return result;
    }

    // not tested
    @RequestMapping("/addorder.do")
    public @ResponseBody String userAddOrder(@RequestBody String data) {
        //生成UUID作为验证码
        JSONObject jsObject = JSONObject.parseObject(data);
        String result = "not finished";
        return result;
    }


    @RequestMapping("/addshop.do")
    public @ResponseBody String userAddShop(@RequestBody String  data) {
        Shop shop = JSON.parseObject(data, Shop.class);
        int flag = userService.addShop(shop);
        String result = String.format("{\"addshopflag\":%d}", flag);
        return result;
    }

    @RequestMapping("/updateinfo.do")
    public @ResponseBody String userUpdateInfo(@RequestBody String data) {
        User user = JSON.parseObject(data, User.class);
        User newuser = userService.updateInformation(user);
        String result = JSON.toJSONString(newuser);
        return result;
    }

    @RequestMapping("/updatepassword.do")
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
        String result = JSON.toJSONString(dishes, SerializerFeature.BeanToArray);
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
        String result = JSON.toJSONString(shops, SerializerFeature.BeanToArray);
        return result;
    }

    // not tested
    @RequestMapping("/orderitems")
    public @ResponseBody String getorderitems(@RequestParam(value = "orderid") Integer orderId) {
        List<OrderItem> orderitems = orderService.getOrderItems(orderId);
        String result = JSON.toJSONString(orderitems, SerializerFeature.BeanToArray);
        return result;
    }
}
