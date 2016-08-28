package com.pfyuit.myjavase.java.io;

import java.io.DataInput;
import java.lang.reflect.Method;

/**
 * DataInput interface provides the facility to read value for Java primitive types.
 * @author yupengfei
 */
public class DataInputTest {

	public static void main(String[] args) {
		Class<?> clazz = DataInput.class;
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
			System.out.println(method.getReturnType().getCanonicalName());
			System.out.println(method.getModifiers());
			System.out.println(method.getExceptionTypes());
			System.out.println(method.getParameterTypes());
			System.out.println();
		}
	}

}
