package com.pfyuit.myalgorithm.datastructure.list;

/**
 * �������Ա��ṩ���²�����
 * ���Ա��Ƿ�Ϊ��
 * ���Ա��Ƿ�����
 * ���Ա��ȡ�ߴ�
 * ����Ԫ�أ������Ա�ĩβ����Ԫ��
 * ɾ��Ԫ�أ���Ԫ���Ժ��Ԫ����Ҫ��ǰŲλ
 * ����Ԫ�أ����Բ���
 * ����Ԫ��
 * @author yupengfei
 */
public class SequenceListUnordered {

	private long[] data;
	private int size = 0;
	private int maxSize = 0;

	public SequenceListUnordered(int maxSize) {
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
		data[size++] = key;
		return size;
	}

	public int delete(long key) {
		int index = linearSearch(key);
		if (index == data.length) {
			System.out.println("key not found");
		} else {
			//��ǰŲλ
			for (int i = index; i <= size - 2; i++) {
				data[i] = data[i + 1];
			}
			size--;
		}
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

	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.println(data[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SequenceListUnordered list = new SequenceListUnordered(100);

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
