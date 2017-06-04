package com.pfyuit.myjavaee.service.aspect.springaop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

/** 
 * @author yupengfei
 */
@Component("animalBeforeAdvice")
public class AnimalBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Before eating...");
	}

}
