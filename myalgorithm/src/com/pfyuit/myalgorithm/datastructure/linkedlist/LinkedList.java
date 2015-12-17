package com.pfyuit.myalgorithm.datastructure.linkedlist;

/**
 * @author yupengfei
 */
public class LinkedList {

	/**
	 * Inner class to hold link node.
	 * @author yupengfei
	 */
	public class Link {
		public long data;
		public Link next;

		public Link(long data) {
			this.data = data;
		}

		public void display() {
			System.out.print(data + " ");
		}
	}

	/**
	 * First one of this linked list
	 */
	private Link first;

	/**
	 * Is linked list empty
	 * @return
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Insert a link node to the head
	 * @param value
	 */
	public void insertFirst(long value) {
		Link newLink = new Link(value);
		newLink.next = first; // null
		first = newLink;
	}

	/**
	 * Remove a link node from head
	 * @return
	 */
	public Link removeFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	/**
	 * Remove a link node from middle
	 * @param value
	 * @return
	 */
	public Link remove(long value) {
		Link current = first;
		Link previous = first;
		while (current != null) {
			// Find out the link node to delete.
			if (current.data == value) {
				if (current == first) {
					first = current.next;
				} else {
					previous.next = current.next;
				}
				return current;
			} else {
				// Move on to find out the link node.
				previous = current;
				current = current.next;
			}
		}
		return null;
	}

	/**
	 * Find a link node
	 * @param value
	 * @return
	 */
	public Link find(long value) {
		Link current = first;
		while (current != null) {
			if (current.data == value) {
				return current;
			} else {
				current = current.next;
			}
		}
		return null;
	}

	/**
	 * Traverse all the link node
	 */
	public void traverse() {
		Link current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		// insert
		System.out.println("==>insert data...");
		list.insertFirst(123);
		list.insertFirst(3);
		list.insertFirst(45);
		list.insertFirst(789);
		list.insertFirst(11);
		list.insertFirst(43);
		list.insertFirst(20);
		list.insertFirst(48);

		// traverse
		System.out.println("==>traverse data...");
		list.traverse();
		System.out.println();

		// find
		System.out.println("==>find data...");
		Link e = list.find(45);
		System.out.println(e.data);

		// remove given link
		System.out.println("==>delete data from middle...");
		Link e1 = list.remove(48);
		System.out.println(e1.data);

		// remove first
		System.out.println("==>delete data from head...");
		while (!list.isEmpty()) {
			Link temp = list.removeFirst();
			temp.display();
		}

	}

}
