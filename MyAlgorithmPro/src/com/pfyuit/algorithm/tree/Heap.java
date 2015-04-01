package com.pfyuit.algorithm.tree;

public class Heap {

	public class Node {
		public long data;
		public Node leftChild;
		public Node rightChild;

		public Node(long value) {
			data = value;
		}
	}

	public Node[] nodes;
	public int maxSize;
	public int size;

	public Heap(int maxSize) {
		this.maxSize = maxSize;
		nodes = new Node[this.maxSize];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == maxSize;
	}

	public int getSize() {
		return size;
	}

	public boolean insert(long value) {
		if (isFull()) {
			return false;
		}

		Node node = new Node(value);
		nodes[size] = node;
		trickleUp(size++);
		return true;
	}

	private void trickleUp(int index) {
		int parent = (index - 1) / 2;
		Node temp = nodes[index];
		while (index > 0 && nodes[parent].data < temp.data) {
			nodes[index] = nodes[parent];
			index = parent;
			parent = (parent - 1) / 2;
		}
		nodes[index] = temp;
	}

	public Node remove() {
		if (isEmpty()) {
			return null;
		}

		Node root = nodes[0];
		nodes[0] = nodes[--size];
		trickleDown(0);

		return root;
	}

	private void trickleDown(int index) {
		int largerChild;
		Node temp = nodes[index];
		while (index < size / 2) {
			int leftChild = 2 * index + 1;
			int rightChild = 2 * index + 2;

			if (leftChild < size
					&& nodes[leftChild].data < nodes[rightChild].data) {
				largerChild = rightChild;
			} else {
				largerChild = leftChild;
			}

			if (nodes[largerChild].data <= temp.data) {
				break;
			}

			nodes[index] = nodes[largerChild];

			index = largerChild;
		}

		nodes[index] = temp;
	}

	public static void main(String[] args) {
		Heap heap = new Heap(100);

		// insert
		heap.insert(12);
		heap.insert(4);
		heap.insert(38);
		heap.insert(100);
		heap.insert(110);
		heap.insert(2);
		heap.insert(1136);
		heap.insert(223);
		heap.insert(98);

		// remove
		while (!heap.isEmpty()) {
			System.out.println(heap.remove().data);
		}

	}

}
