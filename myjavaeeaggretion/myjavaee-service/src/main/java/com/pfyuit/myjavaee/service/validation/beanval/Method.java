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
 * Annotation of "Method" to check the field(method) in the form.
 * @author yupengfei
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@NotNull
@NotEmpty
@Constraint(validatedBy = { MethodValidator.class })
public @interface Method {

	String message() default "method must be GET, POST, DELETE or PUT";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
