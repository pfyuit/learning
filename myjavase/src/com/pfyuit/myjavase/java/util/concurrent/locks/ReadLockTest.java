package com.pfyuit.myjavase.java.util.concurrent.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

/**
 * @author yupengfei
 */
public class ReadLockTest {

	static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public static void main(String[] args) throws InterruptedException {
		ReadLock rLock = lock.readLock();
		rLock.tryLock();
		rLock.unlock();

		rLock.tryLock(1, TimeUnit.SECONDS);
		rLock.unlock();
	}

}
