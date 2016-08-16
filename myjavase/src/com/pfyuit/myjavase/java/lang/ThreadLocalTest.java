package com.pfyuit.myjavase.java.lang;

/**
 * @author yupengfei
 */
public class ThreadLocalTest {

	public static void main(String[] args) {
		Task task1 = new Task();
		Task task2 = new Task();
		task1.start();
		task2.start();
	}

	public static class Task extends Thread {

		private ThreadLocal<String> local = new ThreadLocal<>();

		public void run() {
			if (local.get() == null) {
				local.set(Thread.currentThread().getName());
			}
			System.out.println(local.get());
		}

	}

}
