package com.pfyuit.myalgorithm.algorithm.training;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the
 * non-zero elements. For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12,
 * 0, 0]. Note: You must do this in-place without making a copy of the array. Minimize the total number of operations.
 * @author yupengfei
 */
public class MoveZeroesTest {

	public static void main(String[] args) {
		int[] nums = new int[8];
		nums[0] = 0;
		nums[1] = 1;
		nums[2] = 0;
		nums[3] = 3;
		nums[4] = 12;
		nums[5] = 0;
		nums[6] = 34;
		nums[7] = 29;
		print(nums);
		moveZeroes(nums);
	}

	public static void moveZeroes(int[] nums) {
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			if (nums[i] == 0) {
				// shift remaining array to left
				for (int index = i; index <= nums.length - 2; index++) {
					nums[index] = nums[index + 1];
				}

				// insert zero into the end of array
				nums[nums.length - 1] = 0;

				// reset i to the begin
				i = 0;

				// decrease j
				j--;
				print(nums);
			} else {
				i++;
			}
		}
	}

	private static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

}
