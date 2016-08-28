package com.pfyuit.myjavase.java.io;

import java.io.Reader;
import java.lang.reflect.Method;

/**
 * An abstract class that the subclass only need to implement one method: read(char cbuf[], int off, int len)
 * @author yupengfei
 */
public class ReaderTest {

	public static void main(String[] args) {
		Class<?> clazz = Reader.class;
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
