package grp.team7.kelvin.dao;

import grp.team7.kelvin.entity.Shop;
import java.util.List;


/**
* ShopDao
*/
public interface ShopDao {

    public Shop findById(Integer id);
    public List<Shop> find(Shop shop);
    public int addShop(Shop shop);
    public int deleteShop(Integer id);
    public int updateShop(Shop shop);
    public List<Shop> findAll();
    public List<Shop> findAllWithUser(Integer userId);
}
