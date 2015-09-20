package com.pfyuit.java.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionsTest {

	public static void main(String[] args) {

		// empty list
		{
			System.out.println("==>empty list");
			List<?> emptyList = Collections.EMPTY_LIST;
			System.out.println(emptyList.size());
			emptyList = Collections.emptyList();
			System.out.println(emptyList.size());
		}

		// empty set
		{
			System.out.println("==>empty set");
			Set<?> emptySet = Collections.EMPTY_SET;
			System.out.println(emptySet.size());
			emptySet = Collections.emptySet();
			System.out.println(emptySet.size());
		}

		// empty map
		{
			System.out.println("==>empty map");
			Map<?, ?> emptyMap = Collections.EMPTY_MAP;
			System.out.println(emptyMap.size());
			emptyMap = Collections.emptyMap();
			System.out.println(emptyMap.size());
		}

		// empty iterator
		{
			System.out.println("==>empty iterator");
			Iterator<?> emptyIterator = Collections.emptyIterator();
			while (emptyIterator.hasNext()) {
				System.out.println(emptyIterator.next());
			}
		}

		// empty list iterator
		{
			System.out.println("==>empty list iterator");
			ListIterator<?> emptyListIterator = Collections.emptyListIterator();
			while (emptyListIterator.hasNext()) {
				System.out.println(emptyListIterator.next());
			}
			while (emptyListIterator.hasPrevious()) {
				System.out.println(emptyListIterator.previous());
			}
		}

		// empty enumeration
		{
			System.out.println("==>empty enumeration");
			Enumeration<?> emptyEnum = Collections.emptyEnumeration();
			while (emptyEnum.hasMoreElements()) {
				System.out.println(emptyEnum.nextElement());
			}
		}

		// binary search
		{
			System.out.println("==>binary search");
			List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			System.out.println(Collections.binarySearch(list, 5));
			System.out.println(Collections.binarySearch(list, 5, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			}));
		}

		// checked
		{
			System.out.println("==>checked");
			List rawList = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			Collection<Integer> checkedCollection = Collections.checkedCollection(rawList, Integer.class);
			List<Integer> checkedInteger = Collections.checkedList(rawList, Integer.class);

			Set rawSet = new HashSet();
			rawSet.add(1);
			rawSet.add(2);
			Set<Integer> checkedSet = Collections.checkedSet(rawSet, Integer.class);

			SortedSet rawSortedSet = new TreeSet();
			rawSortedSet.add(1);
			rawSortedSet.add(2);
			SortedSet<Integer> checkedSortedSet = Collections.checkedSortedSet(rawSortedSet, Integer.class);

			Map rawMap = new HashMap();
			rawMap.put(1, "a");
			rawMap.put(2, "b");
			Map<Integer, String> chckedMap = Collections.checkedMap(rawMap, Integer.class, String.class);

			SortedMap rawSortedMap = new TreeMap();
			rawSortedMap.put(1, "a");
			rawSortedMap.put(2, "b");
			SortedMap<Integer, String> chckedrawSortedMap = Collections.checkedSortedMap(rawSortedMap, Integer.class, String.class);
		}

		// copy()
		{
			System.out.println("==>copy");
			List<Integer> src = Arrays.asList(new Integer[] { 11, 12 });
			List<Integer> dest = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			Collections.copy(dest, src);
			for (Integer i : dest) {
				System.out.println(i);
			}
		}

		// disjoint()
		{
			List<Integer> src = Arrays.asList(new Integer[] { 11, 12 });
			List<Integer> dest = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			System.out.println("==>disjoint");
			System.out.println(Collections.disjoint(src, dest));
		}

		// enumeration()
		{
			List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			System.out.println("==>enumeration");
			Enumeration<Integer> enumeration = Collections.enumeration(list);
			while (enumeration.hasMoreElements()) {
				System.out.println(enumeration.nextElement());
			}
		}

		// fill()
		{
			System.out.println("==>fill");
			List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			Collections.fill(list, 10);
			for (Integer i : list) {
				System.out.println(i);
			}
		}

		// frequency()
		{
			System.out.println("==>freequency");
			List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			System.out.println(Collections.frequency(list, 5));
		}

		// indexOf
		{
			System.out.println("==>indexOf");
			List<Integer> source = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			List<Integer> target = Arrays.asList(new Integer[] { 5, 6, 7 });
			System.out.println(Collections.indexOfSubList(source, target));
			System.out.println(Collections.lastIndexOfSubList(source, target));
		}

		// list()
		{
			System.out.println("==>list");
			List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			System.out.println("==>enumeration");
			Enumeration<Integer> enumeration = Collections.enumeration(list);

			List<Integer> list1 = Collections.list(enumeration);
			for (Integer i : list1) {
				System.out.println(i);
			}
		}

		// max-min
		{

			System.out.println("==>max-min");
			List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			System.out.println(Collections.max(list));
			System.out.println(Collections.min(list));
			System.out.println(Collections.max(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			}));
			System.out.println(Collections.min(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			}));
		}

		// nCopies()
		{
			System.out.println("==>nCopies");
			List<Integer> list = Collections.nCopies(10, 1);
			for (Integer i : list) {
				System.out.println(i);
			}
		}

		// replaceAll()
		{
			System.out.println("==>replaceAll");
			List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			Collections.replaceAll(list, 5, 15);
			for (Integer i : list) {
				System.out.println(i);
			}
		}

		// reverse
		{
			System.out.println("==>reverse");
			List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			Integer[] array = list.toArray(new Integer[0]);
			Collections.reverse(list);
			Arrays.sort(array, Collections.reverseOrder());
			for (Integer i : list) {
				System.out.println(i);
			}
			for (Integer i : array) {
				System.out.println(i);
			}
		}

		// rotate()
		{
			System.out.println("==>rotate");
			List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			Collections.rotate(list, 2);
			for (Integer i : list) {
				System.out.println(i);
			}
		}

		// shuffle()
		{
			System.out.println("==>shuffle");
			List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			Collections.shuffle(list);
			for (Integer i : list) {
				System.out.println(i);
			}
			Collections.shuffle(list, new Random());
		}

		// singleton
		{
			System.out.println("==>singleton");
			Set<Integer> set = Collections.singleton(5);
			List<Integer> list = Collections.singletonList(5);
			Map<Integer, String> map = Collections.singletonMap(1, "hello");
			try {
				set.add(5);
				list.add(5);
				map.put(1, "world");
			} catch (Exception e) {
				System.out.println("Can't change immutable collections");
			}
		}

		// sort
		{
			System.out.println("==>sort");
			List<Integer> list = Arrays.asList(new Integer[] { 5, 2, 3, 4, 1, 8, 7, 6, 9, 10 });
			Collections.sort(list);
			for (Integer i : list) {
				System.out.println(i);
			}
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			for (Integer i : list) {
				System.out.println(i);
			}
		}

		// swap()
		{
			System.out.println("==>swap");
			List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			Collections.swap(list, 1, 2);
			for (Integer i : list) {
				System.out.println(i);
			}
		}

		// synchronized
		{
			System.out.println("==>synchronized");
			List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			// List<Integer> syncCollection = (List<Integer>) Collections.synchronizedCollection(list);
			List<Integer> syncList = Collections.synchronizedList(list);

			Set<Integer> set = new HashSet<>();
			set.add(1);
			set.add(2);
			Set<Integer> syncSet = Collections.synchronizedSet(set);

			Map<Integer, String> map = new HashMap<>();
			map.put(1, "hello");
			Map<Integer, String> syncMap = Collections.synchronizedMap(map);

			SortedSet<Integer> sortedSet = new TreeSet<>();
			sortedSet.add(1);
			sortedSet.add(2);
			SortedSet syncSortedSet = Collections.synchronizedSortedSet(sortedSet);

			SortedMap<Integer, String> sortedMap = new TreeMap<>();
			sortedMap.put(1, "hello");
			SortedMap<Integer, String> syncSortedMap = Collections.synchronizedSortedMap(sortedMap);
		}

		// unmodified
		{
			System.out.println("==>unmodified");
			List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			List<Integer> immutableList = Collections.unmodifiableList(list);
			try {
				immutableList.add(11);
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			Set<Integer> set = new HashSet<>();
			set.add(1);
			set.add(2);
			Set<Integer> immutableSet = Collections.unmodifiableSet(set);
			try {
				immutableSet.add(11);
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			Map<Integer, String> map = new HashMap<>();
			map.put(1, "hello");
			Map<Integer, String> immutableMap = Collections.unmodifiableMap(map);
			try {
				immutableMap.put(1, "hello");
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			SortedSet<Integer> sortedSet = new TreeSet<>();
			sortedSet.add(1);
			sortedSet.add(2);
			SortedSet<Integer> immutableSortedSet = Collections.unmodifiableSortedSet(sortedSet);
			try {
				immutableSortedSet.add(11);
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			SortedMap<Integer, String> sortedMap = new TreeMap<>();
			sortedMap.put(1, "hello");
			SortedMap<Integer, String> immutableSortedMap = Collections.unmodifiableSortedMap(sortedMap);
			try {
				immutableSortedMap.put(1, "hello");
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}

	}

}
