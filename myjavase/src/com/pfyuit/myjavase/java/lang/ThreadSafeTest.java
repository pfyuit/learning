package com.pfyuit.myjavase.java.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Use a thread unsafe Arraylist in multithreaded environment may get a null elemement.
 * @author yupengfei
 */
public class ThreadSafeTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(8);
		final List<Integer> list = new ArrayList<>();
		List<Future<Object>> futures = new ArrayList<Future<Object>>();
		for (int i = 0; i < 10000; i++) {
			Future<Object> future = es.submit(new Callable<Object>() {
				@Override
				public Object call() {
					list.add(new Integer(123));
					return null;
				}
			});
			futures.add(future);
		}
		System.out.println(es);
		es.shutdown();

		for (Future<Object> future : futures) {
			future.get();
		}

		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			Integer element = list.get(i);
			if (element == null) {
				System.out.println("Got null!");
			}
		}

	}

}
