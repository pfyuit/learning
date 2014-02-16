package org.pfyu.algorithm.list;

public class SequenceList {

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
	 * O(1)
	 * @param key
	 * @return
	 */
	public int insert(long key) {
		data[size++] = key;
		return size;
	}

	/**
	 * O(N)
	 * @param key
	 * @return
	 */
	public int delete(long key) {
		int index = linearSearch(key);
		if (index == data.length) {
			System.out.println("key not found");
		} else {
			//shift
			for (int i = index; i < size - 1; i++) {
				data[i] = data[i + 1];
			}
			size--;
		}
		return index;
	}

	/**
	 * O(N)
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

	public static void main(String[] args) {
		SequenceList array = new SequenceList();

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
		int result = array.linearSearch(47);
		System.out.println("search result:" + result);

		// delete
		array.delete(45);
		array.display();

	}

}
