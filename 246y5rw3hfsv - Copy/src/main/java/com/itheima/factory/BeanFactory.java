package com.itheima.factory;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;
import com.sun.org.apache.xpath.internal.objects.XObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.List;

/*
用于创建Service的代理对象的工厂
 */
@Component("beanFactory")
public class BeanFactory {
    @Resource(name = "accountService")
    private IAccountService accountService;

    @Resource(name = "transactionManager")
    private TransactionManager transactionManager;

    @Bean("proxyAccountService")
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*
                        添加事务的支持
                         */
                        Object rtValue = null;
                        try {
                            //开启事务
                            transactionManager.beginTransaction();
                            //执行操作
                            rtValue = method.invoke(accountService, args);
                            //提交事务
                            transactionManager.commit();
                            return rtValue;
                        } catch (Exception e) {
                            //回滚操作
                            transactionManager.rollback();
                            e.printStackTrace();
                        } finally {
                            //释放连接
                            transactionManager.release();
                        }
                        return rtValue;
                    }
                });
    }
}
