package com.pfyuit.myalgorithm.sandbox;

public class LinkedList {

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

	public Link first;

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(long value) {
		Link newLink = new Link(value);
		newLink.next = first;
		first = newLink;
	}

	public Link removeFirst() {
		Link node = first;
		first = first.next;
		return node;
	}

	public Link remove(long data) {
		Link current = first;
		Link previous = first;

		while (current != null) {
			if (current.data == data) {
				if (current == first) {
					first = first.next;
					return current;
				} else {
					previous.next = current.next;
					return current;
				}
			} else {
				previous = current;
				current = current.next;
			}
		}

		return null;
	}

	public void display() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertFirst(123);
		list.insertFirst(234);
		list.display();

		list.removeFirst();
		list.display();
	}

}
