package com.pfyuit.myalgorithm.sandbox;

public class LinkedListFirstLast {

	public class Link {
		public long data;
		public Link next;

		public Link(long value) {
			this.data = value;
		}

		public void displayLink() {
			System.out.println(data);
		}
	}

	public Link first;
	public Link last;

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(long key) {
		Link newLink = new Link(key);
		if (isEmpty()) {
			last = newLink;
		}
		newLink.next = first;
		first = newLink;
	}

	public void insertLast(long key) {
		Link newLink = new Link(key);
		if (isEmpty()) {
			first = newLink;
			last = newLink;
		} else {
			last.next = newLink;
			last = newLink;
		}
	}

	public Link removeFirst() {
		if (first.next == null) {
			Link temp = first;
			first = first.next;
			last = null;
			return temp;
		} else {
			Link temp = first;
			first = first.next;
			return temp;
		}
	}

	public void display() {
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
		list.display();
		System.out.println();

		// remove first
		while (!list.isEmpty()) {
			Link temp = list.removeFirst();
			temp.displayLink();
		}

	}

}
