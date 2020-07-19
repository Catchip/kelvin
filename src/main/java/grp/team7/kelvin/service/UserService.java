package grp.team7.kelvin.service;

import java.util.List;

import grp.team7.kelvin.entity.*;

public interface UserService {
    public int signUp(User user);
    public User updateInformation(User user);
    public User getInformation(Integer userId);
    public int updatePassword(User user);
    public List<Dish> getDishCollect(Integer user_Id);
    public List<Shop> getShopCollect(Integer user_Id); 
    public User signIn(String userAccount, String password);
    public List<Shop> getShops(Integer user_Id);
    public List<Order>  getOrders(Integer user_Id);
    public int addShop(Shop shop);
    public Order addOrder(Order order);
}
