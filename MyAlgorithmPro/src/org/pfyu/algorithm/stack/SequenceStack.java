package org.pfyu.algorithm.stack;

public class SequenceStack {
	
	private long[] data;
	private int maxSize;
	private int top;

	/**
	 * Constructor
	 * @param maxSize
	 */
	public SequenceStack(int maxSize) {
		this.maxSize = maxSize;
		data = new long[maxSize];
		top = -1;
	}

	/**
	 * Is the stack empty
	 * @return
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * Is the stack full
	 * @return
	 */
	public boolean isFull() {
		return getSize() == maxSize;
	}
	
	/**
	 * Get the size of stack
	 * @return
	 */
	public int getSize() {
		return top + 1;
	}

	/**
	 * Push data
	 * @param value
	 */
	public void push(long value) {
		data[++top] = value;
	}

	/**
	 * Pop data
	 * @return
	 */
	public long pop() {
		return data[top--];
	}

	/**
	 * Peek data at top
	 * @return
	 */
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
