package com.example.demo5;

import com.example.demo5.dao.UserDao;
import com.example.demo5.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class JpaTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        System.out.println(userRepository.findAll());
    }
}