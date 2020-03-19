package com.itheima;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//用户的业务层测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {
    @Autowired
    private IUserService userService;

    @Test
    public void testFindAll() {
        List<User> users = userService.findAll();
        System.out.println(users);
    }

    @Test
    public void testFindById() {
        User user = userService.findById(1);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user1 = userService.findById(1);
        System.out.println("修改之前的用户" + user1);

        user1.setAge(1234);
        userService.updateUser(user1);

        User user2 = userService.findById(1);
        System.out.println("修改之后的用户" + user2);
    }
}
