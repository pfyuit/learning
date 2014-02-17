package org.pfyu.algorithm.list;

public class SequenceListOrder {

	private long[] data;
	private int maxSize = 0;
	private int size = 0;
	
	/**
	 * Constructor
	 * @param maxSize
	 */
	public SequenceListOrder(int maxSize){
		this.maxSize = maxSize;
		data = new long[this.maxSize];
	}

	/**
	 * Is the sequence list empty
	 * @return
	 */
	public boolean isEmpty(){
		return size ==0;
	}
	
	/**
	 * Is the sequence list full
	 * @return
	 */
	public boolean isFull(){
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
	 * O(N): insert data with the given key
	 * @param key
	 * @return
	 */
	public int insert(long key) {
		int i;
		//find the correct position
		for (i = 0; i < size; i++) {
			if (data[i] > key) {
				break;
			}
		}

		//shift
		for (int j = size; j >= i+1; j--) {
			data[j] = data[j - 1];
		}

		data[i] = key;
		size++;
		return i;
	}

	/**
	 * O(N): delete value with given key
	 * @param key
	 * @return
	 */
	public int delete(long key) {
		int index = binarySearch(key);
		//not found
		if (index == data.length) {
			System.out.println("key not found");
		} else {
			//shift left
			for (int i = index; i <= size - 2; i++) {
				data[i] = data[i + 1];
			}
			size--;
		}
		return index;
	}

	/**
	 * O(logN): binary search
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
	 * Display all the data in the sequence list
	 */
	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.println(data[i]);
		}
	}


	public static void main(String[] args) {
		SequenceListOrder array = new SequenceListOrder(100);

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
