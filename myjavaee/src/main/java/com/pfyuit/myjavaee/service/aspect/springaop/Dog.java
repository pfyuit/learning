package com.pfyuit.myjavaee.service.aspect.springaop;

import org.springframework.stereotype.Component;

/**
 * @author yupengfei
 */
@Component("target")
public class Dog implements Animal {

	@Override
	public void eat() {
		System.out.println("Dog eat bone...");
	}

	@Override
	public void sleep() {
		System.out.println("Dog sleep...");
		throw new RuntimeException();
	}

}
