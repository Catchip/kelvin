package grp.team7.kelvin.dao;

import grp.team7.kelvin.entity.Order;

import java.net.InetAddress;
import java.util.List;
/**
* OrderDao
*/
public interface OrderDao {

    public List<Order> find(Order order);
    public List<Order> findByUser(Integer userId);
    public Order findById(Integer orderId);
    public Order findByKeys(Integer shopId, Integer dishId);
    public List<Order> findByShop(Integer shopId);
    public List<Order> findAll();
    public Order findByUUID(String uuid);
    public int updateOrder(Order order);
    public int addOrder(Order order);
    public int deleteOrder(Integer orderId);
    public Integer lastInsertId();
}
