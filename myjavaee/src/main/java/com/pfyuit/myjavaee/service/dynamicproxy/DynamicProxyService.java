package com.pfyuit.myjavaee.service.dynamicproxy;

import javassist.CannotCompileException;
import javassist.NotFoundException;

/**
 * @author yupengfei
 */
public interface DynamicProxyService {

	public UserService createJdkDynamicProxy(UserService target);

	public UserService createCGlibDynamicProxy(UserService target);

	public UserService createJavassistDynamicProxyByByteCode(UserService target) throws InstantiationException, IllegalAccessException,
			NotFoundException, CannotCompileException, NoSuchFieldException, SecurityException;

	public UserService createJavassistDynamicProxy(UserService target) throws InstantiationException, IllegalAccessException;

	public UserService createAsmDynamicProxy(UserService target) throws NoSuchFieldException, SecurityException, InstantiationException,
			IllegalAccessException;

}
