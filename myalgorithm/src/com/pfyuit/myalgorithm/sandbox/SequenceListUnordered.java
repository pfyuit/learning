package com.pfyuit.myalgorithm.sandbox;

public class SequenceListUnordered {

	private long[] data;
	private int size;
	private int maxSize;

	public SequenceListUnordered(int maxSize) {
		this.maxSize = maxSize;
		data = new long[maxSize];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == maxSize;
	}

	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.println(data[i]);
		}
		System.out.println();
	}

	public void insert(long key) {
		data[size++] = key;
	}

	public int delete(long key) {
		int index = linearSearch(key);
		if (index == size) {
			System.out.println("key not found");
			return index;
		}

		for (int i = index; i <= size - 2; i++) {
			data[i] = data[i + 1];
		}
		size--;

		return index;
	}

	public int linearSearch(long key) {
		for (int i = 0; i < size; i++) {
			if (data[i] == key) {
				return i;
			}
		}
		return data.length;
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
