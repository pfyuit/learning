package com.pfyuit.myjavase.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author Administrator
 */
public class BufferedReaderTest {

	private static final String TEST_FILE = "test.txt";

	public static void main(String[] args) throws IOException {
		URL url = FileTest.class.getResource(TEST_FILE);
		FileInputStream fis = new FileInputStream(new File(url.getPath()));

		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		System.out.println(br.markSupported());
		System.out.println(br.ready());

		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		br.close();
		fis.close();

	}

}
