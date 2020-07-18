package grp.team7.kelvin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp.team7.kelvin.service.OrderService;
import grp.team7.kelvin.dao.OrderItemDao;
import grp.team7.kelvin.entity.OrderItem;

import java.util.List;
import java.util.ListIterator;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    OrderItemDao orderitemdao;
    
    @Override
    public List<OrderItem> getOrderItems(Integer orderId){
        return orderitemdao.findByOrder(orderId);    
    } 

    @Override
    public int addOrderItems(List<OrderItem> orderitems){
       ListIterator<OrderItem> iter = orderitems.listIterator(); 
       int flag;
       while(iter.hasNext()){
           OrderItem orderitem = iter.next();
           flag = orderitemdao.add(orderitem);
           if(flag == 0){//若存在插入失败，删除之前插入的
               while(iter.hasPrevious()){
                   OrderItem orderitem1 = iter.previous();
                   orderitemdao.delete(orderitem1.getOrderId(),orderitem1.getDishId())
               }
               return 0;
           }
       }
       return 1;
    }

    public int deleteOrderItem(Integer orderId, Integer dishId){
        orderitemdao.delete(Integer orderId,Integer dishId)
    }


}
