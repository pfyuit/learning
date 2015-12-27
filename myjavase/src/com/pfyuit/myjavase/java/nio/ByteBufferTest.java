package com.pfyuit.myjavase.java.nio;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author yupengfei
 */
public class ByteBufferTest {

	public static void main(String[] args) {
		testAllocate();
		testWrap();
		testArray();

		testPut();
		testGet();

		testPosition();
		testLimit();
		testCapacity();

		testFlip();
		testClear();
		testCompact();
		testRewind();
		testMarkAndReset();
		testHasRemaining();
	}

	public static void testAllocate() {
		System.out.println("=>testAllocate");
		ByteBuffer buf = ByteBuffer.allocate(48);
	}

	public static void testWrap() {
		System.out.println("=>testWrap");
		ByteBuffer buf = ByteBuffer.wrap(new byte[] { 1, 2 });
	}

	public static void testArray() {
		System.out.println("=>testArray");
		ByteBuffer buf = ByteBuffer.wrap(new byte[] { 1, 2 });
		byte[] bytes = buf.array();
		System.out.println(Arrays.toString(bytes));
	}

	public static void testPut() {
		System.out.println("=>testPut");
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put((byte) 1);
		buf.put(new byte[] { 2, 3 });
		buf.putShort((short) 4);
		buf.putInt(5);
		buf.putLong(6L);
		buf.putFloat(7.1F);
		buf.putDouble(8.1);
		buf.putChar('a');
	}

	public static void testGet() {
		System.out.println("=>testGet");
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put((byte) 1);
		buf.put(new byte[] { 2, 3 });
		buf.putShort((short) 4);
		buf.putInt(5);
		buf.putLong(6L);
		buf.putFloat(7.1F);
		buf.putDouble(8.1);
		buf.putChar('a');

		buf.flip();
		byte[] dest = new byte[3];
		buf.get(dest, 0, 3);
		System.out.println(Arrays.toString(dest));
		System.out.println(buf.getShort());
		System.out.println(buf.getInt());
		System.out.println(buf.getLong());
		System.out.println(buf.getFloat());
		System.out.println(buf.getDouble());
		System.out.println(buf.getChar());
	}

	public static void testPosition() {
		System.out.println("=>testPosition");
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put((byte) 1);
		buf.put(new byte[] { 2, 3 });
		buf.putShort((short) 4);
		buf.putInt(5);
		buf.putLong(6L);
		buf.putFloat(7.1F);
		buf.putDouble(8.1);
		buf.putChar('a');

		System.out.println(buf.position());
	}

	public static void testLimit() {
		System.out.println("=>testLimit");
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put((byte) 1);
		buf.put(new byte[] { 2, 3 });
		buf.putShort((short) 4);
		buf.putInt(5);
		buf.putLong(6L);
		buf.putFloat(7.1F);
		buf.putDouble(8.1);
		buf.putChar('a');

		System.out.println(buf.limit());
	}

	public static void testCapacity() {
		System.out.println("=>testCapacity");
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put((byte) 1);
		buf.put(new byte[] { 2, 3 });
		buf.putShort((short) 4);
		buf.putInt(5);
		buf.putLong(6L);
		buf.putFloat(7.1F);
		buf.putDouble(8.1);
		buf.putChar('a');

		System.out.println(buf.capacity());
	}

	public static void testFlip() {
		System.out.println("=>testFlip");
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put((byte) 1);
		buf.put(new byte[] { 2, 3 });
		buf.putShort((short) 4);
		buf.putInt(5);
		buf.putLong(6L);
		buf.putFloat(7.1F);
		buf.putDouble(8.1);
		buf.putChar('a');
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());

		buf.flip();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
	}

	public static void testClear() {
		System.out.println("=>testClear");
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put((byte) 1);
		buf.put(new byte[] { 2, 3 });
		buf.putShort((short) 4);
		buf.putInt(5);
		buf.putLong(6L);
		buf.putFloat(7.1F);
		buf.putDouble(8.1);
		buf.putChar('a');
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());

		buf.clear();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
	}

	public static void testCompact() {
		System.out.println("=>testCompact");
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put((byte) 1);
		buf.put(new byte[] { 2, 3 });
		buf.putShort((short) 4);
		buf.putInt(5);
		buf.putLong(6L);
		buf.putFloat(7.1F);
		buf.putDouble(8.1);
		buf.putChar('a');
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());

		buf.compact();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
	}

	public static void testRewind() {
		System.out.println("=>testRewind");
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put((byte) 1);
		buf.put(new byte[] { 2, 3 });
		buf.putShort((short) 4);
		buf.putInt(5);
		buf.putLong(6L);
		buf.putFloat(7.1F);
		buf.putDouble(8.1);
		buf.putChar('a');
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());

		buf.flip();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());

		buf.get();
		buf.get();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());

		buf.rewind();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
	}

	public static void testMarkAndReset() {
		System.out.println("=>testMarkAndReset");
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put((byte) 1);
		buf.put(new byte[] { 2, 3 });
		buf.putShort((short) 4);
		buf.putInt(5);
		buf.putLong(6L);
		buf.putFloat(7.1F);
		buf.putDouble(8.1);
		buf.putChar('a');
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());

		buf.flip();
		buf.get();
		buf.get();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());

		buf.mark();
		buf.get();
		buf.get();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());

		buf.reset();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
	}

	public static void testHasRemaining() {
		System.out.println("=>testHasRemaining");
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put((byte) 1);
		buf.put(new byte[] { 2, 3 });
		buf.putShort((short) 4);
		buf.putInt(5);
		buf.putLong(6L);
		buf.putFloat(7.1F);
		buf.putDouble(8.1);
		buf.putChar('a');

		System.out.println(buf.hasRemaining());
	}

}
