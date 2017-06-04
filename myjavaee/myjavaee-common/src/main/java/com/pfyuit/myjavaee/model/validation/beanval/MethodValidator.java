package com.pfyuit.myjavaee.model.validation.beanval;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator of method field in the form.
 * @author yupengfei
 */
public class MethodValidator implements ConstraintValidator<Method, String> {

	private static final List<String> VALID_METHODS;

	static {
		VALID_METHODS = Collections.unmodifiableList(Arrays.asList(new String[] { "GET", "POST", "DELETE", "PUT" }));
	}

	@Override
	public void initialize(Method constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return VALID_METHODS.contains(value);
	}

}
