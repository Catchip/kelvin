package grp.team7.kelvin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import grp.team7.kelvin.entity.User;
import grp.team7.kelvin.service.UserService;

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
        user.setUserAccount("lhy");
        user.setUserMail("123@123.com");
        user.setUserPasswordsha256("123456");
        user.setUserTelephone("423674123");

        userService.addUser(user);
    }

    @Test
    public void testFindUserById() {
        User user = userService.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUserName("周天阳");
        user.setUserSex(1);

        userService.updateUser(user);
    }

}
