package com.pfyuit.algorithm.stack;

import com.pfyuit.algorithm.list.LinkedList;

public class LinkedStack {

	/**
	 * Linked list as the inner implementation
	 */
	private LinkedList list = new LinkedList();

	/**
	 * Is the stack empty
	 * @return
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Push data: insert data at fist
	 * @param value
	 */
	public void push(long value) {
		list.insertFirst(value);
	}

	/**
	 * Pop data: remove data at first
	 * @return
	 */
	public long pop() {
		return list.removeFirst().data;
	}

	/**
	 * Display all the data
	 */
	public void displayStack() {
		list.displayList();
	}

	public static void main(String[] args) {
		LinkedStack stack = new LinkedStack();
		stack.push(123);
		stack.push(34);
		stack.push(45);
		stack.push(678);
		stack.push(12);
		stack.push(111);
		stack.push(2);

		stack.displayStack();

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
