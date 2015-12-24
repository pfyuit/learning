package com.pfyuit.myjavaee.service.aspect.springaop;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

/** 
 * @author yupengfei
 */
public class AnimalStaticMethodMatcherPointcutAdvisor extends StaticMethodMatcherPointcutAdvisor {

	private static final long serialVersionUID = 7703491925255117739L;

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return "eat".equals(method.getName());
	}

}
