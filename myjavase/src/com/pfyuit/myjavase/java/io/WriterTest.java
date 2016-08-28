package com.pfyuit.myjavase.java.io;

import java.io.Writer;
import java.lang.reflect.Method;

/**
 * An abstract class that subclass only need implement one method: write(char cbuf[], int off, int len)
 * @author yupengfei
 */
public class WriterTest {

	public static void main(String[] args) {
		Class<?> clazz = Writer.class;
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
