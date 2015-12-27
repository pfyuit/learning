package com.pfyuit.myjavase.java.nio.channels;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author yupengfei
 */
public class FileChannelTest {

	public static void main(String[] args) throws IOException {
		testOpen();

		testRead();
		testWrite();

		testSize();
		testTruncate();
		testForce();
		testMap();
		testLock();
		testTryLock();

		testScatter();
		testGather();

		testTransferFrom();
		testTransferTo();
	}

	public static void testOpen() throws IOException {
		System.out.println("==>testOpen");
		Path path = Paths.get("C:");
		Path file = path.resolve("testOpen.txt");

		FileChannel channel = FileChannel.open(file, StandardOpenOption.READ, StandardOpenOption.WRITE);

		ByteBuffer buf = ByteBuffer.allocate(48);
		int bytesRead = channel.read(buf);
		while (bytesRead != -1) {
			System.out.println("Read: " + bytesRead + " bytes");
			buf.flip();

			while (buf.hasRemaining()) {
				System.out.print((char) buf.get() + "");
			}
			buf.clear();
			bytesRead = channel.read(buf);
		}
		System.out.println();
	}

	public static void testRead() throws FileNotFoundException, IOException {
		System.out.println("==>testRead");
		RandomAccessFile file = new RandomAccessFile("C:\\input.txt", "rw");
		FileChannel channel = file.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(48);
		int bytesRead = channel.read(buf);
		while (bytesRead != -1) {
			System.out.println("Read: " + bytesRead + " bytes");
			buf.flip();

			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
			buf.clear();
			bytesRead = channel.read(buf);
		}
		file.close();
		System.out.println();
	}

	public static void testWrite() throws IOException {
		System.out.println("==>testWrite");
		RandomAccessFile file = new RandomAccessFile("C:\\testWrite.txt", "rw");
		FileChannel channel = file.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.putChar('a');
		buf.putChar('b');

		while (buf.hasRemaining()) {
			channel.write(buf);
		}

		channel.close();
		file.close();
		System.out.println();
	}

	public static void testSize() {
		System.out.println("==>testSize");
	}

	public static void testTruncate() {
		System.out.println("==>testTruncate");
	}

	public static void testForce() {
		System.out.println("==>testForce");
	}

	public static void testMap() {
		System.out.println("==>testMap");
	}

	public static void testLock() {
		System.out.println("==>testLock");
	}

	public static void testTryLock() {
		System.out.println("==>testTryLock");
	}

	public static void testScatter() throws IOException {
		System.out.println("==>testScatter");
		RandomAccessFile file = new RandomAccessFile("C:\\input.txt", "rw");
		FileChannel channel = file.getChannel();

		ByteBuffer header = ByteBuffer.allocate(6);
		ByteBuffer body = ByteBuffer.allocate(32);
		ByteBuffer[] bufArray = { header, body };

		channel.read(bufArray);

		for (ByteBuffer buf : bufArray) {
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
		}

		file.close();
		System.out.println();
	}

	public static void testGather() throws IOException {
		System.out.println("==>testGather");
		RandomAccessFile file = new RandomAccessFile("C:\\output.txt", "rw");
		FileChannel channel = file.getChannel();

		ByteBuffer header = ByteBuffer.allocate(6);
		ByteBuffer body = ByteBuffer.allocate(32);
		ByteBuffer[] bufArray = { header, body };
		header.putChar('a');
		body.putChar('b');

		channel.write(bufArray);

		file.close();
		System.out.println();
	}

	public static void testTransferFrom() throws IOException {
		System.out.println("==>testTransferFrom");
		RandomAccessFile file = new RandomAccessFile("C:\\input.txt", "rw");
		FileChannel channel = file.getChannel();
		RandomAccessFile file1 = new RandomAccessFile("C:\\output.txt", "rw");
		FileChannel channel1 = file.getChannel();

		long position = 0;
		long count = channel.size();

		channel1.transferFrom(channel, position, count);
		file.close();
		file1.close();
		System.out.println();
	}

	public static void testTransferTo() throws IOException {
		System.out.println("==>testTransferTo");
		RandomAccessFile file = new RandomAccessFile("C:\\input.txt", "rw");
		FileChannel channel = file.getChannel();
		RandomAccessFile file1 = new RandomAccessFile("C:\\output.txt", "rw");
		FileChannel channel1 = file.getChannel();

		long position = 0;
		long count = channel.size();

		channel1.transferTo(position, count, channel);
		file.close();
		file1.close();
		System.out.println();
	}
}
