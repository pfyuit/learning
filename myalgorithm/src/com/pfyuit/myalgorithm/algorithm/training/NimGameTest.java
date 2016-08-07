package com.pfyuit.myalgorithm.algorithm.training;

/**
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you
 * take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first
 * turn to remove the stones. Both of you are very clever and have optimal strategies for the game. Write a function to
 * determine whether you can win the game given the number of stones in the heap. For example, if there are 4 stones in
 * the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be
 * removed by your friend.
 * 数学归纳法：
 * 1-ok
 * 2-ok
 * 3-ok
 * 4-x
 * 5-ok (5-1=4=x, 5-2=3=ok, 5-3=2=ok)
 * 6-ok
 * ......
 * 只要当前石头数目减去1，2，3对应前三次的记录里有不是winner的，则证明可以给对手制造不能赢的机会。
 * 经过归纳，发现只要石头数目是4的倍数，则当前选手就可以赢
 * @author yupengfei
 */
public class NimGameTest {

	public static void main(String[] args) {
		boolean result = isWinnder(15);
		System.out.println(result);
	}

	private static boolean isWinnder(int i) {
		return (i % 4 == 0) ? false : true;
	}

}
