package grp.team7.kelvin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp.team7.kelvin.service.CollectService;
import grp.team7.kelvin.dao.CollectDao;
import grp.team7.kelvin.entity.Dish;
import grp.team7.kelvin.entity.Shop;

@Service
public class CollectServiceImp implements CollectService {
    @Autowired
    private CollectDao collectDao;

    @Override
    public List<Dish> getDishCollect(Integer user_id) {
        return collectDao.findDishCollectById(user_id);
    }

    @Override
    public List<Shop> getShopCollect(Integer user_id) {
        return collectDao.findShopCollectById(user_id);
    }

    @Override
    public int addDishCollect(Integer dishId, Integer userId) {
        Date date = new Date();
        if (collectDao.findDishCollectByKeys(userId, dishId) == null)
            return collectDao.addDishCollect(userId, dishId, date);
        else
            return 0;
    }

    @Override
    public int addShopCollect(Integer shopId, Integer userId) {
        Date date = new Date();
        if (collectDao.findShopCollectByKeys(userId, shopId) == null)
            return collectDao.addShopCollect(userId, shopId, date);
        else return 0;
    }

    @Override
    public int getDishCollectStatus(Integer userId, Integer dishId) {
        if (collectDao.findDishCollectByKeys(userId, dishId) == null)
            return 0;
        else return 1;
    }

    @Override
    public int getShopCollectStatus(Integer userId, Integer shopId) {
        if (collectDao.findShopCollectByKeys(userId, shopId) == null)
            return 0;
        else return 1;
    }

    @Override
    public int deleteShopCollect(Integer id) {
        return collectDao.deleteShopCollect(id);
    }

    @Override
    public int deleteDishCollect(Integer id) {
        return collectDao.deleteDishCollect(id);
    }
}
