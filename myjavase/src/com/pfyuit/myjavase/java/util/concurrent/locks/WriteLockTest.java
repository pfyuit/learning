package com.pfyuit.myjavase.java.util.concurrent.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author yupengfei
 */
public class WriteLockTest {

	static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public static void main(String[] args) throws InterruptedException {
		WriteLock wLock = lock.writeLock();
		wLock.tryLock();
		System.out.println(lock.isWriteLockedByCurrentThread());
		System.out.println(lock.isWriteLocked());
		System.out.println(lock.isFair());
		wLock.unlock();

		wLock.tryLock(1, TimeUnit.SECONDS);
		wLock.unlock();
	}

}
