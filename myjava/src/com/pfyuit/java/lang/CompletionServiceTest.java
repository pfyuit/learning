package com.pfyuit.java.lang;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		testPoll();
		testTask();
	}

	private static void testPoll() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newCachedThreadPool();
		CompletionService<Integer> comp = new ExecutorCompletionService<>(executor);
		for (int i = 0; i < 10; i++) {
			comp.submit(new Task1());
		}
		executor.shutdown();

		int count = 0;
		while (count < 10) {
			Future<Integer> result = comp.poll();
			if (result == null) {
				System.out.println("没有结束的任务");
			} else {
				System.out.println(result.get());
				count++;
			}
			Thread.sleep(1000);
		}
	}

	private static void testTask() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newCachedThreadPool();
		CompletionService<Integer> comp = new ExecutorCompletionService<>(executor);
		for (int i = 0; i < 10; i++) {
			comp.submit(new Task1());
		}
		executor.shutdown();

		int count = 0;
		while (count < 10) {
			Future<Integer> result = comp.take();
			System.out.println(result.get());
			count++;
		}
	}

}

class Task1 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName() + "子线程开始计算");
		Thread.sleep(1000);
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += i;
		}
		System.out.println(Thread.currentThread().getName() + "子线程计算结束");
		return sum;
	}

}
