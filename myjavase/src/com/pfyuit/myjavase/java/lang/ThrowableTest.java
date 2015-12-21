package com.pfyuit.myjavase.java.lang;

import java.util.Map;

/**
 * Advanced features of Java exception.
 * @author yupengfei
 */
public class ThrowableTest {

	public static void main(String[] args) {
		// Current thread stack dump
		System.out.println("=>Current thread stack dump");
		Thread.dumpStack();

		// Analyze current thread stack trace
		System.out.println("=>Analyze current thread stack trace");
		Throwable t = new Throwable();
		printStackTrace(t.getStackTrace());

		// Analyze all thread stack trace
		System.out.println("=>Analyze all thread stack trace");
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		for (Thread thread : map.keySet()) {
			printStackTrace(map.get(thread));
		}

		// Wrap exception
		System.out.println("=>Wrap exception");
		t = new Throwable();
		t.initCause(new RuntimeException("runtim exception"));
		t.printStackTrace();
		System.out.println();
		t.getCause().printStackTrace();
	}

	private static void printStackTrace(StackTraceElement[] elements) {
		for (StackTraceElement element : elements) {
			System.out.println(element.getFileName() + " " + element.getClassName() + " " + element.getLineNumber() + " " + element.getMethodName());
		}
	}

}
