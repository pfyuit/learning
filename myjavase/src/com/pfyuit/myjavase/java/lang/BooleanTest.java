package com.pfyuit.myjavase.java.lang;

/**
 * @author yupengfei
 */
public class BooleanTest {

	public static void main(String[] args) {
		Boolean aTrue = Boolean.TRUE;
		Boolean aFalse = Boolean.FALSE;

		boolean value = aTrue.booleanValue();
		Class<?> clazz = aTrue.TYPE;

		aTrue = Boolean.valueOf(true);
		aFalse = Boolean.valueOf("false");
		aTrue = Boolean.parseBoolean("true");

		aTrue = Boolean.getBoolean("true");

		System.out.println(aTrue.toString());
	}

}
