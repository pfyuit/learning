package com.pfyuit.myjavase.java.util.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Task task = new Task();

		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		for (int i = 0; i < 5; i++) {
			Future<Integer> result = executor.submit(task);
			futures.add(result);
		}
		executor.shutdown();

		System.out.println("主线程在执行任务");
		for (Future<Integer> future : futures) {
			try {
				Integer r = future.get();
				System.out.println("task运行结果" + r);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("所有任务执行完毕");
	}
}

class Task implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName() + "子线程开始计算");
		Thread.sleep(10000);
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += i;
		}
		System.out.println(Thread.currentThread().getName() + "子线程计算结束");
		return sum;
	}

}