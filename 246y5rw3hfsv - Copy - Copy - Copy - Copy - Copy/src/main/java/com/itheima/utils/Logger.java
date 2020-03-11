package com.itheima.utils;

/*
用于记录日志的工具类，了里面提供了一些公共方法
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect//该注解表示当前类是一个切面
public class Logger {
	//同xml配置一样，减少冗余
	@Pointcut("execution(public void com.itheima.service.impl.AccountServiceImpl.saveAccount())")
	public void pt1(){}


	//前置通知方法
//	@Before("pt1()")
	public void beforePrintLog() {
		System.out.println("前置通知方法Logger类的beforePrintLog方法开始记录日志");
	}


	//后置通知方法
//	@AfterReturning("pt1()")
	public void afterReturningPrintLog() {
		System.out.println("后置通知方法Logger类的afterReturningPrintLog方法开始记录日志");
	}


	//异常通知方法
//	@AfterThrowing("pt1()")
	public void afterThrowingPrintLog() {
		System.out.println("异常通知方法Logger类的afterThrowingPrintLog方法开始记录日志");
	}


	//最终通知方法
//	@After("pt1()")
	public void afterPrintLog() {
		System.out.println("最终通知方法Logger类的afterPrintLog方法开始记录日志");
		System.out.println();
	}

//但我们配置了环绕通知之后，切入点方法没有执行，通知方法却执行了
//	通过与动态代理中的代码的对比，发现动态代理的代码中明确制定了要调用哪一个切入点方法，而且我们的配置中并没有
//	解决：
//		spring框架提供了一个接口：
//		ProceedingJoinPoint
//			此方法就相当于明确调用切入点方法
//			该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用

	//环绕通知其实就是spring为我们提供的使用代码控制通知方法何时执行的方式
	@Around("pt1()")
	public Object aroundPrintLog(ProceedingJoinPoint pjp) {
		Object rtValue = null;
		try {
			Object[] args = pjp.getArgs();//得到方法执行所需的参数
			System.out.println("前置、Logger类的aroundPrintLog方法开始记录日志");

			rtValue = pjp.proceed(args);//明确调用业务层方法

			System.out.println("后置、Logger类的aroundPrintLog方法开始记录日志");
		} catch (Throwable t) {
			System.out.println("异常、Logger类的aroundPrintLog方法开始记录日志");
			throw new RuntimeException(t);
		} finally {

			System.out.println("最终、Logger类的aroundPrintLog方法开始记录日志");
		}
		return rtValue;
	}
}
