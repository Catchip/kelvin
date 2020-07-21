package grp.team7.kelvin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import grp.team7.kelvin.service.CollectService;
import grp.team7.kelvin.dao.UserDao;
import grp.team7.kelvin.entity.Dish;
import grp.team7.kelvin.entity.Shop;

public class CollectServiceImp implements CollectService {
    @Autowired
    UserDao userDao;

    @Override
    public List<Dish> getDishCollect(Integer user_id) {
        return userDao.findDishCollectById(user_id);
    }

    @Override
    public List<Shop> getShopCollect(Integer user_id) {
        return userDao.findShopCollectById(user_id);
    }

    @Override
    public int addDishCollect(Integer dishId, Integer userId) {
        Date date = new Date();
        if (userDao.findDishCollectByKeys(userId, dishId) == null)
            return userDao.addDishCollect(userId, dishId, date);
        else
            return 0;
    }

    @Override
    public int addShopCollect(Integer shopId, Integer userId) {
        Date date = new Date();
        if (userDao.findShopCollectByKeys(userId, shopId) == null)
            return userDao.addShopCollect(userId, shopId, date);
        else return 0;
    }

    @Override
    public int getDishCollectStatus(Integer userId, Integer dishId) {
        if (userDao.findDishCollectByKeys(userId, dishId) == null)
            return 0;
        else return 1;
    }

    @Override
    public int getShopCollectStatus(Integer userId, Integer shopId) {
        if (userDao.findShopCollectByKeys(userId, shopId) == null)
            return 0;
        else return 1;
    }
}
