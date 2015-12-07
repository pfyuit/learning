package com.pfyuit.myalgorithm.datastructure.list;

/**
 * 有序线性表。提供以下操作：
 * 线性表是否为空
 * 线性表是否已满
 * 线性表获取尺寸
 * 插入元素，经过排序，往线性表插入元素
 * 删除元素，该元素以后的元素需要往前挪位
 * 查找元素，二分查找
 * 遍历元素
 * @author yupengfei
 */
public class SequenceListOrdered {

	private long[] data;
	private int size = 0;
	private int maxSize = 0;

	public SequenceListOrdered(int maxSize) {
		this.maxSize = maxSize;
		data = new long[this.maxSize];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == maxSize;
	}

	public int getSize() {
		return size;
	}

	public int insert(long key) {
		//找到插入位置下标
		int i;
		for (i = 0; i < size; i++) {
			if (data[i] > key) {
				break;
			}
		}

		//往后挪位
		for (int j = size; j >= i + 1; j--) {
			data[j] = data[j - 1];
		}

		//插入元素
		data[i] = key;
		size++;
		return i;
	}

	public int delete(long key) {
		int index = binarySearch(key);
		if (index == data.length) {
			System.out.println("key not found");
		} else {
			//后面元素往前挪位
			for (int i = index; i <= size - 2; i++) {
				data[i] = data[i + 1];
			}
			size--;
		}
		return index;
	}

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

	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.println(data[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SequenceListOrdered array = new SequenceListOrdered(100);

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
