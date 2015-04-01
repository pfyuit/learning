package com.pfyuit.algorithm.sandbox;


public class SequenceListOrdered {

	private long[] data;
	private int size;
	private int maxSize;
	
	public SequenceListOrdered(int maxSize){
		this.maxSize = maxSize;
		data = new long[maxSize];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return maxSize == size;
	}

	public int getSize() {
		return size;
	}

	public int insert(long value) {
		int i;
		for (i = 0; i < size; i++) {
			if (data[i] > value) {
				break;
			}
		}

		for (int j = size; j >= i + 1; j--) {
			data[j] = data[j - 1];
		}
		size++;
		data[i] = value;
		return i;
	}

	public int delete(long value) {
		int index = binarySearch(value);
		if (index == size) {
			System.out.println("data not found");
			return size;
		}
		for (int j = index; j <= size - 2; j++) {
			data[j] = data[j + 1];
		}
		size--;
		return index;
	}

	public int binarySearch(long value) {
		int low = 0;
		int high = size - 1;
		while (true) {
			int mid = (low + high) / 2;
			if (data[mid] == value) {
				return mid;
			} else if (data[mid] < value) {
				low = mid + 1;
			} else if (data[mid] > value) {
				high = mid - 1;
			} else if(low>high){
				return size;
			}
		}
	}

	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.println(data[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		SequenceListOrdered array = new SequenceListOrdered(100);

		// insert
		array.insert(13);
		array.insert(2);
		array.insert(45);
		array.insert(7);
		array.insert(15);
		array.insert(47);
		array.insert(28);
		array.insert(99);
		array.display();

		// search
		int result = array.binarySearch(47);
		System.out.println("search result:" + result);

		// delete
		array.delete(45);
		array.display();

	}

}
