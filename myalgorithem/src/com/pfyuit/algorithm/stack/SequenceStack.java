package com.pfyuit.algorithm.stack;

public class SequenceStack {

	private long[] data;
	private int maxSize;
	private int top;

	public SequenceStack(int maxSize) {
		this.maxSize = maxSize;
		data = new long[maxSize];
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return getSize() == maxSize;
	}

	public int getSize() {
		return top + 1;
	}

	public void push(long value) {
		data[++top] = value;
	}

	public long pop() {
		return data[top--];
	}

	public long peek() {
		return data[top];
	}

	public static void main(String[] args) {
		SequenceStack stack = new SequenceStack(100);
		stack.push(123);
		stack.push(34);
		stack.push(45);
		stack.push(678);
		stack.push(12);
		stack.push(111);
		stack.push(2);

		System.out.println(stack.peek());
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
