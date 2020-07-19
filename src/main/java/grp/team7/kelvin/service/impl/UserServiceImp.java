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
public class UserServiceImp implements UserService{
    @Autowired
    private UserDao userdao;

    @Autowired
    private ShopDao shopdao;

    @Autowired
    private OrderDao orderdao;


    @Override
    public int signUp(User user){
        user.setUserPasswordsha256(SHA256Util.stringToSHA256(user.getUserPasswordsha256()));
        User user1 = userdao.findByAccount(user.getUserAccount());
        if(user1 != null){
            return 0;
        }
        return userdao.addUser(user);
    }

    @Override
    public List<Shop> getShops(Integer userId){
        return shopdao.findAllWithUser(userId);

    }

    @Override
    public List<Order> getOrders(Integer userId){
        return orderdao.findByUser(userId);
    }

    @Override
    public int updateInformation(User user){
        Date date = new Date();
        user.setUserUpdatetime(date);
        return userdao.updateUser(user);
    }

    @Override
    public int updatePassword(User user){
        Date date = new Date();
        user.setUserUpdatetime(date);
        user.setUserPasswordsha256(SHA256Util.stringToSHA256(user.getUserPasswordsha256()));

        return userdao.updateUser(user);
    }

    @Override
    public List<Dish> getDishCollect(Integer user_id){
        return userdao.findDishCollectById(user_id);        
    }

    @Override
    public List<Shop> getShopCollect(Integer user_id){
        return userdao.findShopCollectById(user_id);        
    }
    
    @Override
    public User signIn(String userAccount, String password){
        return userdao.findUserByAcAndPa(userAccount, SHA256Util.stringToSHA256(password));
    }
}
