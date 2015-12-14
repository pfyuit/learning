package com.pfyuit.myalgorithm.datastructure.array;

/**
 * @author yupengfei
 */
public class ArrayOrdered {

	private long[] data;
	private int size = 0;
	private int maxSize = 0;

	public ArrayOrdered(int maxSize) {
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
		int index;

		// Find out index to insert.
		for (index = 0; index < size; index++) {
			if (data[index] > key) {
				break;
			}
		}

		// Shift the sub array after index to right.
		for (int j = size; j >= index + 1; j--) {
			data[j] = data[j - 1];
		}

		// Insert key to the index.
		data[index] = key;
		size++;
		return index;
	}

	/**
	 * Remove data
	 * @param key
	 * @return
	 */
	public int delete(long key) {
		// Find out index to delete.
		int index = binarySearch(key);

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
	 * Binary search
	 * @param key
	 * @return
	 */
	public int binarySearch(long key) {
		int low = 0;
		int high = size - 1;
		int mid;
		while (true) {
			mid = (low + high) / 2;
			if (data[mid] == key) {
				return mid;
			} else if (data[mid] < key) {
				low = mid + 1;
			} else if (data[mid] > key) {
				high = mid - 1;
			} else if (low > high) {
				return data.length;
			}
		}
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

		System.out.println("==>display data...");
		array.display();

		// search
		System.out.println("==>search data...");
		int result = array.binarySearch(47);
		System.out.println("search result:" + result);

		// delete
		System.out.println("==>delete data...");
		array.delete(45);

		System.out.println("==>display data...");
		array.display();

	}

}
