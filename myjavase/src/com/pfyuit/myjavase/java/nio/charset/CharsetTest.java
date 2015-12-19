package com.pfyuit.myjavase.java.nio.charset;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 * @author yupengfei
 */
public class CharsetTest {

	private static final Charset UTF8 = Charset.forName("UTF-8");

	public static void main(String[] args) {
		System.out.println(UTF8.displayName());
		System.out.println(UTF8.displayName(Locale.US));
	}

}
