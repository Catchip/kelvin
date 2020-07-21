package grp.team7.kelvin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp.team7.kelvin.service.OrderService;
import grp.team7.kelvin.dao.DishDao;
import grp.team7.kelvin.dao.OrderItemDao;
import grp.team7.kelvin.entity.OrderItem;
import grp.team7.kelvin.entity.Dish;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderItemDao orderitemdao;

    @Autowired
    DishDao dishDao;

    @Override
    public List<OrderItem> getOrderItems(Integer orderId) {
        return orderitemdao.findByOrder(orderId);
    }

    @Override
    public int addOrderItems(List<OrderItem> orderItems, Integer orderId) {
        ListIterator<OrderItem> iter1 = orderItems.listIterator();
        List<Integer> dishIds = orderItems.stream().map(e -> e.getDishId()).collect(Collectors.toList());
        System.out.println(dishIds);
        List<Dish> dishes = dishDao.findByIdList(dishIds);
        System.out.println(dishes);
        ListIterator<Dish> iter2 = dishes.listIterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            OrderItem orderitem = iter1.next();
            Dish dish = iter2.next();
            orderitem.setOrderId(orderId);
            orderitem.setDishId(dish.getDishId());
            orderitem.setDishName(dish.getDishName());
            orderitem.setDishPrice(dish.getPrice());
            orderitem.setDishClass(dish.getDishClass());
        }
        orderitemdao.addByList(orderItems);
        return 1;
    }

    public int deleteOrderItem(Integer orderId, Integer dishId) {
        return orderitemdao.delete(orderId, dishId);
    }


}
