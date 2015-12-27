package com.pfyuit.myjavase.java.nio.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yupengfei
 */
public class SelectionKeyTest {

	public static void main(String[] args) {
		try {
			Selector selector = Selector.open();
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			ServerSocket socket = serverSocketChannel.socket();
			socket.bind(new InetSocketAddress(8090));

			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("==>Server started on port 8090");

			while (true) {
				selector.select();
				Set<SelectionKey> selectKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectKeys.iterator();
				while (it.hasNext()) {
					SelectionKey key = it.next();
					it.remove();

					// SelectionKey#channel()
					Channel channel = key.channel();
					System.out.println("==>Channel: " + channel);

					// SelectionKey#selector()
					Selector sl = key.selector();
					System.out.println("==>Selector: " + sl);

					// SelectionKey#interestOps()
					int interestOps = key.interestOps();
					System.out.println("==>InterestOps: " + interestOps);

					// SelectionKey#readyOps()
					int readyOps = key.readyOps();
					System.out.println("==>ReadyOps: " + readyOps);

					// SelectionKey#isAcceptable()
					System.out.println("==>is Acceptable: " + key.isAcceptable());

					// SelectionKey#isConnectable()
					System.out.println("==>is Connectable: " + key.isConnectable());

					// SelectionKey#isReadable()
					System.out.println("==>is Readable: " + key.isReadable());

					// SelectionKey#isWritable()
					System.out.println("==>is Writable: " + key.isWritable());

					// SelectionKey#isValid()
					System.out.println("==>is Valid: " + key.isValid());

					// SelectionKey#attach(), SelectionKey#attachment()
					Object attachement = key.attachment();
					if (attachement != null) {
						System.out.println("==>Attachement: " + attachement);
					} else {
						key.attach(new String("hello"));
					}

					if (key.isAcceptable()) {
						ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
						SocketChannel sc = ssc.accept();
						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ);
						System.out.println("==>Channel activated");
					} else if (key.isReadable()) {
						ByteBuffer message = ByteBuffer.allocate(1024);
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
						System.out.println("==>Channel received message: " + Charset.forName("UTF-8").decode(message));
						message.clear();
					}

				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
