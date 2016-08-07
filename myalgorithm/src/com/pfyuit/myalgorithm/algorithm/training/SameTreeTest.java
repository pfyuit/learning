package com.pfyuit.myalgorithm.algorithm.training;

/**
 * Given two binary trees, write a function to check if they are equal or not. Two binary trees are considered equal if
 * they are structurally identical and the nodes have the same value.
 * 核心思想：比较节点的值，节点的左子树，右子树。递归。
 * @author yupengfei
 */
public class SameTreeTest {

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

		TreeNode _11 = new TreeNode(1);
		TreeNode _21 = new TreeNode(2);
		TreeNode _31 = new TreeNode(3);
		TreeNode _41 = new TreeNode(4);
		TreeNode _51 = new TreeNode(5);
		TreeNode _61 = new TreeNode(6);
		TreeNode _71 = new TreeNode(7);
		_11.left = _21;
		_11.right = _31;
		_21.left = _41;
		_21.right = _51;
		_31.left = _61;
		_31.right = _71;

		traverse(_1);
		System.out.println();
		System.out.println(isSameTree(_1, _11));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if (p == null || q == null) {
			return false;
		}

		if (p.val != q.val) {
			return false;
		}

		if (!isSameTree(p.left, q.left)) {
			return false;
		}

		if (!isSameTree(p.right, q.right)) {
			return false;
		}

		return true;
	}

	private static void traverse(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val + " ");
		traverse(node.left);
		traverse(node.right);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
