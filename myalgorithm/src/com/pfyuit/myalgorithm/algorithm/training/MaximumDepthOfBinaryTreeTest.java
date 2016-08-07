package com.pfyuit.myalgorithm.algorithm.training;

/**
 * Given a binary tree, find its maximum depth. The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 * @author yupengfei
 */
public class MaximumDepthOfBinaryTreeTest {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);

		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(9);
		TreeNode node5 = new TreeNode(10);
		TreeNode node6 = new TreeNode(11);
		TreeNode node7 = new TreeNode(12);
		TreeNode node8 = new TreeNode(13);

		root.left = left;
		root.right = right;

		left.left = node1;
		left.right = node2;

		node1.left = node3;
		node1.right = node4;

		node2.left = node5;
		node5.left = node6;
		node5.right = node7;
		node7.left = node8;

		printTreeNodes(root);

		System.out.println("==>" + maxDepth(root));

	}

	public static void printTreeNodes(TreeNode root) {
		System.out.print(root.val + " ");
		if (root.left != null) {
			printTreeNodes(root.left);
		}
		if (root.right != null) {
			printTreeNodes(root.right);
		}
	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftDepth = maxDepth(root.left);
			int rightDepth = maxDepth(root.right);
			return leftDepth < rightDepth ? rightDepth + 1 : leftDepth + 1;
		}
	}

}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
