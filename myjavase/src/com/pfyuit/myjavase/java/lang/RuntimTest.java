package com.pfyuit.myjavase.java.lang;

import java.io.IOException;

public class RuntimTest {
	public static void main(String[] args) throws IOException {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("something before jvm shutdown");
			}
		});
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(Runtime.getRuntime().maxMemory());
	}

}
