package grp.team7.kelvin.service;

import java.util.List;

import grp.team7.kelvin.entity.Dish;
import grp.team7.kelvin.entity.Shop;

/**
 * CollectService
 */
public interface CollectService {

    public int addDishCollect(Integer dishId, Integer userId);
    public int addShopCollect(Integer shopId, Integer userId);
    public int getDishCollectStatus(Integer userId, Integer dishId);
    public int getShopCollectStatus(Integer userId, Integer shopId);
    public List<Dish> getDishCollect(Integer user_Id);
    public List<Shop> getShopCollect(Integer user_Id);

}
