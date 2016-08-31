package com.pfyuit.myjavase.java.util;

import java.util.Calendar;

/** 
* @author yupengfei
*/
public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
	}

}
