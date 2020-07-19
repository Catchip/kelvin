package grp.team7.kelvin.dao;

import grp.team7.kelvin.entity.OrderItem;
import java.util.List;

/**
* OrderItemDao
*/

public interface OrderItemDao {

    public List<OrderItem> findByOrder(Integer orderId);
    public int add(OrderItem orderitem);
    public int update(OrderItem orderitem);
    public int delete(Integer orderId, Integer dishId);
    public int deleteByOrder(Integer orderId);
}
