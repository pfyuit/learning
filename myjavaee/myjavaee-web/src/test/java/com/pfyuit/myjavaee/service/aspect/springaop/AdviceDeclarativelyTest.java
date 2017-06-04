package com.pfyuit.myjavaee.service.aspect.springaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfyuit.myjavaee.service.aspect.springaop.Animal;

/**
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/aspect/springaop/myjavaee-aspect-springaop-test.xml" })
public class AdviceDeclarativelyTest {

	@Autowired
	@Qualifier("animalBeforeAdviceTest")
	private Animal animalBeforeAdvice;

	@Autowired
	@Qualifier("animalAfterAdviceTest")
	private Animal animalAfterAdvice;

	@Autowired
	@Qualifier("animalAroundAdviceTest")
	private Animal animalAroundAdvice;

	@Autowired
	@Qualifier("animalThrowsAdviceTest")
	private Animal animalThrowsAdvice;

	@Test
	public void testBeforeAdvice() {
		animalBeforeAdvice.eat();
	}

	@Test
	public void testAfterAdvice() {
		animalAfterAdvice.eat();
	}

	@Test
	public void testAroundAdvice() {
		animalAroundAdvice.eat();
	}

	@Test(expected = RuntimeException.class)
	public void testThrowsAdvice() {
		animalThrowsAdvice.sleep();
	}

}
