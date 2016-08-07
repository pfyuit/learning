package com.pfyuit.myalgorithm.algorithm.training;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once. For example, Given
 * 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * @author yupengfei
 */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(3);
		first.next = second;
		second.next = third;
		deleteDuplicates(first);
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		//TODO: 
		return null;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
