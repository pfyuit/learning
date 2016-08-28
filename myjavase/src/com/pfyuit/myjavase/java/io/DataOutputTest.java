package com.pfyuit.myjavase.java.io;

import java.io.DataOutput;
import java.lang.reflect.Method;

/** 
* @author yupengfei
*/
public class DataOutputTest {

	public static void main(String[] args) {
		Class<?> clazz = DataOutput.class;
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
