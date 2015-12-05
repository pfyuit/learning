package com.pfyuit.myjavaee.service.aop.dynamicproxy;

import javassist.CannotCompileException;
import javassist.NotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pfyuit.myjavaee.service.aop.dynamicproxy.DynamicProxyService;
import com.pfyuit.myjavaee.service.aop.dynamicproxy.DynamicProxyServiceImpl;
import com.pfyuit.myjavaee.service.aop.dynamicproxy.UserService;
import com.pfyuit.myjavaee.service.aop.dynamicproxy.UserServiceImpl;

/**
 * @author yupengfei
 */
public class DynamicProxyServiceTest {

	private static DynamicProxyService dynamicProxyService;

	@BeforeClass
	public static void init() {
		dynamicProxyService = new DynamicProxyServiceImpl();
	}

	@Test
	public void testcCreateJdkDynamicProxy() {
		UserService target = new UserServiceImpl();
		UserService userService = dynamicProxyService.createJdkDynamicProxy(target);
		System.out.println(userService.sayHello("pfyuit"));
	}

	@Test
	public void testCreateCGlibDynamicProxy() {
		UserService target = new UserServiceImpl();
		UserService userService = dynamicProxyService.createCGlibDynamicProxy(target);
		System.out.println(userService.sayHello("pfyuit"));
	}

	@Test
	public void createJavassistDynamicProxyByByteCode() throws InstantiationException, IllegalAccessException, NotFoundException,
			CannotCompileException, NoSuchFieldException, SecurityException {
		UserService target = new UserServiceImpl();
		UserService userService = dynamicProxyService.createJavassistDynamicProxyByByteCode(target);
		System.out.println(userService.sayHello("pfyuit"));
	}

	@Test
	public void createJavassistDynamicProxy() throws InstantiationException, IllegalAccessException {
		UserService target = new UserServiceImpl();
		UserService userService = dynamicProxyService.createJavassistDynamicProxy(target);
		System.out.println(userService.sayHello("pfyuit"));
	}

	@Test
	public void createAsmDynamicProxy() throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
		UserService target = new UserServiceImpl();
		UserService userService = dynamicProxyService.createAsmDynamicProxy(target);
		System.out.println(userService.sayHello("pfyuit"));
	}

}
