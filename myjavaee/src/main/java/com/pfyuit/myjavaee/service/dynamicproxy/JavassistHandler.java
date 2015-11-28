package com.pfyuit.myjavaee.service.dynamicproxy;

import java.lang.reflect.Method;

import javassist.util.proxy.MethodHandler;

/**
 * @author yupengfei
 */
public class JavassistHandler implements MethodHandler {

	private Object target;

	public JavassistHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Method arg2, Object[] arg3) throws Throwable {
		// TODO put your extra code here
		return arg1.invoke(target, arg3);
	}

}
