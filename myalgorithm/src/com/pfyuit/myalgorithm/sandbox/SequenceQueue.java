package com.pfyuit.myalgorithm.sandbox;

public class SequenceQueue {

	private long[] data;
	private int size;
	private int maxSize;
	private int front;
	private int rear;

	public SequenceQueue(int maxSize) {
		this.maxSize = maxSize;
		data = new long[maxSize];
		this.size = 0;
		this.front = 0;
		this.rear = -1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void insert(long value) {
		if (rear == maxSize - 1) {
			rear = -1;
		}
		data[++rear] = value;
		size++;
	}

	public long remove() {
		long temp = data[front++];
		if (front == maxSize) {
			front = 0;
		}
		size--;
		return temp;
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
