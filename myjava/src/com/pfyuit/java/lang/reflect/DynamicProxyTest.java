package com.pfyuit.java.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		PerformanceHandler performanceHandler = new PerformanceHandler(userService);
		LoggingHandler loggingHandler = new LoggingHandler(userService);

		UserService proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), performanceHandler);
		proxy.test("pfyuit");

		proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), loggingHandler);
		proxy.test("pfyuit");
	}
}

interface UserService {

	public void test(String str);

}

class UserServiceImpl implements UserService {

	public void test(String str) {
		System.out.println("hello: " + str);
	}

}

class PerformanceHandler implements InvocationHandler {

	private Object target;

	public PerformanceHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long current = System.currentTimeMillis();
		Object result = method.invoke(target, args);
		System.out.println("Method cost " + (System.currentTimeMillis() - current) + " ms");
		System.out.println();
		return result;
	}

}

class LoggingHandler implements InvocationHandler {

	private Object target;

	public LoggingHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Method " + method.getName() + " started");
		Object result = method.invoke(target, args);
		System.out.println("Method " + method.getName() + " ended");
		System.out.println();
		return result;
	}

}
