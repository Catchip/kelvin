package grp.team7.kelvin.dao;

import grp.team7.kelvin.entity.Order;
import java.util.List;
/**
* OrderDao
*/
public interface OrderDao {

    public List<Order> findByUser(Integer userId);
    public List<Order> findByShop(Integer shopId);
    public List<Order> findAll();
    public Order findByUUID(String UUID);
    public int updateOrder(Order order);
    public int addOrder(Order order);
    public int deleteOrder(Integer orderId);
}
