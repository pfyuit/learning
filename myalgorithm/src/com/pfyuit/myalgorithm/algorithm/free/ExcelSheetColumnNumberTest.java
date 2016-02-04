package com.pfyuit.myalgorithm.algorithm.free;

/**
 * Related to question Excel Sheet Column Title Given a column title as appear in an Excel sheet, return its
 * corresponding column number. For example: A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 * 核心思想：将一个16进制的字符进行十进制求和
 * @author yupengfei
 */
public class ExcelSheetColumnNumberTest {

	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));
	}

	public static int titleToNumber(String s) {
		char[] array = s.toCharArray();

		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			int digital = (int) array[i]-64;
			int power = array.length - i - 1;
			int temp = (int) (digital * Math.pow(26, power));
			sum = sum + temp;
		}

		return sum;
	}

}
