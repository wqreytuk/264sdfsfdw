package com.example.demo5;

import com.example.demo5.dao.UserDao;
import com.example.demo5.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class MyBatisTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        System.out.println(userDao.findAllUser());
    }
}