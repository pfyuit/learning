package com.pfyuit.myjavase.java.sql;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author yupengfei 
 * Timestamp��ʱ���޹� ��������Ϊ�ڲ��������long�͵�����
 * Timestamp�е�long�����ݿ�����Ϊ��[��ǰ����ʱ��ת����GMT���ټ�ȥUnix Epoch�õ��ĺ����ֵ]
 * Timestamp.valueOf()�����ַ����õ���ʱ�����JVM��ǰ��Ĭ��ʱ��Ϊ׼���統ǰĬ��ʱ��ΪGMT+8:00������2015-09-11 08:00:00����Ϊ�Ƕ�������2015-09-11 08:00:00
 * ��õ���ǰ��ʱ���������Timestamp ts = new Timestamp(new Date().getTime());
 * ��ӡTimestamp����ʵ�ʵ�����toString()���������õ�ǰJVMĬ��ʱ��
 */
public class TimestampTest {

	public static void main(String[] args) {
		testSystemProperties();
		testTimestampInterval();
		testTimestampFromString();
		testTimestampFromLong();
		testTimestampFromCurrent();
	}

	private static void testSystemProperties() {
		System.out.println("==>testSystemProperties");
		System.out.println(System.getProperty("user.timezone"));
		System.out.println(Locale.getDefault());
		System.out.println(TimeZone.getDefault());
		System.out.println();
	}
	
	private static void testTimestampInterval() {
		System.out.println("==>testSystemProperties");
		Timestamp ts = Timestamp.valueOf("1970-01-01 08:00:00");
		System.out.println("original timestamp: " + ts.getTime());
		System.out.println();
	}

	private static void testTimestampFromString() {
		System.out.println("==>testTimestampFromString");
		Timestamp ts = Timestamp.valueOf("2015-09-11 08:00:00");
		System.out.println("original timestamp: " + ts.getTime());
		System.out.println();

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

		formatter.setTimeZone(TimeZone.getTimeZone("GMT-8"));
		String formattedTime = formatter.format(ts);
		System.out.println("formatted string with GMT-8 timezone: " + formattedTime);
		System.out.println("convert to timestamp use default local timezone, then print timestamp value: " + Timestamp.valueOf(formattedTime));
		System.out.println("convert to timestamp use default local timezone, then print long value: " + Timestamp.valueOf(formattedTime).getTime());
		System.out.println();

		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		formattedTime = formatter.format(ts);
		System.out.println("formatted string with GMT timezone: " + formattedTime);
		System.out.println("convert to timestamp use default local timezone, then print timestamp value: " + Timestamp.valueOf(formattedTime));
		System.out.println("convert to timestamp use default local timezone, then print long value: " + Timestamp.valueOf(formattedTime).getTime());
		System.out.println();

		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		formattedTime = formatter.format(ts);
		System.out.println("formatted string with GMT+8 timezone: " + formattedTime);
		System.out.println("convert to timestamp use default local timezone, then print timestamp value: " + Timestamp.valueOf(formattedTime));
		System.out.println("convert to timestamp use default local timezone, then print long value: " + Timestamp.valueOf(formattedTime).getTime());
		System.out.println();

	}

	private static void testTimestampFromLong() {
		System.out.println("==>testTimestampFromLong");
		long time = 1441929600000L;
		Timestamp ts = new Timestamp(time);
		System.out.println("original timestamp: " + ts.getTime());
		System.out.println();

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

		formatter.setTimeZone(TimeZone.getTimeZone("GMT-8"));
		String formattedTime = formatter.format(ts);
		System.out.println("formatted string with GMT-8 timezone: " + formattedTime);
		System.out.println("convert to timestamp use default local timezone, then print timestamp value: " + Timestamp.valueOf(formattedTime));
		System.out.println("convert to timestamp use default local timezone, then print long value: " + Timestamp.valueOf(formattedTime).getTime());
		System.out.println();

		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		formattedTime = formatter.format(ts);
		System.out.println("formatted string with GMT timezone: " + formattedTime);
		System.out.println("convert to timestamp use default local timezone, then print timestamp value: " + Timestamp.valueOf(formattedTime));
		System.out.println("convert to timestamp use default local timezone, then print long value: " + Timestamp.valueOf(formattedTime).getTime());
		System.out.println();

		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		formattedTime = formatter.format(ts);
		System.out.println("formatted string with GMT+8 timezone: " + formattedTime);
		System.out.println("convert to timestamp use default local timezone, then print timestamp value: " + Timestamp.valueOf(formattedTime));
		System.out.println("convert to timestamp use default local timezone, then print long value: " + Timestamp.valueOf(formattedTime).getTime());
		System.out.println();

	}

	private static void testTimestampFromCurrent() {
		System.out.println("==>testTimestampFromCurrent");
		Timestamp ts = new Timestamp(new Date().getTime());
		System.out.println("original timestamp: " + ts.getTime());
		System.out.println();

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

		formatter.setTimeZone(TimeZone.getTimeZone("GMT-8"));
		String formattedTime = formatter.format(ts);
		System.out.println("formatted string with GMT-8 timezone: " + formattedTime);
		System.out.println("convert to timestamp use default local timezone, then print timestamp value: " + Timestamp.valueOf(formattedTime));
		System.out.println("convert to timestamp use default local timezone, then print long value: " + Timestamp.valueOf(formattedTime).getTime());
		System.out.println();

		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		formattedTime = formatter.format(ts);
		System.out.println("formatted string with GMT timezone: " + formattedTime);
		System.out.println("convert to timestamp use default local timezone, then print timestamp value: " + Timestamp.valueOf(formattedTime));
		System.out.println("convert to timestamp use default local timezone, then print long value: " + Timestamp.valueOf(formattedTime).getTime());
		System.out.println();

		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		formattedTime = formatter.format(ts);
		System.out.println("formatted string with GMT+8 timezone: " + formattedTime);
		System.out.println("convert to timestamp use default local timezone, then print timestamp value: " + Timestamp.valueOf(formattedTime));
		System.out.println("convert to timestamp use default local timezone, then print long value: " + Timestamp.valueOf(formattedTime).getTime());
		System.out.println();
	}

}
