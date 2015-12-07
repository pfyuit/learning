package com.pfyuit.myalgorithm.algorithm.free;

public class FetchNumberTest {

	private static int N = 5;

	public static void main(String[] args) {
		SequenceStack stack = new SequenceStack(N);
		int[] data = new int[] { 3, 5, 7, 11, 12, 19, 34, 89, 24 };
		int index = -1;
		test(stack, data, index);
	}

	private static void test(SequenceStack stack, int[] data, int index) {
		for (int i = index + 1; i < data.length; i++) {
			stack.push(new SequenceStack.Item(i, data[i]));
			if (stack.isFull()) {
				stack.print();
				System.out.println("===");
			}
			if (stack.isFull()) {
				index = stack.pop().getIndex();
				while ((data.length - 1 - index) < (N - stack.getSize())) {
					index = stack.pop().getIndex();
				}
				test(stack, data, index);
			}
		}
	}

}

class SequenceStack {

	private Item[] data;
	private int maxSize;
	private int top;

	public SequenceStack(int maxSize) {
		this.maxSize = maxSize;
		data = new Item[maxSize];
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

	public void push(Item value) {
		data[++top] = value;
	}

	public Item pop() {
		return data[top--];
	}

	public Item peek() {
		return data[top];
	}

	public void print() {
		for (Item item : data) {
			System.out.print(item.value + " ");
		}
	}

	public static class Item {

		private int value;
		private int index;

		public Item(int index, int value) {
			this.value = value;
			this.index = index;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

	}
}
