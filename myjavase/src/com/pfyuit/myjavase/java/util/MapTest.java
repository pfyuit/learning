package com.pfyuit.myjavase.java.util;

import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.WeakHashMap;

/**
 * 
 * @author yupengfei
 * 
 *    ------------(I)Map--------------------------------------------------------------------- --------------------------------------------------     (A)Dictionary
 *    |       |            |          |           |                   |                     |                                                  |     |
 *    |-------|-------(A)AbstractMap--|-----------|---------------(I)SortedMap--------------|-----------------------------                  Hashtable
 *    |       |             |         |        |  |           |         |                   |                  |         |                     |
 *    HashMap |             WeakHashMap       IdentityHashMap |  (I)NavigableMap     (I)ConcurrentMap----------|-------  |                 Properties
 *    |       |                                               |        |    |                |                 |      |  |
 *   LinkedHashMap                                            -----TreeMap   --(I)ConcurrentNavigableMap       |  ConcurrentHashMap
 *                                                                                           |                 | 
 *                                                                             ConcurrentSkipListMap------------
 */																	              
  
public class MapTest {

	public static void main(String[] args) {
		testHashMap();
		testLinkedHashMap();
		testWeakHashMap();
		testIdentityHashMap();
		testTreeMap();
		testHashtable();
		testProperties();
	}

	private static void testHashMap() {
		System.out.println("testHashMap");
		// put/putAll
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		Map<Integer, String> subMap = new HashMap<>();
		subMap.put(3, "c");
		map.putAll(subMap);
		for (Integer key : map.keySet()) {
			System.out.println(key + "==>" + map.get(key));
		}

		// clear
		map.clear();
		for (Integer key : map.keySet()) {
			System.out.println(key + "==>" + map.get(key));
		}

		// containsKey
		map.put(1, "a");
		map.put(2, "b");
		System.out.println(map.containsKey(1));

		// containsValue
		System.out.println(map.containsValue("a"));

		// entrySet
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}

		// isEmpty
		System.out.println(map.isEmpty());

		// remove
		map.remove(3);

		// values
		for (String value : map.values()) {
			System.out.println(value);
		}

	}

	private static void testLinkedHashMap() {
		System.out.println("testLinkedHashMap");
		Map<Integer,String> map = new LinkedHashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}

	private static void testWeakHashMap() {
		System.out.println("testWeakHashMap");
		Map<Integer,String> map = new WeakHashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}

	private static void testIdentityHashMap() {
		System.out.println("testIdentityHashMap");
		Map<Integer,String> map = new IdentityHashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}

	private static void testTreeMap() {
		System.out.println("testTreeMap");
		Map<Integer, String> map = new TreeMap<>();
		map.put(1, "a");
		map.put(3, "b");
		map.put(2, "c");
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}

		Map<Integer, String> hashmap = new HashMap<>();
		hashmap.put(1, "a");
		hashmap.put(3, "b");
		hashmap.put(2, "c");
		Map<Integer, String> map1 = new TreeMap<>(hashmap);
		map1.put(1, "a");
		map1.put(3, "b");
		map1.put(2, "c");
		for (Map.Entry<Integer, String> entry : map1.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}

		Map<Integer, String> map2 = new TreeMap<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		map2.put(1, "a");
		map2.put(3, "b");
		map2.put(2, "c");
		for (Map.Entry<Integer, String> entry : map2.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}

	
	private static void testHashtable() {
		System.out.println("testHashtable");
		Hashtable<Integer, String> table = new Hashtable<>();
		table.put(1, "a");
		table.put(3, "b");
		table.put(2, "c");
		for (Map.Entry<Integer, String> entry : table.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}
	
	private static void testProperties() {
		System.out.println("testHashtable");
		Properties pro = new Properties();
		pro.setProperty("1", "a");
		pro.setProperty("2", "b");
		pro.setProperty("3", "c");
		
		System.out.println(pro.getProperty("1"));
		System.out.println(pro.getProperty("4", "temp"));
		Enumeration e = pro.elements();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement().toString());
		}
		pro.list(System.out);
	}

}
