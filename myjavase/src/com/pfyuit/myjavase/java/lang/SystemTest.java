package com.pfyuit.myjavase.java.lang;

public class SystemTest {
	public static void main(String[] args) {
		timestamp();
		property();
		gc();
		arrayCopy();
		exit();
	}

	public static void timestamp() {
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
	}

	public static void property() {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("custom", "hello");
		System.err.print(System.getProperty("custom"));
		System.out.println(System.getenv("JAVA_HOME"));
	}

	public static void gc() {
		System.gc();
	}

	public static void arrayCopy() {
		int[] src = new int[] { 1, 2, 3, 4, 5 };
		int[] dest = new int[10];
		System.arraycopy(src, 0, dest, 0, 5);
		for (int i : dest) {
			System.out.print(i + " ");
		}
	}

	public static void exit() {
		System.exit(-1);
	}
}
