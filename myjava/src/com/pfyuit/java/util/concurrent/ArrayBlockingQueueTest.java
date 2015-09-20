package com.pfyuit.java.util.concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueTest {

	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);

	public BlockingQueue<Integer> getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public static class MyReadThread extends Thread {

		private BlockingQueue<Integer> queue;

		public MyReadThread(BlockingQueue<Integer> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				Integer i;
				try {
					i = queue.take();
					System.out.println(Thread.currentThread().getName() + " take =>" + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class MyWriteThread extends Thread {

		private BlockingQueue<Integer> queue;

		public MyWriteThread(BlockingQueue<Integer> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				Integer output = new Random().nextInt();
				queue.offer(output);
				System.out.println(Thread.currentThread().getName() + " offer =>" + output);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayBlockingQueueTest test = new ArrayBlockingQueueTest();
		new MyWriteThread(test.getQueue()).start();
		new MyReadThread(test.getQueue()).start();
	}
}
