package com.pfyuit.myjavase.java.lang;

public class ThreadDeadLockTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new DeadLockclass(true));
		Thread t2 = new Thread(new DeadLockclass(false));
		t1.start();
		t2.start();
	}
}

class DeadLockclass implements Runnable {

	public boolean falg;

	DeadLockclass(boolean falg) {
		this.falg = falg;
	}

	public void run() {
		if (falg) {
			while (true) {
				synchronized (Lock.o1) {
					System.out.println("o1 " + Thread.currentThread().getName());
					synchronized (Lock.o2) {
						System.out.println("o2 " + Thread.currentThread().getName());
					}
				}
			}
		} else {
			while (true) {
				synchronized (Lock.o2) {
					System.out.println("o2 " + Thread.currentThread().getName());
					synchronized (Lock.o1) {
						System.out.println("o1 " + Thread.currentThread().getName());
					}
				}
			}
		}
	}
}

class Lock {
	static Object o1 = new Object();
	static Object o2 = new Object();
}