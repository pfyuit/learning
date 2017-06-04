package com.pfyuit.myjavaee.service.aspect.springaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @author yupengfei
 */
@Component("animalAroundAdvice")
public class AnimalAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Before eating...");
		Object obj = invocation.proceed();
		System.out.println("After eating...");
		return obj;
	}

}
