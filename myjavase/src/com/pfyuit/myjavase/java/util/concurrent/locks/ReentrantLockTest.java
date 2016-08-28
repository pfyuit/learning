package com.pfyuit.myjavase.java.util.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yupengfei
 */
public class ReentrantLockTest {
	
	static final ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		new RunTask().start();
		new RunTask().start();
	}

	public static class RunTask extends Thread {

		public void run() {
			// lock.lock();
			if (lock.tryLock()) {
				System.out.println(Thread.currentThread());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			} else {
				System.out.println(Thread.currentThread() + "cannot get lock");
			}
		}
	}

}
