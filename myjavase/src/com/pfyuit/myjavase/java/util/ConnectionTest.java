package com.pfyuit.myjavase.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ConnectionTest {

	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<>();

		// add()
		for (int i = 0; i < 10; i++) {
			collection.add(i);
		}

		// addAll()
		List<Integer> subList = Arrays.asList(new Integer[] { 10, 11, 12 });
		collection.addAll(subList);

		// clear()
		// collection.clear();

		// contains()
		System.out.println(collection.contains(1));

		// containsAll()
		System.out.println(collection.containsAll(subList));

		// isEmpty()
		System.out.println(collection.isEmpty());

		// iterator()
		Iterator<Integer> it = collection.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// remove()
		collection.remove(1);

		// removeAll()
		collection.removeAll(subList);

		// retainAll()
		collection.retainAll(Arrays.asList(new Integer[] { 2, 3 }));

		// size()
		System.out.println(collection.size());

		// toArray()
		Object[] objs = collection.toArray();
		for (Object obj : objs) {
			System.out.println((Integer) obj);
		}

		// toArray()
		Integer[] ints = collection.toArray(new Integer[0]);
		for (Integer i : ints) {
			System.out.println(i);
		}
	}

}
