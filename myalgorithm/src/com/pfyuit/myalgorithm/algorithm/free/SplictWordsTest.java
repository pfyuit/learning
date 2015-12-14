package com.pfyuit.myalgorithm.algorithm.free;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an input string and a dictionary of words, segment the input string
 * into a space-separated sequence of dictionary words if possible. For example,
 * if the input string is "applepie" and dictionary contains a standard set of
 * English words, then we would return the string "apple pie" as output.
 * 给定字典，对无空格的短语切词
 * @author yupengfei
 */
public class SplictWordsTest {

	private static List<String> DICTIONARY = Arrays.asList(new String[] { "apple", "pie", "cat" });

	public static void main(String[] args) {
		String description = "pieapplecat";
		List<String> output = splitWord(description);

		System.out.println("=>Matched words in dictionary:");
		for (String str : output) {
			System.out.println(str);
		}
	}

	private static List<String> splitWord(String description) {
		List<String> output = new ArrayList<>();

		char[] charArray = description.toCharArray();
		int length = charArray.length;

		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				String temp = getTempString(charArray, i, j);
				System.out.println("temp:" + temp);
				if (DICTIONARY.contains(temp)) {
					output.add(temp);
				}
			}
		}
		return output;
	}

	private static String getTempString(char[] charArray, int i, int j) {
		char[] result = new char[j - i + 1];
		for (int k = i; k < j + 1; k++) {
			result[k - i] = charArray[k];
		}
		return new String(result);
	}
}
