package grp.team7.kelvin.service;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import grp.team7.kelvin.entity.*;
import grp.team7.kelvin.service.UserService;
import grp.team7.kelvin.service.OrderService;
import grp.team7.kelvin.service.ShopService;
import grp.team7.kelvin.dao.*;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class UserTest {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderDao orderDao;

    @Test
    public void testAdd() {
        User user = new User();
        user.setUserName("罗宏宇");
        user.setUserSex(0);
        user.setUserAccount("zty");
        user.setUserMail("123@123.com");
        user.setUserPasswordsha256("123456");
        user.setUserTelephone("423674123");

        if (userService.signUp(user) == 1) {
            System.out.println("sign up success");
        } else {
            System.out.println("sign up fail");
        }
    }

    //@test
    //public void testfinduserbyid() {
    //user user = userservice.finduserbyid(1);
    //system.out.println(user);
    //}

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUserName("周天阳");
        user.setUserSex(1);
        user.setUserId(1);

        userService.updateInformation(user);
    }

    @Test
    public void testSignIn() {
        User user = userService.signIn("zty", "123456");
        System.out.println(user);
    }

    @Test
    public void testAddShop() {
        Shop shop = new Shop();
        shop.setUserId(3);
        shop.setShopName("开饭了官方店");
        Date date = new Date();
        shop.setShopCreatetime(date);
        shop.setShopUpdatetime(date);
        userService.addShop(shop);
    }

    @Test
    public void testAddOrder() {
        Order order = new Order();
        order.setShopId(1);
        order.setUserId(3);
        order.setMoney(123.213f);
        userService.addOrder(order);
        OrderItem orderitem = new OrderItem();
        orderitem.setDishId(1);
    }

    @Test
    public void testListToJson() {
        Order order = new Order();
        order.setShopId(1);
        order.setUserId(3);
        order.setMoney(123.213f);
        Order order1 = new Order();
        order1.setShopId(1);
        order1.setUserId(3);
        order1.setMoney(123.213f);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        System.out.println(JSON.toJSONString(orders));
    }

    @Test
    public void testOrderDao() {
        Order order = new Order();
        order.setShopId(3);
        order.setUserId(3);
        orderDao.addOrder(order);
        System.out.println(orderDao.lastInsertId());
    }

}
