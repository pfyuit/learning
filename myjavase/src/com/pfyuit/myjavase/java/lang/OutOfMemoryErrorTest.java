package com.pfyuit.myjavase.java.lang;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author yupengfei
 */
public class OutOfMemoryErrorTest {

	public static void main(String[] args) {
		testOOMForHeap();
		testOOMForPermGen();
	}

	/**
	 * Out of Memory in JVM Heap.
	 */
	private static void testOOMForHeap() {
		List<Calendar> list = new ArrayList<>();
		while (true) {
			list.add(Calendar.getInstance());
		}
	}

	/**
	 * Out of Memory in JVM Method Area (Perm Gen for Hotspot JVM).
	 */
	private static void testOOMForPermGen() {
		List<String> list = new ArrayList<>();
		int i = 0;
		while (true) {
			String str = "The {@code Integer} class wraps a value of the primitive "
					+ "type{@code int} in an object. An object of type {@code Integer}"
					+ "contains a single field whose type is {@code int}.<p>In addition, "
					+ "this class provides several methods for convertingan {@code int} "
					+ "to a {@code String} and a {@code String} to an{@code int}, as well "
					+ "as other constants and methods useful whendealing with an {@code int}."
					+ "<p>Implementation note: The implementations of the bit twiddling methods "
					+ "(such as {@link #highestOneBit(int) highestOneBit} and{@link #numberOfTrail"
					+ "ingZeros(int) numberOfTrailingZeros}) arebased on material from Henry S. Wa"
					+ "rren, Jr.'s <i>Hacker'sDelight</i>, (Addison Wesley, 2002)." + i;
			list.add(str.intern());
			i++;
		}
	}
}
