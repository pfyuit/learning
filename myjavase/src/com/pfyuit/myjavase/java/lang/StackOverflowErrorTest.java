package com.pfyuit.myjavase.java.lang;

/**
 * @author yupengfei
 */
public class StackOverflowErrorTest {

	public static void main(String[] args) {
		testStackOverflowError();
	}

	private static void testStackOverflowError() {
		System.out.println("Start invoke method");
		testStackOverflowError();
	}

}
