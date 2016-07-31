package com.pfyuit.myalgorithm.datastructure.graph;

/**
 * @author yupengfei
 */
public class PriorityQueue {

	public PriorityQueueNode[] nodes;
	public int size;
	public int maxSize;

	public PriorityQueue(int maxSize) {
		this.maxSize = maxSize;
		nodes = new PriorityQueueNode[this.maxSize];
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

		PriorityQueueNode node = new PriorityQueueNode(value);
		nodes[size] = node;
		trickleUp(size++);
		return true;
	}

	public boolean insert(PriorityQueueNode node) {
		if (isFull()) {
			return false;
		}

		nodes[size] = node;
		trickleUp(size++);
		return true;
	}

	private void trickleUp(int index) {
		int parent = (index - 1) / 2;
		PriorityQueueNode temp = nodes[index];
		while (index > 0 && nodes[parent].data > temp.data) {
			nodes[index] = nodes[parent];
			index = parent;
			parent = (parent - 1) / 2;
		}
		nodes[index] = temp;
	}

	public PriorityQueueNode remove() {
		if (isEmpty()) {
			return null;
		}

		PriorityQueueNode root = nodes[0];
		nodes[0] = nodes[--size];
		trickleDown(0);

		return root;
	}

	private void trickleDown(int index) {
		int largerChild;
		PriorityQueueNode temp = nodes[index];
		while (index < size / 2) {
			int leftChild = 2 * index + 1;
			int rightChild = 2 * index + 2;

			if (leftChild < size && nodes[leftChild].data > nodes[rightChild].data) {
				largerChild = rightChild;
			} else {
				largerChild = leftChild;
			}

			if (nodes[largerChild].data >= temp.data) {
				break;
			}

			nodes[index] = nodes[largerChild];

			index = largerChild;
		}

		nodes[index] = temp;
	}

	public static void main(String[] args) {
		PriorityQueue heap = new PriorityQueue(100);

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
