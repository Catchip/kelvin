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
    public int addDishCollect(Integer dishId, Integer userId);
    public int addShopCollect(Integer shopId, Integer userId);
    public int getDishCollectStatus(Integer userId, Integer dishId);
    public int getShopCollectStatus(Integer userId, Integer shopId);

    /**
     * 获得用户的管理员身份
     * @param user 检查的用户类
     * @return 返回用户的角色编号。规定0为非管理员，1为普通管理员，2为超级管理员。
     */
    public int getUserRole(int userId);

    /**
     * 修改用户的管理员身份
     * @param userId 需要修改的用户id
     * @param role 需要改成的用户身份。0为非管理员，1为普通管理员，2为超级管理员。
     */
    public int updateUserRole(int userId, int role);
}
