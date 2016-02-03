package com.pfyuit.myalgorithm.algorithm.free;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node. Supposed
 * the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 ->
 * 2 -> 4 after calling your function. 核心思想：把要删的节点的后续节点拿过来替换掉要删的节点即可
 * @author yupengfei
 */
public class DeleteNodeInALinkedListTest {

	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		first.next = second;
		second.next = third;

		deleteNode(second);
	}

	public static void deleteNode(ListNode node) {
		if (node.next == null) {
			System.out.println("can't delete the rear");
			return;
		}

		ListNode successor = node.next;
		if (successor != null) {
			node.val = successor.val;
			node.next = successor.next;
		}
	}

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
