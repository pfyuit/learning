package com.pfyuit.myjavase.java.nio.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * A complicated example of Java NIO
 * @author yupengfei
 */
public class NioServerTest {

	private static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");
	private int port;
	private int bufferSize;
	private Selector selector;

	private static final int DEFAULT_BUFFER_SIZE = 1024;

	public NioServerTest(int port) {
		this(port, DEFAULT_BUFFER_SIZE);
	}

	public NioServerTest(int port, int bufferSize) {
		this.port = port;
		this.bufferSize = bufferSize;
	}

	public void start() {
		try {
			selector = Selector.open();
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);

			ServerSocket socket = ssc.socket();
			socket.bind(new InetSocketAddress(port));
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("==>Server started on port " + port);

			while (true) {
				selector.select();
				Set<SelectionKey> selectKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectKeys.iterator();
				while (it.hasNext()) {
					SelectionKey key = it.next();
					it.remove();
					dispatch(key);
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		// TODO Auto-generated method stub
	}

	public void dispatch(SelectionKey key) throws IOException, InterruptedException {
		if (key.isAcceptable()) {
			ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
			SocketChannel sc = ssc.accept();
			sc.configureBlocking(false);
			sc.register(selector, SelectionKey.OP_READ);
			System.out.println("==>Channel activated");
		} else if (key.isReadable()) {
			ByteBuffer message = ByteBuffer.allocate(bufferSize);
			SocketChannel sc = (SocketChannel) key.channel();

			int count = sc.read(message);
			if (count < 0) {
				System.out.println("==>Channel inactivated");
				key.cancel();
				sc.close();
				message.clear();
				return;
			}

			message.flip();
			System.out.println("==>Channel received message: " + CHARSET_UTF8.decode(message));
			message.clear();
		}
	}

	public static void main(String[] args) {
		NioServerTest server = new NioServerTest(8090);
		server.start();
	}
}
