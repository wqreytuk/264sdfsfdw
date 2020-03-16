package com.example.demo5;

import com.example.demo5.domain.User;
import com.example.demo5.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class RedisTest {
    @Autowired//这个泛型是key，value，这里我们使用String、String
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws JsonProcessingException {
//        从redis中获得数据  数据形式是json字符串
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();
//        判断redis中是否存在数据
        if(null == userListJson) {
//        不存在数据则从原始数据库中查询
            List<User> res = userRepository.findAll();
//            将查询出的数据存储到redis缓存中
//            将list集合转换成json字符串   使用jackson进行转换
            ObjectMapper objectMapper = new ObjectMapper();
            userListJson =  objectMapper.writeValueAsString(res);
            redisTemplate.boundValueOps("user.findAll").set(userListJson);
            System.out.println("==============从数据库中获取的数据===================");
        } else {
            System.out.println("==============从redis缓存中获取的数据===================");
        }

//        将返回的数据在控制台中输出
        System.out.println(userListJson);
    }
}