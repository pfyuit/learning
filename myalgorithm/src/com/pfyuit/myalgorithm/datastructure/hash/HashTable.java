package com.pfyuit.myalgorithm.datastructure.hash;

/**
 * @author yupengfei
 */
public class HashTable {

	public DataItem[] dataItems;
	public int maxSize;
	public DataItem noItem = new DataItem(-1, null);

	public HashTable(int maxSize) {
		this.maxSize = maxSize;
		dataItems = new DataItem[this.maxSize];
	}

	/**
	 * Hash function
	 * @param key
	 * @return
	 */
	public int hashFunc(int key) {
		return key % maxSize;
	}

	/**
	 * Hash again function
	 * @param key
	 * @return
	 */
	public int hashFunc1(int key) {
		return 5 - key % 5;
	}

	/**
	 * Insert data
	 * @param data
	 */
	public void insert(DataItem data) {
		int key = data.key;
		int hash = hashFunc(key);

		// Find out the correct index to insert data.
		while (dataItems[hash] != null && dataItems[hash].key != -1) {
			hash += hashFunc1(key);
			hash %= maxSize;
		}
		dataItems[hash] = data;
	}

	/**
	 * Remove data
	 * @param key
	 * @return
	 */
	public DataItem remove(int key) {
		int hash = hashFunc(key);
		while (dataItems[hash] != null) {
			// Find out the index of this data, replace it with a no-item.
			if (dataItems[hash].key == key) {
				DataItem temp = dataItems[hash];
				dataItems[hash] = noItem;
				return temp;
			}

			hash += hashFunc1(key);
			hash %= maxSize;
		}
		return null;
	}

	/**
	 * Find data
	 * @param key
	 * @return
	 */
	public DataItem find(int key) {
		int hash = hashFunc(key);
		while (dataItems[hash] != null) {
			if (dataItems[hash].key == key) {
				return dataItems[hash];
			}

			hash += hashFunc1(key);
			hash %= maxSize;
		}
		return null;
	}

	/**
	 * Traverse all the data
	 */
	public void display() {
		for (int i = 0; i < dataItems.length; i++) {
			if (dataItems[i] != null && dataItems[i].key != -1) {
				System.out.print(dataItems[i].key + ":" + dataItems[i].value + " ");
			} else {
				System.out.print("* ");
			}
		}
	}

	public static void main(String[] args) {
		HashTable table = new HashTable(500);

		// insert
		table.insert(new DataItem(2, "hello"));
		table.insert(new DataItem(3, "hello"));
		table.insert(new DataItem(5, "hello"));
		table.insert(new DataItem(67, "hello"));
		table.insert(new DataItem(34, "hello"));
		table.insert(new DataItem(22, "hello"));
		table.insert(new DataItem(70, "hello"));

		// find
		System.out.println(table.find(34).key + ":" + table.find(34).value);

		// delete
		DataItem item = table.remove(34);
		System.out.println(item.key + ":" + item.value);

		// display
		table.display();
	}

}

/**
 * Wrapper class of hash table data.
 * @author yupengfei
 */
class DataItem {

	public int key;
	public String value;

	public DataItem(int key, String value) {
		this.key = key;
		this.value = value;
	}
}
