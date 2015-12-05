package com.pfyuit.myjavaee.service.aop.springaop;

import org.aopalliance.aop.Advice;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author yupengfei
 */
public class AdviceProgrammaticallyTest {

	@Test
	public void testBeforeAdvice() {
		Animal target = new Dog();
		Advice advice = new AnimalBeforeAdvice();

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(advice);

		Animal proxy = (Animal) proxyFactory.getProxy();
		proxy.eat();
	}

	@Test
	public void testAfterAdvice() {
		Animal target = new Dog();
		Advice advice = new AnimalAfterAdvice();

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(advice);

		Animal proxy = (Animal) proxyFactory.getProxy();
		proxy.eat();
	}

	@Test
	public void testAroundAdvice() {
		Animal target = new Dog();
		Advice advice = new AnimalAroundAdvice();

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(advice);

		Animal proxy = (Animal) proxyFactory.getProxy();
		proxy.eat();
	}

	@Test(expected = RuntimeException.class)
	public void testThrowsAdvice() {
		Animal target = new Dog();
		Advice advice = new AnimalThrowsAdvice();

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(advice);

		Animal proxy = (Animal) proxyFactory.getProxy();
		proxy.sleep();
	}

}
