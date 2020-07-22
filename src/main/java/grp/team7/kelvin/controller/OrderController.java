package grp.team7.kelvin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import grp.team7.kelvin.service.impl.*;
import grp.team7.kelvin.entity.*;

@CrossOrigin("*")
@Controller
@RequestMapping(value = "/order", produces = "application/json;charset=utf-8")
public class OrderController {
    @Autowired
    UserServiceImp userService;

    @Autowired
    ShopServiceImp shopService;

    @Autowired
    OrderServiceImp orderService;

    @RequestMapping("/list")
    public @ResponseBody String userOrders(@RequestBody String data) {
        JSONObject jsObject = JSONObject.parseObject(data);
        Integer userId = jsObject.getInteger("userId");
        Integer shopId = jsObject.getInteger("shopId");
        List<Order> orders = new ArrayList<>();
        if (userId != null) {
            orders = userService.getOrders(userId);
        } else if (shopId != null) {
            orders = shopService.getOrders(shopId);
        } else {
            orders = shopService.getOrders(shopId);
        }
        String result = JSON.toJSONString(orders);
        return result;
    }


    @RequestMapping("/create")
    public @ResponseBody String userAddOrder(@RequestBody String data) {
        JSONArray jsonArray = JSONObject.parseArray(data);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        Order order = JSONObject.parseObject(jsonObject.toJSONString(), Order.class);

        List<OrderItem> orderitems = new ArrayList<>();
        orderitems = jsonArray.stream().map(e->JSONObject.parseObject(((JSONObject)e).toJSONString(), OrderItem.class)).collect(Collectors.toList());
        orderitems.remove(0);

        System.out.println(orderitems);
        order = userService.addOrder(order);
        int flag = orderService.addOrderItems(orderitems, order.getOrderId());
        if (flag == 1)
            return "OK";
        else return "NOT OK";
    }

    @RequestMapping("/info")
    public @ResponseBody String getOrderItems(@RequestParam(value = "orderid", required = true) Integer orderId) {
        List<OrderItem> orderitems = orderService.getOrderItems(orderId);
        String result = JSON.toJSONString(orderitems);
        return result;
    }


    @RequestMapping("/delete")
    public @ResponseBody String deleteOrder(@RequestParam(value = "orderid", required = true) Integer orderId) {
        userService.deleteOrder(orderId);
        return "OK";
    }

    @RequestMapping("/search")
    public @ResponseBody String searchOrder(@RequestBody String data) {
        Order order = JSONObject.parseObject(data, Order.class);
        List<Order> orders = userService.searchOrder(order);
        String result = JSON.toJSONString(orders);
        return result;
    }
}
