package com.pfyuit.java.util.concurrent;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

	private Map<Integer, String> map = new ConcurrentHashMap<>();

	public static class MyReadThread extends Thread {

		private Map<Integer, String> map;

		public MyReadThread(Map<Integer, String> map) {
			this.map = map;
		}

		public void run() {
			while (true) {
				for (Map.Entry<Integer, String> entry : map.entrySet()) {
					System.out.println(Thread.currentThread().getName() + " get => " + entry.getKey() + ":" + entry.getValue());
					map.remove(entry.getKey());
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

		private Map<Integer, String> map;

		public MyWriteThread(Map<Integer, String> map) {
			this.map = map;
		}

		public void run() {
			while (true) {
				Integer i = new Random().nextInt();
				map.put(i, String.valueOf(i));
				System.out.println(Thread.currentThread().getName() + " put => " + i + ":" + String.valueOf(i));

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Map<Integer, String> getMap() {
		return map;
	}

	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}

	public static void main(String[] args) {
		ConcurrentHashMapTest test = new ConcurrentHashMapTest();
		new MyWriteThread(test.getMap()).start();
		new MyReadThread(test.getMap()).start();
	}

}
