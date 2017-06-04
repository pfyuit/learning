package com.pfyuit.myjavaee.service.aspect.springaop;

import org.aopalliance.aop.Advice;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

import com.pfyuit.myjavaee.service.aspect.springaop.Animal;
import com.pfyuit.myjavaee.service.aspect.springaop.AnimalAfterAdvice;
import com.pfyuit.myjavaee.service.aspect.springaop.AnimalAroundAdvice;
import com.pfyuit.myjavaee.service.aspect.springaop.AnimalBeforeAdvice;
import com.pfyuit.myjavaee.service.aspect.springaop.AnimalThrowsAdvice;
import com.pfyuit.myjavaee.service.aspect.springaop.Dog;

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
