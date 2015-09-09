package com.pfyuit.java.util;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
		testHashSet();
		testLinkedHashSet();
		testTreeSet();
	}

	private static void testHashSet() {
		System.out.println("==>testHashSet");

		// add
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(3);
		set.add(2);
		set.add(2);
		set.add(4);

		// addAll
		Set<Integer> subSet = new HashSet<Integer>();
		subSet.add(5);
		set.addAll(subSet);

		// contains
		System.out.println(set.contains(1));

		// containsAll
		System.out.println(set.containsAll(subSet));

		// isEmpty
		System.out.println(set.isEmpty());

		// toArray
		set.toArray();
		set.toArray(new Integer[0]);

		// iterator
		for (Integer i : set) {
			System.out.println(i);
		}
	}

	private static void testLinkedHashSet() {
		System.out.println("==>testLinkedHashSet");
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.add(1);
		set.add(3);
		set.add(2);
		set.add(2);
		set.add(4);

		for (Integer i : set) {
			System.out.println(i);
		}
	}

	private static void testTreeSet() {
		System.out.println("==>testTreeSet");
		Set<Integer> set = new TreeSet<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		set.add(1);
		set.add(3);
		set.add(2);
		set.add(2);
		set.add(4);

		for (Integer i : set) {
			System.out.println(i);
		}
		
		//TODO
	}

}
