package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
和事务管理相关的工具类，它包含了开启事务、提交事务、回滚事务和释放连接
 */
@Component("transactionManager")
@Aspect//该注解表示当前类是一个切面
public class TransactionManager {
    @Resource(name = "connectionUtils")
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.itheima.service.impl..*(..))")
    public void pt1(){}

    /*
    开启事务
    */
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    提交事务
     */
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    回滚事务
     */
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    释放连接
     */
    public void release() {
        try {
            //将连接归还到连接池中
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需的参数
            beginTransaction();

            rtValue = pjp.proceed(args);//明确调用业务层方法

            commit();
        } catch (Throwable t) {
            rollback();
            throw new RuntimeException(t);
        } finally {
            release();
        }
        return rtValue;
    }
}
