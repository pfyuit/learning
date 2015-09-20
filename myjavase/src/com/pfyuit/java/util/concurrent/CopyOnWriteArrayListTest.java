package com.pfyuit.java.util.concurrent;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {

	private List<Integer> list = new CopyOnWriteArrayList<Integer>();

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public static class MyReadThread extends Thread {
		private List<Integer> list;

		public MyReadThread(List<Integer> list) {
			this.list = list;
		}

		public void run() {
			while (true) {
				for (int i = 0; i < list.size(); i++) {
					System.out.println(Thread.currentThread().getName() + " get => " + list.get(i));
					list.remove(i);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static class MyWriteThread extends Thread {
		private List<Integer> list;

		public MyWriteThread(List<Integer> list) {
			this.list = list;
		}

		public void run() {
			while (true) {
				Integer i = new Random().nextInt();
				list.add(i);
				System.out.println(Thread.currentThread().getName() + " add => " + i);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		CopyOnWriteArrayListTest test = new CopyOnWriteArrayListTest();
		new MyWriteThread(test.getList()).start();
		new MyReadThread(test.getList()).start();
	}

}
