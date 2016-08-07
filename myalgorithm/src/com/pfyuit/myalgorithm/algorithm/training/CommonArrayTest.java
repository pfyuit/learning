package com.pfyuit.myalgorithm.algorithm.training;

/**
 * Get common array from two arrays, then print the max size of the common
 * array.
 * @author yupengfei
 */
public class CommonArrayTest {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 9, 4, 6, 9, 3, 5, 7 };
		int[] b = { 1, 2, 4, 5, 9, 4, 6, 7, 3, 5 };
		int maxSize = getMaxCommonArraySize(a, b);
		System.out.println("maxSize: " + maxSize);
	}

	public static int getMaxCommonArraySize(int[] a, int[] b) {
		int maxSize = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				System.out.println("=>Sub array from a[]: ");
				for (int k = i; k <= j; k++) {
					System.out.print(a[k] + ",");
				}
				System.out.println();

				boolean isMatch = match(a, b, i, j);
				if (isMatch) {
					System.out.println("=>Has matched sub array in b[]");
					int tempSize = j - i + 1;
					if (tempSize > maxSize) {
						maxSize = tempSize;
					}
				} else {
					System.out.println("=>No matched sub array in b[]");
				}
				System.out.println();

			}
		}
		return maxSize;
	}

	public static boolean match(int[] a, int[] b, int i, int j) {
		int length = j - i + 1;

		boolean match = false;
		for (int index = 0; index < b.length; index++) {
			if ((b.length - 1 - index + 1) < length) {
				return false;
			}

			boolean temp = true;
			for (int m = i, n = index; m <= j; m++, n++) {
				if (a[m] != b[n]) {
					temp = false;
					break;
				}
			}

			match = temp;
			if (match) {
				return true;
			}
		}
		return match;
	}
}
