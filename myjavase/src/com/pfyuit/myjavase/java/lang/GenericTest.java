package com.pfyuit.myjavase.java.lang;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * Operations of Generic Type
 * @author yupengfei
 */
public class GenericTest {

	public static void main(String[] args) {
		// Generic type with one parameter.
		Generic<String> generic = new Generic<>();
		generic.setTarget("hello");
		System.out.println(generic.getTarget());

		// Generic type with two parameters.
		Generic1<Integer, String> generic1 = new Generic1<>(1, "hello");
		System.out.println(generic1.getkey() + ":" + generic1.getValue());

		// Generic type with one restricted parameter(one super class).
		Generic2<String> generic2 = new Generic2<>("hello");
		System.out.println(generic2.getTarget());

		// Generic type with one restricted parameter(two super class).
		Generic21<String> generic21 = new Generic21<>("hello");
		System.out.println(generic21.getTarget());

		// Generic type in regular class.
		Generic3 generic3 = new Generic3();
		System.out.println(generic3.getFirst(new String[] { "first", "last" }));
		System.out.println(Generic3.getLast(new String[] { "first", "last" }));

		// Can't create generic type using primitive type.
		// Generic<double> generic = new Generic<>(); //wrong

		// Cant' create generic type array.
		// Generic<String>[] generics = new Generic<String>[10]; //wrong

		// Different generic type will equal.
		Generic<String> stringGeneric = new Generic<>();
		Generic<Date> dateGeneric = new Generic<>();
		System.out.println(stringGeneric.getClass().equals(dateGeneric.getClass()));

		// Generic<Manager> has nothing to do with Generic<Employee> even Manager is sub class of Employee.
		// Generic<Manager> employee = new Generic<>(new Employee());//wrong
		// Generic<Employee> employee = new Generic<>(new Manager());//wrong

		Generic<? extends Employee> employee1 = new Generic<>(new Employee());
		Generic<? extends Employee> employee2 = new Generic<>(new Manager());
		System.out.println(employee1.getClass().equals(employee2.getClass()));

		Generic<? super Manager> employee3 = new Generic<>(new Employee());
		Generic<? super Manager> employee4 = new Generic<>(new Manager());
		System.out.println(employee3.getClass().equals(employee4.getClass()));
		
		Factory<String, File> factory = new FactoryImpl();
	}

}

/**
 * Generic class with one parameter
 * @author yupengfei
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
 * @author yupengfei
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
 * Generic class with restricted parameter type: one parameter
 * @author yupengfei
 */
class Generic2<T extends Comparable<?>> {

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
 * Generic class with restricted parameter type: one parameters
 * @author yupengfei
 */
class Generic21<T extends Comparable<?> & Serializable> {

	private T target;

	public Generic21() {
	}

	public Generic21(T t) {
		this.target = t;
	}

	public T getTarget() {
		return target;
	}

}

/**
 * Generic method in regular class
 * @author yupengfei
 */
class Generic3 {

	public <T> T getFirst(T[] array) {
		return array[0];
	}

	public static <T> T getLast(T[] array) {
		return array[array.length - 1];
	}

}

/**
 * Static singleton instance can't work
 * @author yupengfei
 * @param <T>
 */
class Sington<T extends Throwable> {

	// Can't reference generic type in a static field.
	// private static T singtonInstance; //wrong

	// Can't reference generic type in a static method.
	// public static T getInstance(){ //wrong
	// }

	// Can't catch a generic type
	// public void doWork(Class<T> t){
	// try{
	// //
	// }catch(T e){
	// //
	// }
	// }

	// Can throw a generic type
	public void doWork(T t) throws T {
		try {
			//
		} catch (Throwable cause) {
			t.initCause(cause);
			throw t;
		}
	}
}

// wrong: Generic type can't extend Throwable
// class CustomException<T> extends Exception{
//
// }

/**
 * Example class to apply generic type
 * @author yupengfei
 */
class Employee {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

/**
 * Example sub class to apply generic type
 * @author yupengfei
 */
class Manager extends Employee {

	private String managerNo;

	public String getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
	}
}

/**
 * Interface with generic type
 * @author yupengfei
 * @param <I>
 * @param <O>
 */
interface Factory<I, O> {

	public O generate(I input);
}

/**
 * Class to implements the interface
 * @author yupengfei
 */
class FactoryImpl implements Factory<String, File> {

	@Override
	public File generate(String input) {
		return null;
	}
}
