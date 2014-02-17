package org.pfyu.algorithm.sort;

public class Sort {

	/**
	 * Display all the data
	 * @param data
	 */
	public static void display(long[] data) {
		for (long d : data) {
			System.out.println(d);
		}
	}

	/**
	 * O(N^2): bubble sort
	 * @param data
	 */
	public static void bubbleSort(long[] data) {
		int size = data.length;
		for (int out = size - 1; out >= 1; out--) {
			for (int in = 0; in <= out-1; in++) {
				if (data[in] > data[in + 1]) {
					//swap
					long temp = data[in];
					data[in] = data[in + 1];
					data[in + 1] = temp;
				}
			}
		}
	}

	/**
	 * O(N^2): selection sort
	 * @param data
	 */
	public static void selectionSort(long[] data) {
		int size = data.length;
		for (int out = 0; out <= size - 2; out++) {
			int min = out;
			for (int in = out + 1; in <= size-1; in++) {
				if (data[in] < data[min]) {
					min = in;
				}
			}
			//swap
			long temp = data[out];
			data[out] = data[min];
			data[min] = temp;
		}
	}

	/**
	 * O(N^2): insertion sort
	 * @param data
	 */
	public static void insertionSort(long[] data) {
		int size = data.length;
		for (int out = 1; out <= size-1; out++) {
			long temp = data[out];
			int in;
			for (in = out - 1; in >= 0; in--) {
				// swap
				if (data[in] > temp) {
					data[in + 1] = data[in];
					data[in] = temp;
				}
			}
		}
	}

	/**
	 * O(): shell sort
	 * @param data
	 */
	public static void shellSort(long[] data) {
		int size = data.length;
		// generate the h
		int h = 1;
		while (h <= size / 3) {
			h = 3 * h + 1;
		}
		while (h > 0) {
			System.out.println("h=" + h);
			// insertion sort
			for (int out = h; out <= size-h; out+=h) {
				long temp = data[out];
				int in;
				for (in = out - h; in >= h - 1; in -= h) {
					// swap
					if (data[in] > temp) {
						data[in + h] = data[in];
						data[in] = temp;
					}
				}
			}
			// decrease h
			h = (h - 1) / 3;
		}
	}

	/**
	 * O(): quick sort
	 * @param data
	 */
	public static void quickSort(long[] data) {
		int size = data.length;
		quick_sort(data, 0, size - 1);
	}

	private static void quick_sort(long[] data, int left, int right) {
		if (left < right) {
			long temp = data[left];
			int i = left;
			int j = right;
			while (i < j) {
				// 从右往左找到小的数，填坑
				while (i < j && data[j] >= temp) {
					j--;
				}
				if (i < j) {
					data[i] = data[j];
					i++;
				}
				// 从左往右找到大的数，填坑
				while (i < j && data[i] < temp) {
					i++;
				}
				if (i < j) {
					data[j] = data[i];
					j--;
				}
			}
			data[i] = temp;
			// 递归
			quick_sort(data, left, i - 1);
			quick_sort(data, i + 1, right);
		}

	}

	public static void main(String[] args) {
		long[] data = { 12, 34, 5, 29, 230, 112, 1, 2, 47, 998, 123, 356, 90,
				17, 4, 56 };
		 //bubbleSort(data);
		// selectionSort(data);
		// insertionSort(data);
		// shellSort(data);
		quickSort(data);
		display(data);
	}

}
