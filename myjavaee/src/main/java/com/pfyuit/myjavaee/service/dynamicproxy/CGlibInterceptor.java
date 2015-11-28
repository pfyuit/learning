package com.pfyuit.myjavaee.service.dynamicproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author yupengfei
 */
public class CGlibInterceptor implements MethodInterceptor {

	private Object target;

	public CGlibInterceptor(Object target) {
		this.target = target;
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO put your extra code here
		return arg1.invoke(target, arg2);
	}

}
