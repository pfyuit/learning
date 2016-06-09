package com.pfyuit.myjavase.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author yupengfei
 */
public class FileInputStreamTest {

	private static final String TEST_FILE = "test.txt";

	public static void main(String[] args) throws IOException {
		URL url = FileTest.class.getResource(TEST_FILE);
		FileInputStream fis = new FileInputStream(new File(url.getPath()));

		System.out.println((char) fis.read());

		int len = fis.available();
		byte[] buf = new byte[len];
		fis.read(buf);
		System.out.println(new String(buf));
		fis.close();

		fis = new FileInputStream(new File(url.getPath()));
		System.out.println(fis.markSupported());
		fis.close();
	}

}
