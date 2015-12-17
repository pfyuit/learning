package com.pfyuit.myalgorithm.datastructure.array;

/**
 * Ordered array. It has limited max size.
 * @author yupengfei
 */
public class ArrayOrdered {

	private long[] data;
	private int size = 0;
	private int maxSize = 0;

	public ArrayOrdered(int maxSize) {
		this.maxSize = maxSize;
		this.data = new long[this.maxSize];
		this.size = 0;
	}

	/**
	 * Is array empty
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Is array full
	 * @return
	 */
	public boolean isFull() {
		return size == maxSize;
	}

	/**
	 * Get array size
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Insert data
	 * @param value
	 * @return
	 */
	public int insert(long value) {
		if (isFull()) {
			System.out.println("array is full");
			return -1;
		}

		// Find out index to insert.
		int index;
		for (index = 0; index < size; index++) {
			if (data[index] > value) {
				break;
			}
		}

		// Shift the sub array after index to right.
		for (int j = size; j >= index + 1; j--) {
			data[j] = data[j - 1];
		}

		// Insert value to the index.
		data[index] = value;
		size++;
		return index;
	}

	/**
	 * Remove data
	 * @param value
	 * @return
	 */
	public int delete(long value) {
		// Find out index to delete.
		int index = find(value);
		if (index == -1) {
			System.out.println("data not found");
			return -1;
		}

		// Shift sub array after index to left.
		for (int i = index; i <= size - 2; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return index;
	}

	/**
	 * Find data using binary search
	 * @param value
	 * @return
	 */
	public int find(long value) {
		int low = 0;
		int high = size - 1;
		int mid;
		while (true) {
			mid = (low + high) / 2;
			if (data[mid] == value) {
				return mid;
			} else if (data[mid] < value) {
				low = mid + 1;
			} else if (data[mid] > value) {
				high = mid - 1;
			}
			if (low > high) {
				return -1;
			}
		}
	}

	/**
	 * Traverse all the data
	 */
	public void traverse() {
		for (int i = 0; i < size; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayOrdered array = new ArrayOrdered(100);

		// insert
		System.out.println("==>insert data...");
		array.insert(13);
		array.insert(2);
		array.insert(45);
		array.insert(7);
		array.insert(15);
		array.insert(47);
		array.insert(28);
		array.insert(99);

		// traverse
		System.out.println("==>traverse data...");
		array.traverse();

		// find
		System.out.println("==>find data...");
		System.out.println("search result:" + array.find(47));
		System.out.println("search result:" + array.find(100));

		// delete
		System.out.println("==>delete data...");
		array.delete(45);

		// traverse
		System.out.println("==>traverse data...");
		array.traverse();
	}

}
