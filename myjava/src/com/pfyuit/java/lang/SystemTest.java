package com.pfyuit.java.lang;

public class SystemTest {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		System.out.println(System.getProperty("user.dir"));
		
		System.gc();
	}
}
