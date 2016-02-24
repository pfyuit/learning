package com.pfyuit.myjavase.java.lang;

/**
 * @author yupengfei
 */
public class ByteTest {

	public static void main(String[] args) {
		byte b = 1;
		Byte aByte = new Byte(b);

		System.out.println(aByte.byteValue());
		System.out.println(aByte.intValue());
		System.out.println(aByte.shortValue());
		System.out.println(aByte.longValue());
		System.out.println(aByte.floatValue());
		System.out.println(aByte.doubleValue());

		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.SIZE);
		System.out.println(Byte.parseByte("1"));
		System.out.println(Byte.valueOf("1"));
		System.out.println(Byte.toString((byte) 1));
	}

}
