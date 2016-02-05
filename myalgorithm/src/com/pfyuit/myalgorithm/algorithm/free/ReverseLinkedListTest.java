package com.pfyuit.myalgorithm.algorithm.free;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse a singly linked list. click to show more hints. Hint: A linked list can be reversed either iteratively or
 * recursively. Could you implement both?
 * @author yupengfei
 */
public class ReverseLinkedListTest {

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
		print(_1);
		// print(reverseList(_1));
		print(reverseList1(_1));
	}

	// use extra space
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		List<ListNode> nodes = new ArrayList<ListNode>();
		ListNode current = head;
		while (current != null) {
			nodes.add(current);
			current = current.next;
		}

		int size = nodes.size();
		for (int i = size - 1; i >= 1; i--) {
			nodes.get(i).next = nodes.get(i - 1);
		}
		nodes.get(0).next = null;
		head = nodes.get(size - 1);
		return head;
	}

	// just in place
	public static ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode previous = head;
		ListNode current = head.next;
		previous.next = null;
		while (current != null) {
			ListNode next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	private static void print(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
