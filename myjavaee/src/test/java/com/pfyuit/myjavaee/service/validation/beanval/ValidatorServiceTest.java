package com.pfyuit.myjavaee.service.validation.beanval;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfyuit.myjavaee.model.validation.beanval.ApiForm;
import com.pfyuit.myjavaee.service.validation.beanval.ValidatorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/validation/beanval/myjavaee-validation-beanval-test.xml" })
public class ValidatorServiceTest {

	@Autowired
	private ValidatorService<ApiForm> beanValidationService;

	@Test
	public void testValidate() {
		ApiForm form = new ApiForm();
		form.setCname("cname");
		Set<ConstraintViolation<ApiForm>> violations = beanValidationService.validate(form);
		for (ConstraintViolation<ApiForm> violatioin : violations) {
			System.out.println(violatioin.getMessage());
		}
	};

	@Test(expected = ConstraintViolationException.class)
	public void testValidateWithException() {
		ApiForm form = new ApiForm();
		form.setCname("cname");
		beanValidationService.validateWithException(form);
	};

}
