package org.pfyu.algorithm.list;

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

	/**
	 * Reference of the first link
	 */
	private Link first;

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
		newLink.next = first;
		first = newLink;
	}

	/**
	 * Remove link at first
	 * @return
	 */
	public Link removeFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	/**
	 * Remove a link with the given key
	 * @param key
	 * @return
	 */
	public Link remove(long key) {
		Link current = first;
		Link previous = first;
		while (current != null) {
			//find the link
			if (current.data == key) {
				if (current == first) {
					first = current.next;
				} else {
					previous.next = current.next;
				}
				return current;
			} else {
				//move next
				previous = current;
				current = current.next;
			}
		}
		return null;
	}

	/**
	 * Find a link with the given key
	 * @param key
	 * @return
	 */
	public Link find(long key) {
		Link current = first;
		while (current != null) {
			//find the link
			if (current.data == key) {
				return current;
			} else {
				//move next
				current = current.next;
			}
		}
		return null;
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
