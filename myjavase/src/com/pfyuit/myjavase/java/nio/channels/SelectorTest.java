package com.pfyuit.myjavase.java.nio.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yupengfei
 */
public class SelectorTest {

	public static void main(String[] args) {
		try {
			// Selector#open()
			Selector selector = Selector.open();
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);
			ServerSocket socket = ssc.socket();
			socket.bind(new InetSocketAddress(8090));

			ssc.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("==>Server started on port 8090");

			// Selector#isOpen()
			System.out.println("==>Selector is open: " + selector.isOpen());

			// Selector#keys()
			Set<SelectionKey> keys = selector.keys();
			for (SelectionKey key : keys) {
				System.out.println("==>Key: " + key.toString());
			}

			while (true) {
				// Selector#select()
				selector.select();

				// Selector#selectedKeys()
				Set<SelectionKey> selectKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectKeys.iterator();
				while (it.hasNext()) {
					SelectionKey key = it.next();
					it.remove();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
