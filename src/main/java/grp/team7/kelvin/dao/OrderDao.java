package grp.team7.kelvin.dao;

import grp.team7.kelvin.entity.Order;
/**
* OrderDao
*/
public interface OrderDao {

	public Order findByUser(Integer userId);
	public Order findByShop(Integer shopId);
	public Order checkOrder(String UUID);
	public int addOrder(Order order);
	public int deleteOrder(Integer orderId);
}
