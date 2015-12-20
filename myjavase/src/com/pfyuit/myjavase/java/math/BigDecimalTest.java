package com.pfyuit.myjavase.java.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Operations for BigDecimal
 * @author yupengfei
 */
public class BigDecimalTest {

	public static void main(String[] args) {
		BigDecimal bd = new BigDecimal(new Integer(1000));
		System.out.println("Construct from int: " + bd);

		BigDecimal bd1 = new BigDecimal(new Long(1000));
		System.out.println("Construct from long: " + bd1);

		// May not precise as expected
		BigDecimal bd2 = new BigDecimal(new Float(89.123456789));
		System.out.println("Construct from float: " + bd2);

		// May not precise as expected
		BigDecimal bd3 = new BigDecimal(new Double(89.1234567890123456789));
		System.out.println("Construct from double: " + bd3);

		// Precise as expected, so we'd better use String as the parameter
		BigDecimal bd4 = new BigDecimal(new String("89.1234567890123456789"));
		System.out.println("Construct from String: " + bd4);

		BigDecimal bd5 = new BigDecimal(new BigInteger("1000"));
		System.out.println("Construct from BigInteger: " + bd5);

		BigDecimal bd6 = BigDecimal.valueOf(new Long(100000));
		System.out.println("Construct from value of long: " + bd6);

		// May not precise as expected
		BigDecimal bd7 = BigDecimal.valueOf(new Double(89.1234567890123456789));
		System.out.println("Construct from value of double: " + bd7);

		BigDecimal result = bd.add(bd1);
		System.out.println("Add: " + result);

		result = bd.subtract(bd2);
		System.out.println("Substract: " + result);

		result = bd.multiply(bd2);
		System.out.println("Multiply: " + result);

		result = bd.divide(bd2, 10, RoundingMode.UP);
		System.out.println("Divide with round_up: " + result);

		result = bd.divide(bd2, 10, RoundingMode.DOWN);
		System.out.println("Divide with round_down: " + result);

		result = bd.divide(bd2, 10, RoundingMode.FLOOR);
		System.out.println("Divide with round_floor: " + result);

		result = bd.divide(bd2, 10, RoundingMode.CEILING);
		System.out.println("Divide with round_ceiling: " + result);

		result = bd.divide(bd2, 10, RoundingMode.HALF_UP);
		System.out.println("Divide with round_half_up: " + result);

		result = bd.divide(bd2, 10, RoundingMode.HALF_DOWN);
		System.out.println("Divide with round_half_down: " + result);

		result = bd.divide(bd2, 10, RoundingMode.HALF_EVEN);
		System.out.println("Divide with round_half_even: " + result);

		double i = 3.856;

		// 舍掉小数取整
		System.out.println("舍掉小数取整:Math.floor(3.856)=" + (int) Math.floor(i));

		// 四舍五入取整
		System.out.println("四舍五入取整:(3.856)=" + new BigDecimal(i).setScale(0, BigDecimal.ROUND_HALF_UP));

		// 四舍五入保留两位小数
		System.out.println("四舍五入取整:(3.856)=" + new BigDecimal(i).setScale(2, BigDecimal.ROUND_HALF_UP));

		// 凑整，取上限
		System.out.println("凑整:Math.ceil(3.856)=" + (int) Math.ceil(i));

		// 舍掉小数取整
		System.out.println("舍掉小数取整:Math.floor(-3.856)=" + (int) Math.floor(-i));
		// 四舍五入取整
		System.out.println("四舍五入取整:(-3.856)=" + new BigDecimal(-i).setScale(0, BigDecimal.ROUND_HALF_UP));

		// 四舍五入保留两位小数
		System.out.println("四舍五入取整:(-3.856)=" + new BigDecimal(-i).setScale(2, BigDecimal.ROUND_HALF_UP));

		// 凑整，取上限
		System.out.println("凑整(-3.856)=" + (int) Math.ceil(-i));
	}
}
