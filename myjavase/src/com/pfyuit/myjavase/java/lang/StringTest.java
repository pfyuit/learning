package com.pfyuit.myjavase.java.lang;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

public class StringTest {

	public static void main(String[] args) {
		valueOf();
		format();
		copyValueOf();

		charAt();
		compare();
		index();
		upperLowercase();
		length();
		replace();
		split();
		substring();
		charArray();
		getBytes();
	}

	public static void valueOf() {
		String b = String.valueOf(true);
		String c = String.valueOf('c');
		String ca = String.valueOf(new char[] { 'a', 'b' });
		String d = String.valueOf(new Double(1.23));
		String f = String.valueOf(new Float(1.23));
		String i = String.valueOf(new Integer(2));
		String l = String.valueOf(new Long(1));
		String o = String.valueOf(new Object());
	}

	public static void format() {
		String str = String.format("%d is %s", 123, "hello");
		System.out.println(str);

		str = String.format(Locale.getDefault(), "%d is %s", 123, "hello");
		System.out.println(str);
	}

	public static void copyValueOf() {
		String str = String.copyValueOf(new char[] { 'a', 'b', 'c' });
		System.out.println(str);

		str = String.copyValueOf(new char[] { 'a', 'b', 'c' }, 1, 1);
		System.out.println(str);
	}

	public static void charAt() {
		String str = new String("hello world");
		char c = str.charAt(1);
		System.out.println(c);

		int i = str.codePointAt(1);
		System.out.println(i);

		i = str.codePointBefore(1);
		System.out.println(i);

		i = str.codePointCount(0, 5);
		System.out.println(i);
	}

	public static void compare() {
		String str = new String("hello world");
		int i = str.compareTo("hello world");
		System.out.println(i);

		i = str.compareToIgnoreCase("Hello World");
		System.out.println(i);

		boolean b = str.equals("hello world");
		System.out.println(b);

		b = str.equalsIgnoreCase("Hello World");
		System.out.println(b);

		CharSequence cs = new StringBuffer("hello world");
		CharSequence cs1 = new StringBuilder("hello world");
		b = str.contentEquals(cs);
		System.out.println(b);

		b = str.contentEquals(cs1);
		System.out.println(b);
	}

	public static void index() {
		String str = new String("hello world");
		boolean b = str.contains("hello");
		System.out.println(b);

		b = str.startsWith("hello");
		System.out.println(b);

		b = str.endsWith("world");
		System.out.println(b);

		int i = str.indexOf('h');
		System.out.println(i);

		i = str.indexOf("hello");
		System.out.println(i);

		b = str.isEmpty();
		System.out.println(b);

		i = str.lastIndexOf("o");
		System.out.println(i);
	}

	public static void upperLowercase() {
		String str = new String("hello world");
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
	}

	public static void length() {
		String str = new String(" hello world ");
		int i = str.length();
		System.out.println(i);

		str = str.trim();
		i = str.length();
		System.out.println(i);
	}

	public static void replace() {
		String str = new String("hello world");
		str = str.replace('o', 'x');
		System.out.println(str);

		str = new String("hello world");
		CharSequence target = new StringBuilder("hello");
		CharSequence replacement = new StringBuilder("hey");
		str = str.replace(target, replacement);
		System.out.println(str);

		str = new String("hello world");
		str = str.replaceAll("hello", "hay");
		System.out.println(str);
	}

	private static void getBytes() {
		String str = new String("hello world");
		byte[] bs = str.getBytes();
		for (byte b : bs) {
			System.out.println(b);
		}

		bs = str.getBytes(Charset.defaultCharset());
		for (byte b : bs) {
			System.out.println(b);
		}

		try {
			bs = str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		for (byte b : bs) {
			System.out.println(b);
		}
	}

	private static void charArray() {
		String str = new String("hello world");
		char[] cs = str.toCharArray();
		for (char c : cs) {
			System.out.println(c);
		}
	}

	private static void substring() {
		String str = new String("hello world");
		String ss = str.substring(1);
		System.out.println(ss);

		ss = str.substring(1, 5);
		System.out.println(ss);

		CharSequence cs = str.subSequence(1, 5);
		System.out.println(ss);
	}

	private static void split() {
		String str = new String("hello world");
		String[] ca = str.split(" ");
		for (String c : ca) {
			System.out.println(c);
		}
	}

}
