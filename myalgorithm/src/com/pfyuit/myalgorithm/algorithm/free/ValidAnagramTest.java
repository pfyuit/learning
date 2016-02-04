package com.pfyuit.myalgorithm.algorithm.free;

/**
 * @author yupengfei
 */
public class ValidAnagramTest {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagrambctabc", "nagaramctbcba"));
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		int[] mask = new int[256];
		for (char c : sArray) {
			mask[c]++;
		}
		for (char c : tArray) {
			if (mask[c] > 0) {
				mask[c]--;
			} else {
				return false;
			}
		}
		return true;
	}

}
