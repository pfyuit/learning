package com.pfyuit.myalgorithm.algorithm.training;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking
 * about the node number and not the value in the nodes. You should try to do it in place. The program should run in
 * O(1) space complexity and O(nodes) time complexity. Example: Given 1->2->3->4->5->NULL, return 1->3->5->2->4->NULL.
 * Note: The relative order inside both the even and odd groups should remain as it was in the input. The first node is
 * considered odd, the second node even and so on ...
 * @author yupengfei
 */
public class OddEvenLinkedListTest {

	public static void main(String[] args) {
		ListNode _1 = new ListNode(1);
		ListNode _2 = new ListNode(2);
		ListNode _3 = new ListNode(3);
		ListNode _4 = new ListNode(4);
		ListNode _5 = new ListNode(5);
		_1.next = _2;
		_2.next = _3;
		_3.next = _4;
		_4.next = _5;
		ListNode head = oddEvenList(_1);
		print(head);
	}

	public static ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode secondNode = head.next;
		if (secondNode == null) {
			return head;
		}
		if (secondNode.next == null) {
			return head;
		}

		ListNode second = null;
		ListNode previous = head;
		ListNode current = head;
		int index = 1;
		while (true) {
			ListNode nextNode = current.next;
			current.next = nextNode == null ? null : nextNode.next;

			if (index == 2) {
				second = current;
			}

			if (nextNode == null && index % 2 == 0) {
				previous.next = second;
				return head;
			} else if (nextNode == null && index % 2 != 0) {
				current.next = second;
				return head;
			} else if (nextNode != null) {
				previous = current;
				current = nextNode;
				index++;
			}

		}
	}

	private static void print(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
