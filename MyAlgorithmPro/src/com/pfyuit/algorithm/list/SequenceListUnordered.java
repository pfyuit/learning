package com.pfyuit.algorithm.list;

public class SequenceListUnordered {

	private long[] data;
	private int maxSize = 0;
	private int size = 0;

	/**
	 * Constructor
	 * @param maxSize
	 */
	public SequenceListUnordered(int maxSize) {
		this.maxSize = maxSize;
		data = new long[this.maxSize];
	}

	/**
	 * Is the sequence list empty
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Is the sequence list full
	 * @return
	 */
	public boolean isFull() {
		return size == maxSize;
	}

	/**
	 * Get the size of sequence list
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * O(1): Insert data at last
	 * @param key
	 * @return
	 */
	public int insert(long key) {
		data[size++] = key;
		return size;
	}

	/**
	 * O(N): delete data with given key
	 * @param key
	 * @return
	 */
	public int delete(long key) {
		int index = linearSearch(key);
		// not found
		if (index == data.length) {
			System.out.println("key not found");
		} else {
			// shift
			for (int i = index; i <= size - 2; i++) {
				data[i] = data[i + 1];
			}
			size--;
		}
		return index;
	}

	/**
	 * O(N): linear search
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
	 * Display all the data in the sequence list
	 */
	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.println(data[i]);
		}
	}

	public static void main(String[] args) {
		SequenceListUnordered list = new SequenceListUnordered(100);

		// insert
		list.insert(13);
		list.insert(2);
		list.insert(45);
		list.insert(7);
		list.insert(15);
		list.insert(47);
		list.insert(28);
		list.insert(99);
		list.display();

		// search
		int result = list.linearSearch(47);
		System.out.println("search result:" + result);

		// delete
		list.delete(45);
		list.display();
	}

}