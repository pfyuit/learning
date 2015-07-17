package com.pfyuit.myjavaee.service.beanvalidator;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfyuit.myjavaee.form.ApiForm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class BeanValidatorServiceTest {

	@Autowired
	private BeanValidationService<ApiForm> beanValidationService;

	@Test
	public void testValidate() {
		ApiForm form = new ApiForm();
		form.setCname("cname");
		Set<ConstraintViolation<ApiForm>> violations = beanValidationService.validate(form);
		for (ConstraintViolation<ApiForm> violatioin : violations) {
			System.out.println(violatioin.getMessage());
		}
	};

}
