package com.itheima;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//该注解表明当前类为SpringBoot引导类
@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
//        run方法表示运行SpringBoot的引导类  run参数就是SpringBoot引导类的字节码对象
//        这个run的参数可以是其他类，只要加上SpringBootApplication注解即可
        SpringApplication.run(MySpringBootApplication.class);
    }
}
