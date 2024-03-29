package com.itheima.test;


import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //执行方法
        as.saveAccount();
        as.updateAccount(1);
        as.deleteAccount();
    }
}
