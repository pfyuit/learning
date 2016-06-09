package com.pfyuit.myjavase.java.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author Administrator
 */
public class DataInputStreamTest {

	private static final String TEST_FILE = "test.txt";

	public static void main(String[] args) throws IOException {
		URL url = FileTest.class.getResource(TEST_FILE);
		FileInputStream fis = new FileInputStream(new File(url.getPath()));

		DataInputStream dis = new DataInputStream(fis);
		System.out.println(dis.markSupported());
		System.out.println(dis.available());

		System.out.println(dis.readChar());

		byte[] buf = new byte[dis.available()];
		dis.readFully(buf);
		System.out.println(new String(buf));

		dis.close();
		fis.close();
	}

}
