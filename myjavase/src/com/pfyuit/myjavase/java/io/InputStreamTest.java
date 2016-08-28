package com.pfyuit.myjavase.java.io;

import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class InputStreamTest {

	public static void main(String[] args) {
		Class<?> clazz = InputStream.class;
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
