package com.pfyuit.algorithm.free;

/**
 * 获取两个数组的公共子数组，要求不能使用额外存储空间。 算法：取第一个数组的所有子数组（1+2+3。。。+N)个，在第二个数组中逐个匹配
 * @author yupengfei
 */
public class GetCommonArrayTest {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 9, 4, 6, 9, 3, 5, 7 };
		int[] b = { 1, 2, 4, 5, 9, 4, 6, 7, 3, 5 };
		int size = getMaxCommonArraySize(a, b);
		System.out.println("maxSize: " + size);
	}

	public static int getMaxCommonArraySize(int[] a, int[] b) {
		int size = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				boolean isMatch = match(a, b, i, j);
				if (isMatch) {
					for (int k = i; k <= j; k++) {
						System.out.print(a[k] + ",");
					}
					System.out.println();

					int tempSize = j - i + 1;
					if (tempSize > size) {
						size = tempSize;
					}
				}
			}
		}
		return size;
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
