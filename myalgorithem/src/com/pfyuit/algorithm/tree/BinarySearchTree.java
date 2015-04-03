package com.pfyuit.algorithm.tree;

public class BinarySearchTree {

	public class Node {
		public long data;
		public Node leftChild;
		public Node rightChild;

		public Node(long value) {
			data = value;
		}
	}

	public Node root;

	public void insert(long value) {
		Node node = new Node(value);
		if (root == null) {
			root = node;
			return;
		}

		Node current;
		Node parent;
		parent = current = root;
		while (true) {
			if (current.data > value) {
				parent = current;
				current = current.leftChild;
				if (current == null) {
					parent.leftChild = node;
					return;
				}
			} else if (current.data < value) {
				parent = current;
				current = current.rightChild;
				if (current == null) {
					parent.rightChild = node;
					return;
				}
			}
		}

	}

	public boolean delete(long key) {
		Node current, parent;
		parent = current = root;
		boolean isLeftChild = false;

		// find the node
		while (true) {
			// didn't find it
			if (current == null) {
				return false;
			}

			if (current.data == key) {
				break;
			} else if (current.data < key) {
				parent = current;
				current = current.rightChild;
				isLeftChild = false;
			} else if (current.data > key) {
				parent = current;
				current = current.leftChild;
				isLeftChild = true;
			}
		}

		// process node without child
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
			return true;
		}

		// process node with one child
		if (current.leftChild != null || current.rightChild != null) {
			if (current.leftChild != null) {
				if (current == root) {
					root = current.leftChild;
				} else if (isLeftChild) {
					parent.leftChild = current.leftChild;
				} else {
					parent.rightChild = current.leftChild;
				}
				return true;
			}
			if (current.rightChild != null) {
				if (current == root) {
					root = current.rightChild;
				} else if (isLeftChild) {
					parent.leftChild = current.rightChild;
				} else {
					parent.rightChild = current.rightChild;
				}
				return true;
			}
		}

		// process node with two child
		if (current.leftChild != null && current.rightChild != null) {
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.leftChild = successor;
			} else {
				parent.rightChild = successor;
			}
			return true;
		}

		return true;

	}

	private Node getSuccessor(Node delNode) {
		Node successorParent, successor, current;
		successorParent = successor = current = delNode;

		// find successor
		current = current.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		// reconnect
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		successor.leftChild = delNode.leftChild;

		return successor;
	}

	public Node find(long key) {
		Node current = root;

		while (current != null) {
			if (current.data == key) {
				return current;
			} else if (current.data > key) {
				current = current.leftChild;
			} else if (current.data < key) {
				current = current.rightChild;
			}
		}

		return null;
	}

	public void display() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.leftChild);
			System.out.println(node.data);
			inOrder(node.rightChild);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		// insert
		tree.insert(12);
		tree.insert(4);
		tree.insert(38);
		tree.insert(100);
		tree.insert(110);
		tree.insert(2);
		tree.insert(1136);
		tree.insert(223);
		tree.insert(98);

		// traverse
		tree.display();
		System.out.println();

		// search
		System.out.println(tree.find(38).data);
		System.out.println();

		// delete
		tree.delete(223);
		tree.delete(38);
		tree.delete(1136);
		tree.display();
	}

}
