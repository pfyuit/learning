package com.pfyuit.myjavase.java.text;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class DecimalFormatTest {

	public static void main(String[] args) {
		BigDecimal amount = new BigDecimal(123456789.0983);

		String symbolLeft = "USD";

		String thousandsPoint = ","; // 千位分隔符
		String decimalPoint = "."; // 小数点
		String decimalPlaces = "2"; // 小数位数

		DecimalFormatSymbols format = new DecimalFormatSymbols();
		format.setDecimalSeparator(decimalPoint.charAt(0));

		DecimalFormat formatter = new DecimalFormat();
		formatter.setGroupingUsed(true);
		format.setGroupingSeparator(thousandsPoint.charAt(0));

		formatter.setDecimalFormatSymbols(format);
		formatter.setMaximumFractionDigits(Integer.parseInt(decimalPlaces));
		formatter.setMinimumFractionDigits(Integer.parseInt(decimalPlaces));

		String result = symbolLeft + " " + formatter.format(amount.doubleValue());
		System.out.println(result);
	}

}
