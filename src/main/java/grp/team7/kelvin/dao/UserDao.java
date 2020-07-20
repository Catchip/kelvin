package grp.team7.kelvin.dao;

import grp.team7.kelvin.entity.User;
import grp.team7.kelvin.entity.Dish;
import grp.team7.kelvin.entity.Shop;
import java.util.List;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

/**
* UserDao
*/
public interface UserDao {
    public User findById(Integer id);
    public User findByAccount(String userAccount);
    public int addUser(User user);
    public int deleteUser(Integer id);
    public int updateUser(User user);
    public List<User> findAll();
    public List<Dish> findDishCollectById(Integer id);
    public List<Shop> findShopCollectById(Integer id);
    public Integer findDishCollectByKeys(Integer userId, Integer dishId);
    public Integer findShopCollectByKeys(Integer userId, Integer shopId);
    public int addDishCollect(Integer userId, Integer dishId, Date collectDate);
    public int addShopCollect(Integer userId, Integer shopId, Date collectDate);
    public User findUserByAcAndPa(String userAccount, String userPasswordsha256);
    public Integer checkAdminRoleById(Integer id);
    public int updateUserRole(@Param ("id") Integer id, @Param("role") Integer  role);
    public int insertAdmin(@Param ("id") Integer id, @Param("role") Integer  role);
    public int deleteAdmin(Integer id);
}
