package com.pfyuit.java.lang.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch signal = new CountDownLatch(10);
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i = 0; i< 10; i++){
			executor.submit(new Task(signal));
		}
		executor.shutdown();
		signal.await(6000, TimeUnit.MILLISECONDS);
		System.out.println("Main thread ended");
	}

	public static class Task implements Runnable {

		private CountDownLatch signal;

		public Task(CountDownLatch signal) {
			this.signal = signal;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": Task ended");
			signal.countDown();
		}

	}

}
