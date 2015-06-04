package com.bbs.actions;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectUserInfoAction {
	/*
	 * 定义Pointcut，Pointcut名称是，此方法不能有返回值和参数，该方法只是一个标识
	 * 
	 * Pointcut的内容是一个表达式，描述哪些对象的哪些方法
	 */
	@Pointcut("execution(public * insertUserInfoService(..))")
	public void fooExecution() {
	};
	/**
	 * 定义Advice，标识在那个切入点何处织入此方法
	 */
	@Before("fooExecution()")
	public void doBeforeOne() {
		System.out.println("aspect before re Service");
	}

	/**
	 * 定义Advice，标识在那个切入点何处织入此方法
	 */

	@After("fooExecution()")
	public void doAfterOne() {
		System.out.println("aspect after re Service");
	}
	
	/*
	 * 定义Pointcut，Pointcut名称是，此方法不能有返回值和参数，该方法只是一个标识
	 * 
	 * Pointcut的内容是一个表达式，描述哪些对象的哪些方法
	 */
	@Pointcut("execution(public * cheakUserInfoService(..))")
	public void fooExecution1() {
	};
	/**
	 * 定义Advice，标识在那个切入点何处织入此方法
	 */
	@Before("fooExecution1()")
	public void doBeforeOne1() {
		System.out.println("aspect before lo Service");
	}

	/**
	 * 定义Advice，标识在那个切入点何处织入此方法
	 */

	@After("fooExecution1()")
	public void doAfterOne1() {
		System.out.println("aspect after lo Service");
	}
}
