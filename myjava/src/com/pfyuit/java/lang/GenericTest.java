package com.pfyuit.java.lang;

public class GenericTest {

	public static void main(String[] args) {
		Generic<String> generic = new Generic<>();
		generic.setTarget("hello");
		System.out.println(generic.getTarget());

		Generic1<Integer, String> generic1 = new Generic1<>(1, "hello");
		System.out.println(generic1.getkey() + ":" + generic1.getValue());

		Generic2<String> generic2 = new Generic2<>("hello");
		System.out.println(generic2.getTarget());

		Generic3 generic3 = new Generic3();
		System.out.println(generic3.getFirst(new String[] { "first", "last" }));
		System.out.println(Generic3.getLast(new String[] { "first", "last" }));
	}

}

/**
 * Generic class with one parameter
 */
class Generic<T> {

	private T target;

	public Generic() {
	}

	public Generic(T t) {
		this.target = t;
	}

	public T getTarget() {
		return target;
	}

	public void setTarget(T t) {
		this.target = t;
	}

}

/**
 * Generic class with two parameters
 */
class Generic1<K, V> {

	private K key;
	private V value;

	public Generic1() {
	}

	public Generic1(K k, V v) {
		this.key = k;
		this.value = v;
	}

	public K getkey() {
		return key;
	}

	public V getValue() {
		return value;
	}

}

/**
 * Generic class with restricted parameter type
 */
class Generic2<T extends Comparable> {

	private T target;

	public Generic2() {
	}

	public Generic2(T t) {
		this.target = t;
	}

	public T getTarget() {
		return target;
	}

}

/**
 * Generic method in normal class
 */
class Generic3 {

	public <T> T getFirst(T[] array) {
		return array[0];
	}

	public static <T> T getLast(T[] array) {
		return array[array.length - 1];
	}

}
