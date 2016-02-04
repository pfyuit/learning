package com.pfyuit.myalgorithm.algorithm.free;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2
 * ⌋ times. You may assume that the array is non-empty and the majority element always exist in the array.
 * 核心思想：遍历数组，将每个数字出现的次数放入map中，当满足个数的时候，返回该数字
 * @author yupengfei
 */
public class MajorityElementTest {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 4, 5, 2, 5, 2, 5, 7, 8, 5, 3, 5, 9, 5, 5, 5, 5, 5 };
		System.out.println(majorityElement(nums));
	}

	public static int majorityElement(int[] nums) {
		int size = nums.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			}

			if (map.get(i) > (size / 2)) {
				return i;
			} else {
				int count = map.get(i);
				count = count + 1;
				map.put(i, count);
			}
		}
		return -1;
	}

}
