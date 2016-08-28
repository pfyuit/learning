package com.pfyuit.myjavase.java.util.concurrent.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author yupengfei
 */
public class ReentrantReadWriteLockTest {

	static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		new RunTask(true).start();
		new RunTask(false).start();
	}

	public static class RunTask extends Thread {

		private boolean readWrite;

		public RunTask(boolean readWrite) {
			this.readWrite = readWrite;
		}

		public void run() {
			ReadLock reLock = lock.readLock();
			WriteLock wrLock = lock.writeLock();

			if (readWrite) {
				reLock.lock();
				System.out.println("read locked");
				System.out.println(lock.isWriteLocked());
				reLock.unlock();
			}

			if (!readWrite) {
				wrLock.lock();
				System.out.println("write locked");
				System.out.println(lock.isWriteLocked());
				wrLock.unlock();
			}

		}
	}

}
