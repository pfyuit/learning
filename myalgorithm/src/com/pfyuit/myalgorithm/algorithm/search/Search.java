package com.pfyuit.myalgorithm.algorithm.search;

import com.pfyuit.myalgorithm.datastructure.tree.BinarySearchTree;
import com.pfyuit.myalgorithm.datastructure.tree.BinarySearchTree.Node;

/**
 * @author yupengfei
 */
public class Search {

	/**
	 * Linear search
	 * @param data
	 * @param key
	 * @return
	 */
	public static int linearSearch(int[] data, int key) {
		int i;
		for (i = 0; i < data.length; i++) {
			if (data[i] == key) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Binary search
	 * @param data
	 * @param key
	 * @return
	 */
	public static int binarySearch(int[] data, int key) {
		int low = 0;
		int high = data.length - 1;
		int mid;

		while (true) {
			mid = (low + high) / 2;
			if (data[mid] == key) {
				return mid;
			} else if (data[mid] > key) {
				high = mid - 1;
			} else if (data[mid] < key) {
				low = mid + 1;
			}

			if (low > high) {
				return -1;
			}
		}
	}

	/**
	 * Binary search tree search
	 * @param data
	 * @param key
	 * @return
	 */
	public static Node binarySearchTreeSearch(int[] data, int key) {
		BinarySearchTree tree = new BinarySearchTree();
		for (int i : data) {
			tree.insert(i);
		}
		return tree.find(key);
	}

	public static void main(String[] args) {
		int[] data = { 1, 3, 5, 7, 9, 23, 145, 368, 999, 1009 };

		int result = linearSearch(data, 999);
		System.out.println("linear search result: " + result);

		result = binarySearch(data, 999);
		System.out.println("binary search result: " + result);

		Node result1 = binarySearchTreeSearch(data, 999);
		System.out.println("binary search tree search result: " + result1.data);
	}

}
