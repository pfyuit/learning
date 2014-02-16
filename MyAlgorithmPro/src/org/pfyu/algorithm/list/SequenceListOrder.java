package org.pfyu.algorithm.list;

public class SequenceListOrder {

	private long[] data = new long[100];
	private int size = 0;

	public int getSize() {
		return size;
	}

	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.println(data[i]);
		}
	}

	/**
	 * O(N)
	 * @param key
	 * @return
	 */
	public int insert(long key) {
		int i;
		for (i = 0; i < size; i++) {
			if (data[i] > key) {
				break;
			}
		}

		//shift
		for (int j = size; j > i; j--) {
			data[j] = data[j - 1];
		}

		data[i] = key;
		size++;
		return i;
	}

	/**
	 * O(N)
	 * @param key
	 * @return
	 */
	public int delete(long key) {
		int index = binarySearch(key);
		if (index == data.length) {
			System.out.println("key not found");
		} else {
			for (int i = index; i < size - 1; i++) {
				data[i] = data[i + 1];
			}
			size--;
		}
		return index;
	}

	/**
	 * O(logN)
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

	public static void main(String[] args) {
		SequenceListOrder array = new SequenceListOrder();

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
