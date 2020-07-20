package grp.team7.kelvin.dao;

import grp.team7.kelvin.entity.OrderItem;
import java.util.List;

/**
* OrderItemDao
*/

public interface OrderItemDao {

    public List<OrderItem> findByOrder(Integer orderId);
    public int add(OrderItem orderItem);
    public int addByList(List<OrderItem> orderItems);
    public int update(OrderItem orderItem);
    public int delete (Integer orderId, Integer dishId);
    public int deleteByOrder(Integer orderId);
}
