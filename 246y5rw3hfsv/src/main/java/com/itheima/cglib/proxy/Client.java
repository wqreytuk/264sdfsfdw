package com.itheima.cglib.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //在下面的匿名内部类中需要访问producer对象，所以需要使用final关键字进行修饰
        final Producer producer = new Producer();

       /*
       动态代理
        特点：
            字节码随用随创建、随用随加载
        作用：
            不修改源码的基础上对方法进行增强
        分类：
            基于接口的动态代理
            基于子类的动态代理
        基于接口的动态代理
            涉及的类：Enhancer
            提供者：第三方cglib库
        如何创建代理对象：
            使用Enhancer类中的create方法
        创建代理对象的要求：
            被代理类不能使最终类，也就是该类不能被final修饰，不然就无法创建子类了
        create方法的参数：
            Class：字节码
                它是用于指定被代理对象的字节码
                    固定写法：被代理对象.getClass()
            Callback：用于提供增强的代码
                Callback是一个接口，通常情况下我们编写其子接口MethodInterceptor
                的实现类，以匿名内部类的方式编写
        */
        Producer proxyProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /*
            执行被代理对象的任何方法都会经过该方法
                proxy
                method
                args
                    以上三个参数和基于接口的动态代理是一样的
                methodProxy
                    当前执行方法的代理对象
             */

            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //提供增强的代码
                Object returnValue = null;
                //获取方法执行的参数
                Float money = (Float)objects[0];
                //判断当前是否为sale方法
                if("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money*0.8f);
                }
                return returnValue;
            }
        });
        proxyProducer.saleProduct(10000);
    }
}
