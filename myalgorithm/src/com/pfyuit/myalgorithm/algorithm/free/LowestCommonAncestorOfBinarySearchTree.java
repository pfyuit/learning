package com.pfyuit.myalgorithm.algorithm.free;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST. According to
 * the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest
 * node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
        /     \
       x       x
  For example,the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
 * Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA
 * definition.
 * @author yupengfei
 */
public class LowestCommonAncestorOfBinarySearchTree {

	public static void main(String[] args) {
		TreeNode _1 = new TreeNode(1);
		TreeNode _2 = new TreeNode(2);
		TreeNode _3 = new TreeNode(3);
		TreeNode _4 = new TreeNode(4);
		TreeNode _5 = new TreeNode(5);
		TreeNode _6 = new TreeNode(6);
		_5.left = _3;
		_5.right = _6;
		_3.left = _2;
		_3.right = _4;
		_2.left = _1;
		System.out.println(lowestCommonAncestor(_5, _1, _3).val);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (isChild(p, q)) {
			return p;
		}
		if (isChild(q, p)) {
			return q;
		}

		TreeNode parentP = getParent(root, p);
		TreeNode parentQ = getParent(root, q);
		
		if (parentP.val == parentQ.val) {
			return parentP;
		}

		return lowestCommonAncestor(root, parentP, parentQ);
	}

	private static TreeNode getParent(TreeNode root, TreeNode p) {
		TreeNode parent = root;
		TreeNode current = root;
		while (current != null) {
			if (p.val == current.val) {
				break;
			} else if (p.val < current.val) {
				parent = current;
				current = current.left;
			} else if (p.val > current.val) {
				parent = current;
				current = current.right;
			}
		}
		return parent;
	}

	private static boolean isChild(TreeNode parent, TreeNode child) {
		TreeNode current = parent;
		while (current != null) {
			if (child.val == current.val) {
				return true;
			} else if (child.val < current.val) {
				current = current.left;
			} else if (child.val > current.val) {
				current = current.right;
			}
		}
		return false;
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
