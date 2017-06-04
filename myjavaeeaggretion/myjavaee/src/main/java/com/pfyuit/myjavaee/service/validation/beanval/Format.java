package com.pfyuit.myjavaee.service.validation.beanval;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Annotation of "Format" to check the field(format) in the form.
 * @author yupengfei
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotNull
@NotEmpty
@Constraint(validatedBy = { FormatValidator.class })
public @interface Format {

	String message() default "format must be XML or JSON";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
