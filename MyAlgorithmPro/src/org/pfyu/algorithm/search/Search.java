package org.pfyu.algorithm.search;

public class Search {

	public static void main(String[] args) {
		int[] data = { 1, 3, 5, 7, 9, 23, 145, 368, 999, 1009 };

		int result = linearSearch(data, 999);
		System.out.println("linear search result: " + result);

		result = binarySearch(data, 999);
		System.out.println("binary search result: " + result);

	}

	public static int linearSearch(int[] data, int key) {
		int i;
		for (i = 0; i < data.length; i++) {
			if (data[i] == key) {
				return i;
			}
		}
		return data.length;
	}

	public static int binarySearch(int[] data, int key) {
		int low = 0;
		int high = data.length - 1;
		int mid;

		while (true) {
			mid = (low + high) / 2;
			if (data[mid] == key) {
				return mid;
			} else if (low > high) {
				return data.length;
			} else if (data[mid] > key) {
				high = mid - 1;
			} else if (data[mid] < key) {
				low = mid + 1;
			}
		}
	}

}
