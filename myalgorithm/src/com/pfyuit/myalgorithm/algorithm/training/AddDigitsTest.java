package com.pfyuit.myalgorithm.algorithm.training;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit. For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it. Follow up: Could
 * you do it without any loop/recursion in O(1) runtime?
 * @author yupengfei
 */
public class AddDigitsTest {

	public static void main(String[] args) {
		System.out.println(addDigits(12345));
	}

	public static int addDigits(int num) {
		if (num < 10) {
			return num;
		}

		// 获取该数字的所有位
		List<Integer> dits = new ArrayList<>();
		int source = num;
		while (true) {
			int remain = source / 10;
			int digital = source % 10;
			dits.add(digital);

			if (remain == 0) {
				break;
			}
			source = remain;
		}

		// 对所有位求和
		int sum = 0;
		for (int i : dits) {
			sum += i;
		}

		// 递归
		return addDigits(sum);
	}

}
