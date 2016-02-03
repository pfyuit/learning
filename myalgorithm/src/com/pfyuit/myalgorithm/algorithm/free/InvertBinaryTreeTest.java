package com.pfyuit.myalgorithm.algorithm.free;

/**
 * 核心思想：递归
 * @author yupengfei
 */
public class InvertBinaryTreeTest {

	public static void main(String[] args) {
		TreeNode _1 = new TreeNode(1);
		TreeNode _2 = new TreeNode(2);
		TreeNode _3 = new TreeNode(3);
		TreeNode _4 = new TreeNode(4);
		TreeNode _5 = new TreeNode(5);
		TreeNode _6 = new TreeNode(6);
		TreeNode _7 = new TreeNode(7);
		_1.left = _2;
		_1.right = _3;
		_2.left = _4;
		_2.right = _5;
		_3.left = _6;
		_3.right = _7;

		traverse(_1);
		System.out.println();
		traverse(invertTree(_1));
	}

	private static void traverse(TreeNode _1) {
		if (_1 == null) {
			return;
		}
		System.out.print(_1.val + " ");
		traverse(_1.left);
		traverse(_1.right);
	}

	public static TreeNode invertTree(TreeNode node) {
		if (node == null)
			return null;

		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;

		invertTree(node.left);
		invertTree(node.right);

		return node;
	}

	/**
	 * Definition for a binary tree node.
	 */
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
