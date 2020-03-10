package com.itheima.utils;

/*
用于记录日志的工具类，了里面提供了一些公共方法
 */

public class Logger {
	//用于打印日志，计划让其在切入点方法执行之前执行，切入点方法就是业务层的方法
	public void printLog() {
		System.out.println("Logger类的printLog方法开始记录日志");
	}
}
