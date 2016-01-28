package com.pfyuit.myjavase.java.lang;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yupengfei
 */
public class OutOfMemoryErrorTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		int i = 0;
		while (true) {
			list.add(Integer.toString(i).intern());
			i++;
		}
	}

}
