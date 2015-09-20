package com.pfyuit.java.lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTest {

	public static void main(String[] args) {
		User user = new User();
		Class<?> clazz = user.getClass();

		printAnnotations(clazz.getAnnotations());

		Field[] fields = clazz.getDeclaredFields();
		for (Field fied : fields) {
			printAnnotations(fied.getAnnotations());
		}

		Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			printAnnotations(constructor.getAnnotations());
		}

		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			printAnnotations(method.getAnnotations());
		}
	}

	private static void printAnnotations(Annotation[] annotations) {
		for (Annotation annotation : annotations) {
			System.out.println(annotation.annotationType().getCanonicalName());
		}
	}

}

@ClassAnnotation
class User {

	@FieldAnnotation
	private String name;

	@ConstructorAnnotation
	public User() {
	}

	@MethodAnnotation
	public String getName() {
		return name;
	}

	@MethodAnnotation
	public void setName(@ParamAnnotation String name) {
		@LocalVariableAnnotation
		int i = 0;
		this.name = name;
	}

}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@interface ClassAnnotation {

	String name() default "";

	String value() default "";

}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.CONSTRUCTOR })
@interface ConstructorAnnotation {

	String name() default "";

	String value() default "";

}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@interface FieldAnnotation {

	String name() default "";

	String value() default "";

}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@interface MethodAnnotation {

	String name() default "";

	String value() default "";

}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.PARAMETER })
@interface ParamAnnotation {

	String name() default "";

	String value() default "";

}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.LOCAL_VARIABLE })
@AnnotationAnnotation
@interface LocalVariableAnnotation {

	String name() default "";

	String value() default "";

}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.ANNOTATION_TYPE })
@interface AnnotationAnnotation {

	String name() default "";

	String value() default "";

}
