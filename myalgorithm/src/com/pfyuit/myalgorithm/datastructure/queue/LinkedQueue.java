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
		LinkedQueue queue = new LinkedQueue();
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
