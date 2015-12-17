package com.pfyuit.myalgorithm.datastructure.queue;

import com.pfyuit.myalgorithm.datastructure.linkedlist.LinkedListFirstLast;

/**
 * @author yupengfei
 */
public class LinkedQueue {

	/**
	 * Use linked list (first-last) to implement linked queue.
	 */
	private LinkedListFirstLast list = new LinkedListFirstLast();

	/**
	 * Is linked queue empty
	 * @return
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Insert data to tail
	 * @param value
	 */
	public void insert(long value) {
		list.insertLast(value);
	}

	/**
	 * Remove data from head
	 * @return
	 */
	public long remove() {
		return list.removeFirst().data;
	}

	/**
	 * Traverse all the data in linked queue.
	 */
	public void displayQueue() {
		list.traverse();
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
