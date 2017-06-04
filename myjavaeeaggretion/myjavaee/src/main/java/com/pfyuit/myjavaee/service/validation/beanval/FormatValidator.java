package com.pfyuit.myjavaee.service.validation.beanval;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator of format field in the form.
 * @author yupengfei
 */
public class FormatValidator implements ConstraintValidator<Format, String> {

	private static final List<String> VALID_FORMATS;

	static {
		VALID_FORMATS = Collections.unmodifiableList(Arrays.asList(new String[] { "XML", "JSON" }));
	}

	@Override
	public void initialize(Format constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return VALID_FORMATS.contains(value);
	}

}
