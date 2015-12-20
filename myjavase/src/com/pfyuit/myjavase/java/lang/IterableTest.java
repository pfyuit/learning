package com.pfyuit.myjavase.java.lang;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Custom class to implement Iterable.
 * @author yupengfei
 */
public class IterableTest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3 });
		MyCollection<Integer> myCollection = new MyCollection<>(list);
		Iterator<Integer> iterator = myCollection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	/**
	 * Custom class to implement {@link Iterable#iterator()}.
	 * @author yupengfei
	 * @param <E>
	 */
	public static class MyCollection<E> implements Iterable<E> {

		private List<E> list;

		public MyCollection(List<E> list) {
			this.list = list;
		}

		@Override
		public Iterator<E> iterator() {
			return list.iterator();
		}
	}

}
