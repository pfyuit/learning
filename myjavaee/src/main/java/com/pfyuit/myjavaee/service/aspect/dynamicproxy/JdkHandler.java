package com.pfyuit.myjavaee.service.aspect.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yupengfei
 */
public class JdkHandler implements InvocationHandler {

	private Object target;

	public JdkHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO put your extra code here
		return method.invoke(target, args);
	}

}
