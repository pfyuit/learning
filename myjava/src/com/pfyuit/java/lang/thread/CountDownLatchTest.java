package com.pfyuit.java.lang.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		CountDownLatch signal = new CountDownLatch(10);
		
		Runnable thread = new Runnable(){
			public void run() {
				System.out.println(System.currentTimeMillis());
			}
		};
		
		
	}

}
