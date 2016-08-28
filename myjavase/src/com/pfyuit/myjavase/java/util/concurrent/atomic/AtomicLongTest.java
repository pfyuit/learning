package com.pfyuit.myjavase.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yupengfei
 */
public class AtomicLongTest {

	public static void main(String[] args) {
		AtomicLong ai = new AtomicLong(1);
		System.out.println(ai.get());

		System.out.println(ai.getAndIncrement()); // i++
		System.out.println(ai.getAndDecrement()); // i--
		System.out.println(ai.getAndSet(15));// i=15
		System.out.println(ai.getAndAdd(10)); // i+10

		System.out.println(ai.incrementAndGet()); // ++i
		System.out.println(ai.decrementAndGet());// --i;
		System.out.println(ai.addAndGet(10));
	}

}
