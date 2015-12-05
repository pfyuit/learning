package com.pfyuit.myjavaee.service.aop.springaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/aop/springaop/myjavaee-aop-springaop-test.xml" })
public class AdvisorDeclarativelyTest {

	@Autowired
	@Qualifier("testStaticMethodMatcherPointcutAdvisor")
	private Animal testStaticMethodMatcherPointcutAdvisor;

	@Autowired
	@Qualifier("testRegexpMethodPointcutAdvisor")
	private Animal testRegexpMethodPointcutAdvisor;

	@Autowired
	@Qualifier("testDefaultPointcutAdvisor")
	private Animal testDefaultPointcutAdvisor;

	@Test
	public void testStaticMethodMatcherPointcutAdvisor() {
		testStaticMethodMatcherPointcutAdvisor.eat();
	}

	@Test
	public void testRegexpMethodPointcutAdvisor() {
		testRegexpMethodPointcutAdvisor.eat();
	}

	@Test
	public void testDefaultPointcutAdvisor() {
		testDefaultPointcutAdvisor.eat();
	}

}
