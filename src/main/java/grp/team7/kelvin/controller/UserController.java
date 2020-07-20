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


    /**
     * <b>POST</b>
     * 用户登录的表现层部分
     * @param data JSON字符串，接受的参数为userAccount,userPassword
     */
    @RequestMapping("/login")
    public @ResponseBody String userSignIn(@RequestBody String data) {
        System.out.println("进入测试");
        JSONObject jsObject = JSONObject.parseObject(data);
        String userAccount = jsObject.getString("userAccount");
        String userPassword = jsObject.getString("userPassword");
        User user = userService.signIn(userAccount, userPassword);
        System.out.println(user);
        if (user != null) {
            JSONObject userjson = (JSONObject)JSON.toJSON(user);
            userjson.put("role", userService.getUserRole(user.getUserId()));
            String jsonString = userjson.toJSONString();
            return jsonString;
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
            JSONObject userjson = (JSONObject)JSON.toJSON(user);
            userjson.put("role", userService.getUserRole(user.getUserId()));
            String jsonString = userjson.toJSONString();
            return jsonString;
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
        String result = JSON.toJSONString(orders);
        return result;
    }

    @RequestMapping("/shops")
    public @ResponseBody String userShops(@RequestBody String data) {
        JSONObject jsObject = JSONObject.parseObject(data);
        Integer userId = jsObject.getInteger("userId");
        List<Shop> shops = userService.getShops(userId);
        String result = JSON.toJSONString(shops);
        return result;
    }

    @RequestMapping("/addorder.do")
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
        String result = String.format("{\"addorderflag\":%d}", flag);
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

    /**
     * <b>POST</b>
     * 改变用户的管理角色
     * @param data 传入的数据，内容为
     * <table>
     * <tr>
     *  <td>userId</td>
     *  <td>你要改变的用户的id</td>
     * </tr>
     * <tr>
     *  <td>role</td>
     *  <td>你要改变的用户的角色</td>
     * </tr>
     * </table>
     *
     * @return 返回字符串,"OK"表示成功，“failed!”表示失败。
     */
    @RequestMapping("/updateRole")
    @CrossOrigin("*")
    public @ResponseBody String updateAdmin(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = null;
        Integer role = null;
        try {
            userId = jsonObject.getInteger("userId");
            role = jsonObject.getInteger("role");
            if (role == null || userId == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("你在 /user/updateRole 处的传入参数不正确！");
            e.printStackTrace();
            return "failed!";
        }

        userService.updateUserRole(userId, role);
        return "OK";
    }
}
