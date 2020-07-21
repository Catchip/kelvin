package grp.team7.kelvin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

import grp.team7.kelvin.dao.UserDao;
import grp.team7.kelvin.dao.ShopDao;
import grp.team7.kelvin.dao.DishDao;
import grp.team7.kelvin.dao.OrderDao;
import grp.team7.kelvin.dao.OrderItemDao;
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

    @Autowired
    private DishDao dishDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Override
    public int signUp(User user) {
        String passwordsha256 = SHA256Util.stringToSHA256(user.getUserPasswordsha256());
        user.setUserPasswordsha256(passwordsha256);
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
    public int getUserRole(int userId) {
        Integer result =  userDao.checkAdminRoleById(userId);
        if (result == null) {
            return 0;
        }
        return result;
    }

    @Override
    public int updateUserRole(int userId, int role) {
        if (getUserRole(userId) == 0) {
            if (role == 0) {
                return 0;
            }
            return userDao.insertAdmin(userId, role);
        } else {
            if (role == 0) {
                return userDao.deleteAdmin(userId);
            }
            return userDao.updateUserRole(userId, role);
        }
    }

    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    @Override
    public int deleteShop(Integer shopId) {
        return shopDao.deleteShop(shopId);
    }

    @Override
    public List<Shop> getAllShops() {
        return shopDao.findAll();
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderItemDao.deleteByOrder(orderId);
        orderDao.deleteOrder(orderId);
    }
}
