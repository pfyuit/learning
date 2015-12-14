package com.pfyuit.myalgorithm.datastructure.array;

/**
 * @author yupengfei
 */
public class ArrayUnOrdered {

	private long[] data;
	private int size = 0;
	private int maxSize = 0;

	public ArrayUnOrdered(int maxSize) {
		this.maxSize = maxSize;
		data = new long[this.maxSize];
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
	 * @param key
	 * @return
	 */
	public int insert(long key) {
		data[size++] = key;
		return size;
	}

	/**
	 * Delete data
	 * @param key
	 * @return
	 */
	public int delete(long key) {
		// Find out index to delete.
		int index = linearSearch(key);

		if (index == data.length) {
			System.out.println("key not found");
		} else {
			// Shift sub array after index to left.
			for (int i = index; i <= size - 2; i++) {
				data[i] = data[i + 1];
			}
			size--;
		}
		return index;
	}

	/**
	 * Linear search
	 * @param key
	 * @return
	 */
	public int linearSearch(long key) {
		for (int i = 0; i < size; i++) {
			if (data[i] == key) {
				return i;
			}
		}
		return data.length;
	}

	/**
	 * Traverse all the data
	 */
	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.println(data[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayUnOrdered list = new ArrayUnOrdered(100);

		// insert
		System.out.println("==>insert data...");
		list.insert(13);
		list.insert(2);
		list.insert(45);
		list.insert(7);
		list.insert(15);
		list.insert(47);
		list.insert(28);
		list.insert(99);

		System.out.println("==>display data...");
		list.display();

		// search
		System.out.println("==>search data...");
		int result = list.linearSearch(47);
		System.out.println("search result:" + result);

		// delete
		System.out.println("==>delete data...");
		list.delete(45);

		System.out.println("==>display data...");
		list.display();
	}

}
