package org.pfyu.algorithm.list;

public class LinkedListFirstLast {

	public class Link {
		public long data;
		public Link next;

		public Link(long data) {
			this.data = data;
		}

		public void displayLink() {
			System.out.println(data);
		}
	}

	/**
	 * Reference of the first link
	 */
	private Link first;
	
	/**
	 * Reference of the last link
	 */
	private Link last;

	/**
	 * Is the linked list empty
	 * @return
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Insert link at first
	 * @param value
	 */
	public void insertFirst(long value) {
		Link newLink = new Link(value);
		if (isEmpty()) {
			last = newLink;
		}
		newLink.next = first;
		first = newLink;
	}

	/**
	 * Insert link at last
	 * @param value
	 */
	public void insertLast(long value) {
		Link newLink = new Link(value);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
		}
		last = newLink;
	}

	/**
	 * Remove link at first
	 * @return
	 */
	public Link removeFirst() {
		Link temp = first;
		if (first.next == null) {//only one link
			last = null;
		}
		first = first.next;
		return temp;
	}

	/**
	 * Display the whole list
	 */
	public void displayList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}

	public static void main(String[] args) {
		LinkedListFirstLast list = new LinkedListFirstLast();

		// insert
		list.insertFirst(123);
		list.insertFirst(3);
		list.insertFirst(45);
		list.insertFirst(789);
		list.insertFirst(11);
		list.insertFirst(43);
		list.insertFirst(20);
		list.insertFirst(48);
		list.insertLast(1333);
		list.insertLast(12);
		list.insertLast(322);
		list.insertLast(1222);

		// display
		list.displayList();
		System.out.println();

		// remove first
		while (!list.isEmpty()) {
			Link temp = list.removeFirst();
			temp.displayLink();
		}

	}

}
