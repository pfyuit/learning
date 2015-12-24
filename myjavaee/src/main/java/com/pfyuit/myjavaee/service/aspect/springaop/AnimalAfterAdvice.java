package com.pfyuit.myjavaee.service.aspect.springaop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

/** 
 * @author yupengfei
 */
@Component("animalAfterAdvice")
public class AnimalAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("After eating...");
	}

}
