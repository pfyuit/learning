package com.pfyuit.myjavase.java.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yupengfei
 */
public class ExecutorsTest {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		System.out.println(es);

		es = Executors.newCachedThreadPool();
		System.out.println(es);

		es = Executors.newSingleThreadExecutor();
		System.out.println(es);

		es = Executors.newScheduledThreadPool(5);
		System.out.println(es);

		es = Executors.newSingleThreadScheduledExecutor();
		System.out.println(es);
	}

}
