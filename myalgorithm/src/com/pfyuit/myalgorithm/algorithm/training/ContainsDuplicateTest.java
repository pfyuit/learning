package com.pfyuit.myalgorithm.algorithm.training;

import java.util.Arrays;

/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value
 * appears at least twice in the array, and it should return false if every element is distinct.
 * 核心思想：先快排，再找重复数字
 * @author yupengfei
 */
public class ContainsDuplicateTest {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 4, 5, 7, 8, 2, 5 };
		System.out.println(containsDuplicate(nums));
	}

	public static boolean containsDuplicate(int[] nums) {
		if(nums.length==0){
			return false;
		}
		Arrays.sort(nums);
		int previous = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (previous == nums[i]) {
				return true;
			}
			previous = nums[i];
		}
		return false;
	}

}
