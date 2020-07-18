package grp.team7.kelvin.dao;

import grp.team7.kelvin.entity.Dish;
import java.util.List;
/**
* DishDao
*/
public interface DishDao {

    public List<Dish> findAllWithShop(Integer shopId);
    public Dish findById(Integer dishId);
    public List<Dish> findAllWithClass(String dishClass);
    public List<Dish> findAllWithShopAndClass(Integer shopId, String dishClass);
    public List<Dish> findAllByPrice(Float min, Float max);
    public int addDish(Dish dish);
    public int deleteDish(Integer dishId);
    public int updateDish(Dish dish);
}
