package com.pfyuit.java.util;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class QueueTest {
	public static void main(String[] args) {
		testDeque();
	}

	private static void testDeque() {
		Deque<Integer> queue = new LinkedList<>();

		// addFirst
		queue.addFirst(1);
		queue.addFirst(2);

		// addLast
		queue.addLast(3);
		queue.addLast(4);

		// offer
		queue.offer(5);
		queue.offerFirst(6);
		queue.offerLast(7);

		System.out.println("traverse");
		Iterator<Integer> iters = queue.iterator();
		while (iters.hasNext()) {
			System.out.println(iters.next());
		}
		System.out.println("traverse end");

		// getFirst
		System.out.println(queue.getFirst());

		// getLast
		System.out.println(queue.getLast());

		// peek
		System.out.println(queue.peek());
		System.out.println(queue.peekFirst());
		System.out.println(queue.peekLast());

		// poll
		System.out.println(queue.poll());
		System.out.println(queue.pollFirst());
		System.out.println(queue.pollLast());

		// remove
		queue.remove();
		queue.removeFirst();
		queue.removeLast();

		// iterator
		System.out.println("traverse");
		Iterator<Integer> iters1 = queue.iterator();
		while (iters1.hasNext()) {
			System.out.println(iters1.next());
		}

	}
}
