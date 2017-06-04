package com.pfyuit.myjavaee.service.rule.drools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/rule/drools/myjavaee-rule-drools-test.xml" })
public class DroolsTest {

	@Autowired
	private DroolsService droolsService;

	@Test
	public void testWithDraw() {
		droolsService.withDraw(150);
	}

}
