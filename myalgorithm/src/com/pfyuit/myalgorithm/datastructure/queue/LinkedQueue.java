package com.pfyuit.myalgorithm.datastructure.queue;

import com.pfyuit.myalgorithm.datastructure.list.LinkedListFirstLast;

public class LinkedQueue {

	private LinkedListFirstLast list = new LinkedListFirstLast();

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void insert(long value) {
		list.insertLast(value);
	}

	public long remove() {
		return list.removeFirst().data;
	}

	public void displayQueue() {
		list.displayList();
	}

	public static void main(String[] args) {
		LinkedQueue q = new LinkedQueue();
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
