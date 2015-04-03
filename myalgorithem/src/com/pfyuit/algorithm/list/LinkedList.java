package com.pfyuit.algorithm.list;

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

	private Link first;

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(long value) {
		Link newLink = new Link(value);
		newLink.next = first;
		first = newLink;
	}

	public Link removeFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	public Link remove(long key) {
		Link current = first;
		Link previous = first;
		while (current != null) {
			if (current.data == key) {
				if (current == first) {
					first = current.next;
				} else {
					previous.next = current.next;
				}
				return current;
			} else {
				previous = current;
				current = current.next;
			}
		}
		return null;
	}

	public Link find(long key) {
		Link current = first;
		while (current != null) {
			if (current.data == key) {
				return current;
			} else {
				current = current.next;
			}
		}
		return null;
	}

	public void displayList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		// insert
		list.insertFirst(123);
		list.insertFirst(3);
		list.insertFirst(45);
		list.insertFirst(789);
		list.insertFirst(11);
		list.insertFirst(43);
		list.insertFirst(20);
		list.insertFirst(48);

		// display
		list.displayList();
		System.out.println();

		// find
		Link e = list.find(45);
		System.out.println(e.data + "\r\n");

		// remove given link
		Link e1 = list.remove(48);
		System.out.println(e1.data + "\r\n");

		// remove first
		while (!list.isEmpty()) {
			Link temp = list.removeFirst();
			temp.displayLink();
		}

	}

}
