package com.pfyuit.myjavaee.service.aspect.springaop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

/**
 * @author yupengfei
 */
@Component("animalThrowsAdvice")
public class AnimalThrowsAdvice implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
		System.out.println("Rolling back...");
	}

}
