package grp.team7.kelvin.service;


import grp.team7.kelvin.entity.*;

import java.util.List;
/**
 * OrderService
 */
public interface OrderService {

    public List<OrderItem> getOrderItems(Integer orderId); 
    public int addOrderItems(List<OrderItem> orderitems);
    public int deleteOrderItem(Integer orderId, Integer dishId);
}
