package com.pfyuit.algorithm.sandbox;

public class Sort {
	public static void display(long[] data) {
		for (long d : data) {
			System.out.println(d);
		}
	}

	public static void bubbleSort(long[] data) {
		int size = data.length;
		for (int out = size - 1; out >= 1; out--) {
			for (int in = 0; in <= out - 1; in++) {
				if (data[in] > data[in + 1]) {
					long temp = data[in];
					data[in] = data[in + 1];
					data[in + 1] = temp;
				}
			}
		}
	}

	public static void selectSort(long[] data) {
		int size = data.length;
		for (int out = 0; out <= size - 2; out++) {
			int min = out;
			for (int in = out + 1; in <= size - 1; in++) {
				if (data[in] < data[min]) {
					min = in;
				}
			}
			long temp = data[out];
			data[out] = data[min];
			data[min] = temp;
		}
	}

	public static void insertSort(long[] data) {
		int size = data.length;
		for (int out = 1; out <= size - 1; out++) {
			long temp = data[out];
			int in;
			for (in = out - 1; in >= 0; in--) {
				if (data[in] > temp) {
					data[in + 1] = data[in];
				} else {
					break;
				}
			}
			data[in + 1] = temp;
		}
	}

	public static void main(String[] args) {
		long[] data = { 12, 34, 5, 29, 230, 112, 1, 2, 47, 998, 123, 356, 90,
				17, 4, 56 };
		// bubbleSort(data);
		// selectSort(data);
		insertSort(data);
		display(data);
	}

}
