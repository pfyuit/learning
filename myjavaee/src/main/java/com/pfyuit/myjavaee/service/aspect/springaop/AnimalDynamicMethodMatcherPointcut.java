package com.pfyuit.myjavaee.service.aspect.springaop;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

/**
 * @author yupengfei
 */
public class AnimalDynamicMethodMatcherPointcut extends DynamicMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object[] args) {
		return "eat".equals(method.getName());
	}

}
