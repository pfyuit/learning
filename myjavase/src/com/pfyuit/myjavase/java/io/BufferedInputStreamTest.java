package com.pfyuit.myjavase.java.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author Administrator
 */
public class BufferedInputStreamTest {

	private static final String TEST_FILE = "test.txt";

	public static void main(String[] args) throws IOException{
		URL url = FileTest.class.getResource(TEST_FILE);
		FileInputStream fis = new FileInputStream(new File(url.getPath()));
		
		BufferedInputStream bis = new BufferedInputStream(fis);
		System.out.println(bis.markSupported());
		System.out.println(bis.available());
		
		System.out.println((char)bis.read());
		
		byte[] buf = new byte[bis.available()];
		bis.read(buf);
		System.out.println(new String(buf,"UTF-8"));
		
		bis.close();
		fis.close();
	}

}
