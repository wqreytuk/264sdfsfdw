package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itheima.dao")
public class Springboot2MybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2MybatisDemoApplication.class, args);
    }
}

