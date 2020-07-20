package grp.team7.kelvin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

import grp.team7.kelvin.dao.UserDao;
import grp.team7.kelvin.dao.ShopDao;
import grp.team7.kelvin.dao.OrderDao;
import grp.team7.kelvin.entity.*;
import grp.team7.kelvin.utils.SHA256Util;
import grp.team7.kelvin.service.UserService;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private OrderDao orderDao;


    @Override
    public int signUp(User user) {
        user.setUserPasswordsha256(SHA256Util.stringToSHA256(user.getUserPasswordsha256()));
        User user1 = userDao.findByAccount(user.getUserAccount());
        if (user1 != null) {
            return 0;
        }
        return userDao.addUser(user);
    }

    @Override
    public List<Shop> getShops(Integer userId) {
        return shopDao.findAllWithUser(userId);
    }

    @Override
    public List<Order> getOrders(Integer userId) {
        return orderDao.findByUser(userId);
    }

    @Override
    public User updateInformation(User user) {
        Date date = new Date();
        user.setUserUpdatetime(date);
        if (userDao.updateUser(user) == 1) {
            return userDao.findById(user.getUserId());
        }
        return null;
    }

    @Override
    public int updatePassword(User user) {
        Date date = new Date();
        user.setUserUpdatetime(date);
        user.setUserPasswordsha256(SHA256Util.stringToSHA256(user.getUserPasswordsha256()));

        return userDao.updateUser(user);
    }

    @Override
    public List<Dish> getDishCollect(Integer user_id) {
        return userDao.findDishCollectById(user_id);
    }

    @Override
    public List<Shop> getShopCollect(Integer user_id) {
        return userDao.findShopCollectById(user_id);
    }

    @Override
    public User signIn(String userAccount, String password) {
        return userDao.findUserByAcAndPa(userAccount, SHA256Util.stringToSHA256(password));
    }

    @Override
    public int addShop(Shop shop) {
        Date date = new Date();
        shop.setShopCreatetime(date);
        shop.setShopUpdatetime(date);
        return shopDao.addShop(shop);
    }

    @Override
    public Order addOrder(Order order) {
        //生成UUID
        //String uuid = "sdfsd";
        //order.setUuid(uuid);
        if (orderDao.addOrder(order) == 1) {
            Integer orderId = orderDao.lastInsertId();
            order.setOrderId(orderId);
            return order;
        }
        return null;
    }

    @Override
    public User getInformation(Integer userId) {
        return userDao.findById(userId);
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
