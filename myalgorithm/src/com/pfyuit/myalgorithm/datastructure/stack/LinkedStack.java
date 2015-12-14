package com.pfyuit.myalgorithm.datastructure.stack;

import com.pfyuit.myalgorithm.datastructure.linkedlist.LinkedList;

/**
 * @author yupengfei
 */
public class LinkedStack {

	/**
	 * Inner data to hold linked stack
	 */
	private LinkedList list = new LinkedList();

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void push(long value) {
		list.insertFirst(value);
	}

	public long pop() {
		return list.removeFirst().data;
	}

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
