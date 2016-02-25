package com.pfyuit.myjavase.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author yupengfei
 */
public class SocketTest {

	public static void main(String[] args) {
		testCreateSocket();
		testCreateSocket1();

	}

	private static void testCreateSocket() {
		System.out.println("==>testCreateSocket");
		Socket socket = null;
		try {
			socket = new Socket("nginx.org", 80);
			socket.setSoTimeout(3000);
			
			System.out.println(socket.getKeepAlive());
			System.out.println(socket.getLocalPort());
			System.out.println(socket.getOOBInline());
			System.out.println(socket.getPort());
			System.out.println(socket.getReceiveBufferSize());
			System.out.println(socket.getReuseAddress());
			System.out.println(socket.getSoTimeout());
			System.out.println(socket.getTcpNoDelay());
			System.out.println(socket.isBound());
			System.out.println(socket.isClosed());
			System.out.println(socket.isConnected());
			System.out.println(socket.isInputShutdown());
			System.out.println(socket.isOutputShutdown());
			System.out.println(socket.getInetAddress());

			InputStream is = socket.getInputStream();
			Scanner scanner = new Scanner(is);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
			}

			scanner.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void testCreateSocket1() {
		System.out.println("==>testCreateSocket1");
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress("nginx.org", 80), 3000);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
