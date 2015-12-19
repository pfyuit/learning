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
		SequenceQueue queue = new SequenceQueue(100);
		queue.insert(123);
		queue.insert(34);
		queue.insert(444);
		queue.insert(567);
		queue.insert(213);
		queue.insert(2);
		queue.insert(345);
		queue.insert(3);
		queue.insert(128);
		queue.insert(20);

		while (!queue.isEmpty()) {
			System.out.print(queue.remove() + " ");
		}
	}

}
