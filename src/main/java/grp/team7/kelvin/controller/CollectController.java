package grp.team7.kelvin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import grp.team7.kelvin.service.impl.CollectServiceImp;
import grp.team7.kelvin.entity.*;

@Controller
@RequestMapping(value = "/collect", produces = "application/json;charset=utf-8")
public class CollectController {
    @Autowired
    private CollectServiceImp collectService;


    @RequestMapping("/add")
    public @ResponseBody String addCollect(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = jsonObject.getInteger("userId");
        Integer dishId = jsonObject.getInteger("dishId");
        Integer shopId = jsonObject.getInteger("shopId");
        int flag = 1;
        if (dishId != null)
            flag = collectService.addDishCollect(dishId, userId);
        else
            flag = collectService.addShopCollect(shopId, userId);

        if (flag == 1) return "OK";
        else return "NOT OK";
    }

    @RequestMapping("/delete")
    public @ResponseBody String deleteCollect(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer dishColletId = jsonObject.getInteger("dishCollectId");
        Integer shopCollectId = jsonObject.getInteger("shopCollectId");
        int flag = 1;
        if (dishColletId != null)
            flag = collectService.deleteDishCollect(dishColletId);
        else if (shopCollectId != null)
            flag = collectService.deleteShopCollect(shopCollectId);
        else return "NOT OK";

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
            List<Shop> shops = collectService.getShopCollect(userId);
            result = JSON.toJSONString(shops);
        } else {
            List<Dish> dishes = collectService.getDishCollect(userId);
            result = JSON.toJSONString(dishes);
        }
        return result;
    }

    /**
     * 确认某个用户是否收藏了某个商品或店家
     * @param {"userId":1,"shopId":1}或{"userId":1,"dishId":1}
     */
    @RequestMapping("/confirm")
    public @ResponseBody String getShopCollectStatus(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = jsonObject.getInteger("userId");
        Integer shopId = jsonObject.getInteger("shopId");
        Integer dishId = jsonObject.getInteger("dishId");
        int flag;
        if (shopId != null) {
            flag = collectService.getShopCollectStatus(userId, shopId);
        } else if (dishId != null) {
            flag = collectService.getDishCollectStatus(userId, dishId);
        } else {
            return "param fault";
        }
        if (flag == 1 )
            return "yes";
        else return "no";
    }

}
