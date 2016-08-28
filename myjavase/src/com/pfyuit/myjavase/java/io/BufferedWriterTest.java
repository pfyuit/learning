package com.pfyuit.myjavase.java.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author yupengfei
 */
public class BufferedWriterTest {

	private static final String TEST_FILE = "test.txt";

	public static void main(String[] args) throws IOException {
		File file = new File(System.getProperty("user.home") + File.separator + TEST_FILE);
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write("Hello");
		bw.write(123);
		bw.write(new char[] { 'a', 'b' });
		bw.newLine();

		bw.append('c');
		bw.append("End");

		bw.flush();
		bw.close();
		fw.close();
	}

}
