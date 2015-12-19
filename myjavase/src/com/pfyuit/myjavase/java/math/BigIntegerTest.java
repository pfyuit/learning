package com.pfyuit.myjavase.java.math;

import java.math.BigInteger;

public class BigIntegerTest {

	public static void main(String[] args) {
		BigInteger bi = new BigInteger("1234567890");
		System.out.println("Construct from String: " + bi);

		BigInteger bi1 = new BigInteger("a".getBytes());
		System.out.println("Construct from byte array: " + bi1);

		BigInteger bi3 = BigInteger.valueOf(new Long(1234566666));
		System.out.println("Construct from value of long: " + bi3);

		System.out.println("Int value: " + bi.intValue());
		System.out.println("Long value: " + bi.longValue());
		System.out.println("Float value: " + bi.floatValue());
		System.out.println("Double value: " + bi.doubleValue());

		BigInteger result = bi.add(bi1);
		System.out.println("Add: " + result);

		result = bi.subtract(bi1);
		System.out.println("Subtract: " + result);

		result = bi.multiply(bi1);
		System.out.println("Multiply: " + result);

		result = bi.divide(bi1);
		System.out.println("Divide: " + result);

		result = bi.remainder(bi1);
		System.out.println("Remainder: " + result);

		result = bi.mod(bi1);
		System.out.println("Remainder: " + result);

		result = bi.pow(2);
		System.out.println("Remainder: " + result);

	}

}
