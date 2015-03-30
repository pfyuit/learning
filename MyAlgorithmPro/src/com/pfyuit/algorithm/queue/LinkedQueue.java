package com.pfyuit.algorithm.queue;

import com.pfyuit.algorithm.list.LinkedListFirstLast;

public class LinkedQueue {

	/**
	 * Linked list (first last) as inner implementation
	 */
	private LinkedListFirstLast list = new LinkedListFirstLast();

	/**
	 * Is the queue empty
	 * @return
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Insert value at last
	 * @param value
	 */
	public void insert(long value) {
		list.insertLast(value);
	}

	/**
	 * Remove value at first
	 * @return
	 */
	public long remove() {
		return list.removeFirst().data;
	}

	/**
	 * Display all the values
	 */
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
