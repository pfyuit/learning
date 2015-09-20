package com.pfyuit.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author yupengfei
 *                                                   (I)Iterable
 *                                                       |
 *                                                       |
 *                     			   -------------(I)Collection----------------------------------------------------------------------------------------------------------
 *                                |                      |                                         |                                                                   |
 *                                |	     ---------------(A)AbstractCollection----------------------|-------------------------------------------------------            | 
 *                                |		 |                                                |        |                                                       |           |
 *                     |--------(I)List--|----------------                      	------|-------(I)Set------------------                                        |----(I)Queue --------------------   	
 *					   |		  |      |               |                          |     |        |         |            |                                |      |      |                        |
 * 				       |          |      |               |                          |     |        |         |            |                                |      |      |                        | 
 *                     |    (A)AbstractList              |                          |    (A)AbstractSet (I)SortedSet      |                                |------|--  (A)AbstractQueue           |            
 *                     |   |          |                  |                          |     |        |         |            |                                       |            |    |             |
 *                     |   |          |                  |                          |     |        |         |            |                                       |            |    |          	(I)Deque-----
 *                     |   |          |                  |                          |     |        |         |            |                                       |            |    |          	|    		|
 *                ArrayList  (A)AbstractSequentialList   |                          |     |        |   (I)NavigableSet    |                                   (I)BlockingQueue |    |          	|      		LinkedList
 *                                    |                  |                          |     |        |         |            |             		   |--------------|			   |	|			|			 		
 *                                LinkedList--------------						    HashSet		   -------- TreeSet       |                        |              |            |    |        (I)BlockingDeque
 *                                													  |								      |	    ArrayBlockingQueue LinkedBlockingQueue         |              |
 *                                                                                LinkedHashSet---------------------------                                 	                   |------------- |
 *                                                                                                                                                                            LinkedBlockingDeque
 *                                                           
 *                                
 */
public class ListTest {

	public static void main(String[] args) {
		testArrayList();
		testLinkedList();
	}

	private static void testArrayList() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");

		list.add(2, "c");

		List<String> subList = new ArrayList<String>();
		subList.add("d");
		subList.add("e");
		list.addAll(subList);

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next();
			System.out.println(s);
		}

		for (String s : list) {
			System.out.println(s);
		}

		boolean isExisting = list.contains("a");
		System.out.println(isExisting);

		isExisting = list.containsAll(Arrays.asList(new String[] { "a", "b" }));
		System.out.println(isExisting);

		System.out.println(list.get(1));

		System.out.println(list.indexOf("a"));

		System.out.println(list.isEmpty());

		System.out.println(list.lastIndexOf("a"));

		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			String s = listIterator.next();
			System.out.println(s);
		}

		System.out.println("====");
		while (listIterator.hasPrevious()) {
			String s = listIterator.previous();
			System.out.println(s);
		}

		System.out.println("====");
		listIterator.remove();
		while (listIterator.hasNext()) {
			String s = listIterator.next();
			System.out.println(s);
		}

		System.out.println("====");
		listIterator.add("f");
		while (listIterator.hasPrevious()) {
			String s = listIterator.previous();
			System.out.println(s);
		}

		System.out.println("====");
		list.add(0, "a");
		list.remove("f");
		for (String s : list) {
			System.out.println(s);
		}

		System.out.println("====");
		list.removeAll(Arrays.asList(new String[] { "a", "b" }));
		for (String s : list) {
			System.out.println(s);
		}

		System.out.println("====");
		list.retainAll(Arrays.asList(new String[] { "c", "d" }));
		for (String s : list) {
			System.out.println(s);
		}

		System.out.println(list.size());

		System.out.println(list.subList(0, 2));

		Object[] objs = list.toArray();

		String[] strs = list.toArray(new String[0]);
	}
	
	private static void testLinkedList() {
		// TODO Auto-generated method stub
		
	}

}
