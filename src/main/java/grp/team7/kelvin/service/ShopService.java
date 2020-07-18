package grp.team7.kelvin.service;

import grp.team7.kelvin.entity.*;
import java.util.List;
/**
 * ShopService
 */
public interface ShopService {

    public List<Dish> getDishes(Integer shopId);
    public List<Order> getOrders(Integer shopId);
    public int addDish(Dish dish);
    public int deleteDish(Integer dishId);
    public int updateDishInfo(Dish dish);
    public int putOnDish(Integer dishId);
    public int pullDownDish(Integer dishId);
}
