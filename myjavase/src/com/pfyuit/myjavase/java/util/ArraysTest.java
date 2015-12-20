package com.pfyuit.myjavase.java.util;

import java.util.Arrays;
import java.util.List;

/**
 * Operations of Arrays: just use int[] as example.
 * @author yupengfei
 */
public class ArraysTest {

	public static void main(String[] args) {
		// sort
		int[] array = new int[] { 3, 5, 1, 6, 9, 4, 7, 2, 8 };
		Arrays.sort(array);
		printArray(array);

		// copyOf
		int[] copyArray = Arrays.copyOf(array, 9);
		printArray(copyArray);

		// binarySearch
		System.out.println(Arrays.binarySearch(array, 7));

		// equals
		System.out.println(Arrays.equals(array, copyArray));

		// fill
		int[] emptyArray = new int[10];
		Arrays.fill(emptyArray, 4);
		printArray(emptyArray);

		// toString
		System.out.println(Arrays.toString(array));

		// asList
		List<?> list = Arrays.asList(array);
		System.out.println(list);
	}

	private static void printArray(int[] array) {
		for (int data : array) {
			System.out.print(data + " ");
		}
		System.out.println();
	}

}
