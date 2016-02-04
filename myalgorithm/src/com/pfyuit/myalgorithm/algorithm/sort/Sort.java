package com.pfyuit.myalgorithm.algorithm.sort;

import java.util.Random;

import com.pfyuit.myalgorithm.datastructure.tree.Heap;

/**
 * @author yupengfei
 */
public class Sort {

	private static long[] data = new long[100000];

	/**
	 * Bubble sort.
	 * @param data
	 */
	public static void bubbleSort(long[] data) {
		int size = data.length;
		for (int out = size - 1; out >= 1; out--) {
			for (int in = 0; in <= out - 1; in++) {
				if (data[in] > data[in + 1]) {
					// swap
					long temp = data[in];
					data[in] = data[in + 1];
					data[in + 1] = temp;
				}
			}
		}
	}

	/**
	 * Selection sort.
	 * @param data
	 */
	public static void selectionSort(long[] data) {
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

	/**
	 * Insertion sort.
	 * @param data
	 */
	public static void insertionSort(long[] data) {
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

	/**
	 * Shell sort.
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
			for (int out = h; out <= size - h; out += h) {
				long temp = data[out];

				int in = out - h;
				for (in = out - h; in >= h - 1; in -= h) {
					// shift right
					if (data[in] > temp) {
						data[in + h] = data[in];
					} else {
						break;
					}
				}
				data[in + h] = temp;

			}

			// decrease h
			h = (h - 1) / 3;
		}
	}

	/**
	 * Quick sort.
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
				// ���������ҵ�С�������
				while (i < j && data[j] >= temp) {
					j--;
				}
				if (i < j) {
					data[i] = data[j];
					i++;
				}
				// ���������ҵ���������
				while (i < j && data[i] < temp) {
					i++;
				}
				if (i < j) {
					data[j] = data[i];
					j--;
				}
			}
			data[i] = temp;
			// �ݹ�
			quick_sort(data, left, i - 1);
			quick_sort(data, i + 1, right);
		}

	}

	/**
	 * Merge sort.
	 * @param data
	 */
	public static void mergeSort(long[] data) {
		long[] workspace = new long[data.length];
		int low = 0;
		int high = data.length - 1;

		recMergeSort(data, workspace, low, high);
	}

	private static void recMergeSort(long[] data, long[] workspace, int low, int high) {
		if (low == high) {
			return;
		}

		int mid = (low + high) / 2;
		recMergeSort(data, workspace, low, mid);
		recMergeSort(data, workspace, mid + 1, high);
		merge(data, workspace, low, mid, high);
	}

	private static void merge(long[] data, long[] workspace, int low, int mid, int high) {
		int lowIndex = low;
		int highIndex = mid + 1;
		int index = 0;

		while (lowIndex <= mid && highIndex <= high) {
			if (data[lowIndex] < data[highIndex]) {
				workspace[index++] = data[lowIndex++];
			} else {
				workspace[index++] = data[highIndex++];
			}
		}

		while (lowIndex <= mid) {
			workspace[index++] = data[lowIndex++];
		}

		while (highIndex <= high) {
			workspace[index++] = data[highIndex++];
		}

		for (int i = 0; i < (high - low + 1); i++) {
			data[low + i] = workspace[i];
		}

	}

	/**
	 * Heap sort.
	 * @param data
	 */
	public static void heapSort(long[] data) {
		Heap heap = new Heap(100000);
		for (long value : data) {
			heap.insert(value);
		}
		for (int i = 0; i < data.length; i++) {
			data[i] = heap.remove().data;
		}
	}

	public static void initData() {
		for (int i = 0; i < data.length; i++) {
			data[i] = new Random().nextInt(1000000);
		}
	}

	private static void printData() {
//		for (int i = 0; i < data.length; i++) {
//			System.out.print(data[i] + " ");
//		}
	}

	public static void main(String[] args) {
		testBubbleSort();
		testSelectionSort();
		testInsertionSort();
		testShellSort();
		testQuickSort();
		testMergeSort();
		testHeapSort();
	}

	private static void testHeapSort() {
		System.out.println("==>testHeapSort");
		initData();
		long start = System.currentTimeMillis();
		heapSort(data);
		printData();
		System.out.println("cost time: " + (System.currentTimeMillis() - start) + " ms");
	}

	private static void testMergeSort() {
		System.out.println("==>testMergeSort");
		initData();
		long start = System.currentTimeMillis();
		mergeSort(data);
		printData();
		System.out.println("cost time: " + (System.currentTimeMillis() - start) + " ms");
	}

	private static void testQuickSort() {
		System.out.println("==>testQuickSort");
		initData();
		long start = System.currentTimeMillis();
		quickSort(data);
		printData();
		System.out.println("cost time: " + (System.currentTimeMillis() - start) + " ms");
	}

	private static void testShellSort() {
		System.out.println("==>testShellSort");
		initData();
		long start = System.currentTimeMillis();
		shellSort(data);
		printData();
		System.out.println("cost time: " + (System.currentTimeMillis() - start) + " ms");
	}

	private static void testInsertionSort() {
		System.out.println("==>testInsertionSort");
		initData();
		long start = System.currentTimeMillis();
		insertionSort(data);
		printData();
		System.out.println("cost time: " + (System.currentTimeMillis() - start) + " ms");
	}

	private static void testSelectionSort() {
		System.out.println("==>testSelectionSort");
		initData();
		long start = System.currentTimeMillis();
		selectionSort(data);
		printData();
		System.out.println("cost time: " + (System.currentTimeMillis() - start) + " ms");
	}

	private static void testBubbleSort() {
		System.out.println("==>testBubbleSort");
		initData();
		long start = System.currentTimeMillis();
		bubbleSort(data);
		printData();
		System.out.println("cost time: " + (System.currentTimeMillis() - start) + " ms");
	}

}
