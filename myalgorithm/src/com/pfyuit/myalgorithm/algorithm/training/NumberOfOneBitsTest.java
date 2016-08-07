package com.pfyuit.myalgorithm.algorithm.training;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming
 * weight). For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the
 * function should return 3.
 * @author yupengfei
 */
public class NumberOfOneBitsTest {

	// TODO: Need to investigate more
	public static void main(String[] args) {
		long n = 2147483648L;
		System.out.println(n);
		System.out.println(n - 1);
		System.out.println(hammingWeight((int) (n)));
	}

	public static int hammingWeight(int n) {
		int ones = 0;
		long value = n & 0x0FFFFFFFF;
		while (true) {
			long remain = (value / 2);
			long mod = (value % 2);
			if (mod == 1) {
				ones++;
			}
			if (remain == 0) {
				break;
			}
			value = remain;
		}
		return ones;
	}

}
