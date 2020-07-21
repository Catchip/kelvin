package grp.team7.kelvin.dao;


import grp.team7.kelvin.entity.Shop;

import java.util.List;
import java.util.Date;

import grp.team7.kelvin.entity.Dish;
/**
 * CollectDao
 */
public interface CollectDao {

    public List<Dish> findDishCollectById(Integer id);
    public List<Shop> findShopCollectById(Integer id);
    public Integer findDishCollectByKeys(Integer userId, Integer dishId);
    public Integer findShopCollectByKeys(Integer userId, Integer shopId);
    public int addDishCollect(Integer userId, Integer dishId, Date collectDate);
    public int addShopCollect(Integer userId, Integer shopId, Date collectDate);
    public int deleteDishCollect(Integer id);
    public int deleteShopCollect(Integer id);

}
