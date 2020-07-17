package grp.team7.kelvin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

import grp.team7.kelvin.dao.UserDao;
import grp.team7.kelvin.entity.User;
import grp.team7.kelvin.entity.Dish;
import grp.team7.kelvin.entity.Shop;
import grp.team7.kelvin.utils.SHA256Util;

@Service
public class UserService {
    @Autowired
    private UserDao userdao;

    public User findUserById(Integer id){
        return userdao.findById(id);
    }

    public int addUser(User user){
        user.setUserPasswordsha256(SHA256Util.stringToSHA256(user.getUserPasswordsha256()));
        return userdao.addUser(user);
    }

    public int updateUser(User user){
        Date date = new Date();
        user.setUserUpdatetime(date);
        User user1 = userdao.findById(user.getUserId());
        if(!user1.getUserPasswordsha256().equals(SHA256Util.stringToSHA256(user.getUserPasswordsha256()))){
            user.setUserPasswordsha256(SHA256Util.stringToSHA256(user.getUserPasswordsha256()));
        }
        return userdao.updateUser(user);
    }

    public int deleteUser(Integer id){
        return userdao.deleteUser(id);
    }

    public List<User> getAllUser(){
        return userdao.findAll();
    }

    public List<Dish> getDishCollect(Integer user_id){
        return userdao.findDishCollectById(user_id);        
    }

    public List<Shop> getShopCollect(Integer user_id){
        return userdao.findShopCollectById(user_id);        
    }
    
    public User checkUser(String userAccount, String password){
        return userdao.checkUserPassword(userAccount, SHA256Util.stringToSHA256(password));
    }


}
