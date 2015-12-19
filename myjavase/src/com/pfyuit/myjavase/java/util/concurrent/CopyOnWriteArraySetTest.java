package com.pfyuit.myjavase.java.util.concurrent;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetTest {

	private Set<Integer> set = new CopyOnWriteArraySet<Integer>();

	public Set<Integer> getSet() {
		return set;
	}

	public void setSet(Set<Integer> set) {
		this.set = set;
	}

	public static class MyReadThread extends Thread {
		private Set<Integer> set;

		public MyReadThread(Set<Integer> set) {
			this.set = set;
		}

		public void run() {
			while (true) {
				Iterator<Integer> iterator = set.iterator();
				while (iterator.hasNext()) {
					Integer i = iterator.next();
					System.out.println(Thread.currentThread().getName() + " get => " + i);
					set.remove(i);

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
		private Set<Integer> set;

		public MyWriteThread(Set<Integer> set) {
			this.set = set;
		}

		public void run() {
			while (true) {
				Integer i = new Random().nextInt();
				set.add(i);
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
		CopyOnWriteArraySetTest test = new CopyOnWriteArraySetTest();
		new MyWriteThread(test.getSet()).start();
		new MyReadThread(test.getSet()).start();
	}

}
