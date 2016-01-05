package com.pfyuit.myjavase.java.nio.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

/**
 * @author yupengfei
 */
public class CharsetTest {

	private static final Charset UTF8 = Charset.forName("UTF-8");

	public static void main(String[] args) {
		testAvailableCharsets();
		testDefaultCharset();
		testForName();
		testIsSupported();

		testDisplayName();
		testCanEncode();
		testIsRegistered();
		testName();
		testAliases();
		testEncode();
		testDecode();
	}

	private static void testIsSupported() {
		System.out.println("==>testIsSupported");
		System.out.println(Charset.isSupported("BIG5"));
	}

	private static void testDecode() {
		System.out.println("==>testDecode");
		String str = "hello";
		ByteBuffer buf = UTF8.encode(str);
		CharBuffer cBuf = UTF8.decode(buf);
		System.out.println(cBuf);
	}

	private static void testEncode() {
		System.out.println("==>testEncode");
		String str = "hello";
		ByteBuffer buf = UTF8.encode(str);
		byte[] bytes = buf.array();
		System.out.println(Arrays.toString(bytes));
	}

	private static void testAliases() {
		System.out.println("==>testAliases");
		System.out.println(UTF8.aliases());
	}

	private static void testName() {
		System.out.println("==>testName");
		System.out.println(UTF8.name());
	}

	private static void testIsRegistered() {
		System.out.println("==>testIsRegistered");
		System.out.println(UTF8.isRegistered());
	}

	private static void testCanEncode() {
		System.out.println("==>testCanEncode");
		System.out.println(UTF8.canEncode());
	}

	private static void testDefaultCharset() {
		System.out.println("==>testDefaultCharset");
		Charset defaultCharset = Charset.defaultCharset();
		System.out.println(defaultCharset.name());
	}

	private static void testAvailableCharsets() {
		System.out.println("==>testAvailableCharsets");
		Map<String, Charset> charsetMap = Charset.availableCharsets();
		for (String name : charsetMap.keySet()) {
			System.out.print(name + " ");
		}
	}

	private static void testForName() {
		System.out.println("==>testForName");
		Charset charset = Charset.forName("UTF-8");
		System.out.println(charset.name());
	}

	private static void testDisplayName() {
		System.out.println("==>testDisplayName");
		System.out.println(UTF8.displayName());
		System.out.println(UTF8.displayName(Locale.US));
	}

}
