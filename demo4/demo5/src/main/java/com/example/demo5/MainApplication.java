package com.example.demo5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//此注解表示SpringBoot启动类
@SpringBootApplication
// 此注解表示动态扫描DAO接口所在包，实际上不加下面这条语句也可以找到
@MapperScan("com.example.demo5")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}