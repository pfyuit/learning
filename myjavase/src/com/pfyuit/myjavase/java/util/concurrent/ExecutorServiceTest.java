package com.pfyuit.myjavase.java.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {

	public static void main(String[] args) {
		testCachedThreadPool();
		testFixedThreadPool();	
		testSingleThreadExecutor();
		testScheduledThreadPool();
	}

	private static void testCachedThreadPool() {
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i = 0;i<10;i++){
			executor.submit(new Task());
		}
		executor.shutdown();
		System.out.println(executor.toString());
		
		long start = System.nanoTime();
		while(!executor.isTerminated()){
		}
		System.out.println(System.nanoTime()-start);
	}
	
	private static void testFixedThreadPool() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i = 0;i<10;i++){
			executor.submit(new Task());
		}
		executor.shutdown();
		System.out.println(executor.toString());
		
		long start = System.nanoTime();
		while(!executor.isTerminated()){
		}
		System.out.println(System.nanoTime()-start);
	}
	
	private static void testSingleThreadExecutor() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for(int i = 0;i<10;i++){
			executor.submit(new Task());
		}
		executor.shutdown();
		System.out.println(executor.toString());
		
		long start = System.nanoTime();
		while(!executor.isTerminated()){
		}
		System.out.println(System.nanoTime()-start);
	}
	
	private static void testScheduledThreadPool() {
		ExecutorService executor = Executors.newScheduledThreadPool(2);
		for(int i = 0;i<10;i++){
			executor.submit(new Task());
		}
		executor.shutdown();
		System.out.println(executor.toString());
		
		long start = System.nanoTime();
		while(!executor.isTerminated()){
		}
		System.out.println(System.nanoTime()-start);
	}

	public static class Task implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": Task ended");
		}

	}
}
