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

		System.out.println("���߳���ִ������");
		for (Future<Integer> future : futures) {
			try {
				Integer r = future.get();
				System.out.println("task���н��" + r);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("��������ִ�����");
	}
}

class Task implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName() + "���߳̿�ʼ����");
		Thread.sleep(10000);
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += i;
		}
		System.out.println(Thread.currentThread().getName() + "���̼߳������");
		return sum;
	}

}