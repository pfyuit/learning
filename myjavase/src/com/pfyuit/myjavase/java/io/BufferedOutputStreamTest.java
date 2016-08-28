package com.pfyuit.myjavase.java.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author yupengfei
 */
public class BufferedOutputStreamTest {

	private static final String TEST_FILE = "test.txt";

	public static void main(String[] args) throws IOException {
		File file = new File(System.getProperty("user.home") + File.separator + TEST_FILE);
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		ByteBuffer buffer = ByteBuffer.allocate(100);
		for (int i = 0; i < buffer.capacity(); i++) {
			buffer.put((byte) i);
		}
		bos.write(buffer.array());
		bos.flush();
		bos.write(1);

		bos.close(); // Close will automatically flush.
		fos.close();
	}

}
