package com.pfyuit.myalgorithm.datastructure.queue;

/**
 * @author yupengfei
 */
public class SequenceQueue {

	private long[] data;
	private int size;
	private int maxSize;
	private int front;
	private int rear;

	public SequenceQueue(int maxSize) {
		this.maxSize = maxSize;
		data = new long[maxSize];
		size = 0;
		front = 0;
		rear = -1;
	}

	/**
	 * Is sequence queue empty
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Is sequence queue full
	 * @return
	 */
	public boolean isFull() {
		return size == maxSize;
	}

	/**
	 * Get sequence queue size
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Insert data to tail
	 * @param value
	 */
	public void insert(long value) {
		if (rear == maxSize - 1) {
			rear = -1;
		}
		data[++rear] = value;
		size++;
	}

	/**
	 * Remove data from head
	 * @return
	 */
	public long remove() {
		long value = data[front++];
		if (front == maxSize) {
			front = 0;
		}
		size--;
		return value;
	}

	/**
	 * Peek data
	 * @return
	 */
	public long peek() {
		return data[front];
	}

	public static void main(String[] args) {
		SequenceQueue q = new SequenceQueue(100);
		q.insert(123);
		q.insert(34);
		q.insert(444);
		q.insert(567);
		q.insert(213);
		q.insert(2);
		q.insert(345);
		q.insert(3);
		q.insert(128);
		q.insert(20);

		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}

	}

}
