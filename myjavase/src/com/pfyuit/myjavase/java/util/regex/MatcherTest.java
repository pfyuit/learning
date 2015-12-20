package com.pfyuit.myjavase.java.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Operations of Pattern/Matcher
 * @author yupengfei
 */
public class MatcherTest {

	private static final String input = "hello12e1fewqfo23~!8*(3${data.name}example123456!@@#${data.age}";

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("(\\$\\{([a-z.]+)\\})");
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			String expression = matcher.group();
			System.out.println(expression);
		}
	}

}
