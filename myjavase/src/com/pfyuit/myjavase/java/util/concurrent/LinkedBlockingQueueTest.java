package com.pfyuit.myjavase.java.util.concurrent;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {

	private Queue<Integer> queue = new LinkedBlockingQueue<Integer>();

	public Queue<Integer> getQueue() {
		return queue;
	}

	public void setQueue(Queue<Integer> queue) {
		this.queue = queue;
	}

	public static class MyReadThread extends Thread {

		private Queue<Integer> queue;

		public MyReadThread(Queue<Integer> deque) {
			this.queue = deque;
		}

		public void run() {
			while (true) {
				Integer i = queue.poll();
				System.out.println(Thread.currentThread().getName() + " pool => " + i);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static class MyWriteThread extends Thread {

		private Queue<Integer> queue;

		public MyWriteThread(Queue<Integer> queue) {
			this.queue = queue;
		}

		public void run() {
			while (true) {
				Integer i = new Random().nextInt();
				queue.offer(i);
				System.out.println(Thread.currentThread().getName() + " offer => " + i);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		LinkedBlockingQueueTest test = new LinkedBlockingQueueTest();
		new MyReadThread(test.getQueue()).start();
		new MyWriteThread(test.getQueue()).start();
	}

}
