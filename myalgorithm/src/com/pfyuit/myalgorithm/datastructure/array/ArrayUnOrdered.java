package com.pfyuit.myalgorithm.datastructure.array;

/**
 * UnOrdered array. It has limited max size.
 * @author yupengfei
 */
public class ArrayUnOrdered {

	private long[] data;
	private int size = 0;
	private int maxSize = 0;

	public ArrayUnOrdered(int maxSize) {
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

		data[size++] = value;
		return size;
	}

	/**
	 * Delete data
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
	 * Find data using linear search
	 * @param value
	 * @return
	 */
	public int find(long value) {
		if (isEmpty()) {
			return -1;
		}

		for (int i = 0; i < size; i++) {
			if (data[i] == value) {
				return i;
			}
		}
		return -1;
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
		ArrayUnOrdered array = new ArrayUnOrdered(100);

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
