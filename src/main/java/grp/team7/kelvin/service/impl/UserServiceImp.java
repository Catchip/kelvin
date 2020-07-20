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
    private UserDao userdao;

    @Autowired
    private ShopDao shopdao;

    @Autowired
    private OrderDao orderdao;


    @Override
    public int signUp(User user) {
        user.setUserPasswordsha256(SHA256Util.stringToSHA256(user.getUserPasswordsha256()));
        User user1 = userdao.findByAccount(user.getUserAccount());
        if (user1 != null) {
            return 0;
        }
        return userdao.addUser(user);
    }

    @Override
    public List<Shop> getShops(Integer userId) {
        return shopdao.findAllWithUser(userId);
    }

    @Override
    public List<Order> getOrders(Integer userId) {
        return orderdao.findByUser(userId);
    }

    @Override
    public User updateInformation(User user) {
        Date date = new Date();
        user.setUserUpdatetime(date);
        if (userdao.updateUser(user) == 1) {
            return userdao.findById(user.getUserId());
        }
        return null;
    }

    @Override
    public int updatePassword(User user) {
        Date date = new Date();
        user.setUserUpdatetime(date);
        user.setUserPasswordsha256(SHA256Util.stringToSHA256(user.getUserPasswordsha256()));

        return userdao.updateUser(user);
    }

    @Override
    public List<Dish> getDishCollect(Integer user_id) {
        return userdao.findDishCollectById(user_id);
    }

    @Override
    public List<Shop> getShopCollect(Integer user_id) {
        return userdao.findShopCollectById(user_id);
    }

    @Override
    public User signIn(String userAccount, String password) {
        return userdao.findUserByAcAndPa(userAccount, SHA256Util.stringToSHA256(password));
    }

    @Override
    public int addShop(Shop shop) {
        Date date = new Date();
        shop.setShopCreatetime(date);
        shop.setShopUpdatetime(date);
        return shopdao.addShop(shop);
    }

    @Override
    public Order addOrder(Order order) {
        //生成UUID
        //String uuid = "sdfsd";
        //order.setUuid(uuid);
        if (orderdao.addOrder(order) == 1) {
            Integer orderId = orderdao.lastInsertId();
            order.setOrderId(orderId);
            return order;
        }
        return null;
    }

    @Override
    public User getInformation(Integer userId) {
        return userdao.findById(userId);
    }

    @Override
    public int addDishCollect(Integer dishId, Integer userId) {

        return 1;
    }

    @Override
    public int addShopCollect(Integer shopId, Integer userId) {
        return 0;
    }

    /**
     * 检查用户的管理员身份
     * @param user 检查的用户类
     * @return 返回用户的角色编号，如果不是管理员就为null
     */
    @Override
    public Integer checkAdmin(int userId) {
        return userdao.checkAdminRoleById(userId);
    }

    /**
     * 修改用户的管理员身份，规定0为非管理员，1为普通管理员，2为超级管理员。
     * @param userId 需要修改的用户id
     * @param role 需要改成的用户身份
     */
    @Override
    public int updateUserRole(int userId, int role) {
        if (checkAdmin(userId) == null) {
            if (role == 0) {
                return 0;
            }
            return userdao.insertAdmin(userId, role);
        } else {
            if (role == 0) {
                return userdao.deleteAdmin(userId);
            }
            return userdao.updateUserRole(userId, role);
        }
    }

}
