package com.pfyuit.myjavaee.service.aspect.springaop;

import org.aopalliance.aop.Advice;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import com.pfyuit.myjavaee.service.aspect.springaop.Animal;
import com.pfyuit.myjavaee.service.aspect.springaop.AnimalAroundAdvice;
import com.pfyuit.myjavaee.service.aspect.springaop.AnimalDefaultPointcutAdvisor;
import com.pfyuit.myjavaee.service.aspect.springaop.AnimalDynamicMethodMatcherPointcut;
import com.pfyuit.myjavaee.service.aspect.springaop.AnimalRegexpMethodPointcutAdvisor;
import com.pfyuit.myjavaee.service.aspect.springaop.AnimalStaticMethodMatcherPointcutAdvisor;
import com.pfyuit.myjavaee.service.aspect.springaop.Dog;

/**
 * @author yupengfei
 */
public class AdvisorProgrammaticallyTest {

	@Test
	public void testStaticMethodMatcherPointcutAdvisor() {
		Animal target = new Dog();
		Advice advice = new AnimalAroundAdvice();

		// Set up a advisor.
		StaticMethodMatcherPointcutAdvisor advisor = new AnimalStaticMethodMatcherPointcutAdvisor();
		advisor.setAdvice(advice);

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvisor(advisor);

		Animal proxy = (Animal) proxyFactory.getProxy();
		proxy.eat();
	}

	@Test
	public void testRegexpMethodPointcutAdvisor() {
		Animal target = new Dog();
		Advice advice = new AnimalAroundAdvice();

		// Set up a advisor.
		RegexpMethodPointcutAdvisor advisor = new AnimalRegexpMethodPointcutAdvisor();
		advisor.setAdvice(advice);
		advisor.setPattern(".*eat*.");

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvisor(advisor);

		Animal proxy = (Animal) proxyFactory.getProxy();
		proxy.eat();
	}
	
	@Test
	public void testDefaultPointcutAdvisor() {
		Animal target = new Dog();
		Advice advice = new AnimalAroundAdvice();

		// Set up a advisor.
		DynamicMethodMatcherPointcut pointcut = new AnimalDynamicMethodMatcherPointcut();		
		DefaultPointcutAdvisor advisor = new AnimalDefaultPointcutAdvisor();
		advisor.setPointcut(pointcut);
		advisor.setAdvice(advice);

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvisor(advisor);

		Animal proxy = (Animal) proxyFactory.getProxy();
		proxy.eat();
	}

}
