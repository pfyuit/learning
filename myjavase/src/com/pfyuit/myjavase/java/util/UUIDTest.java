package com.pfyuit.myjavase.java.util;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class UUIDTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		UUID uuid = UUID.randomUUID();
		String output = uuid.toString();
		System.out.println(output);
		
		uuid = UUID.fromString(output);
		System.out.println(uuid.toString());
		
		uuid = UUID.nameUUIDFromBytes(output.getBytes("UTF-8"));
		System.out.println(uuid.toString());
	}

}
