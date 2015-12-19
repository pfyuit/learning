package com.pfyuit.myjavase.java.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateFormatTest {

	public static void main(String[] args) throws ParseException {
		testFormat();
		testParse();
	}

	private static void testFormat() {
		System.out.println("==>testFormat");
		Timestamp ts = Timestamp.valueOf("2015-09-11 08:00:00");
		System.out.println("original timestamp: " + ts.getTime());
		System.out.println();

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

		formatter.setTimeZone(TimeZone.getTimeZone("GMT-8"));
		String formattedTime = formatter.format(ts);
		System.out.println("formatted string with GMT-8 timezone: " + formattedTime);
		System.out.println();

		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		formattedTime = formatter.format(ts);
		System.out.println("formatted string with GMT timezone: " + formattedTime);
		System.out.println();

		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		formattedTime = formatter.format(ts);
		System.out.println("formatted string with GMT+8 timezone: " + formattedTime);
		System.out.println();
	}

	private static void testParse() throws ParseException {
		System.out.println("==>testParse");
		String timeStr = "2015-09-11 08:00:00";

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

		formatter.setTimeZone(TimeZone.getTimeZone("GMT-8"));
		Date date = formatter.parse(timeStr);
		System.out.println(date);// JVM默认时区

		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		date = formatter.parse(timeStr);
		System.out.println(date);// JVM默认时区

		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		date = formatter.parse(timeStr);
		System.out.println(date);// JVM默认时区
	}

}
