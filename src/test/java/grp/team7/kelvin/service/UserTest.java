package grp.team7.kelvin.service;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void testAdd() {
        User user = new User();
        user.setUserName("罗宏宇");
        user.setUserSex(0);
        user.setUserAccount("zty");
        user.setUserMail("123@123.com");
        user.setUserPasswordsha256("123456");
        user.setUserTelephone("423674123");

        if(userService.signUp(user)==1){
            System.out.println("sign up success");
        }else{
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
    public void testSignIn(){
        User user = userService.signIn("zty","123456");
        System.out.println(user);
    }

    @Test
    public void testAddShop(){
        Shop shop = new Shop();
        shop.setUserId(3);
        shop.setShopName("开饭了官方店");
        Date date = new Date();
        shop.setShopCreatetime(date);
        shop.setShopUpdatetime(date);
        userService.addShop(shop);
    }

    @Test void testAddOrder(){
        Order order = new Order();
        order.setShopId(1);
        order.setUserId(3);
        order.setMoney(123.213f);
        userService.addOrder(order);
        OrderItem orderitem = new OrderItem();
        orderitem.setDishId(1);
    }

}
