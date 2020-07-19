package grp.team7.kelvin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp.team7.kelvin.service.ShopService;
import grp.team7.kelvin.entity.*;
import grp.team7.kelvin.dao.*;

import java.util.List;

@Service
public class ShopServiceImp implements ShopService {

    @Autowired
    private DishDao dishdao;

    @Autowired
    private OrderDao orderdao;

    @Override
    public List<Dish> getDishes(Integer shopId) {
        return dishdao.findAllWithShop(shopId);
    }

    @Override
    public List<Order> getOrders(Integer shopId) {
        return orderdao.findByShop(shopId);
    }

    @Override
    public int addDish(Dish dish) {
        return dishdao.addDish(dish);
    }

    @Override
    public int updateDishInfo(Dish dish) {
        return dishdao.updateDish(dish);
    }

    @Override
    public int deleteDish(Integer dishId) {
        return dishdao.deleteDish(dishId);
    }

    @Override
    public int putOnDish(Integer dishId) {
        Dish dish = new Dish();
        dish.setDishId(dishId);
        Boolean x = true;
        dish.setStatus(x);
        return dishdao.updateDish(dish);
    }

    @Override
    public int pullDownDish(Integer dishId) {
        Dish dish = new Dish();
        dish.setDishId(dishId);
        Boolean x = true;
        dish.setStatus(x);
        return dishdao.updateDish(dish);
    }
}
