package com.pfyuit.myjavase.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author yupengfei
 */
public class ServerSocketTest {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8199);
		Socket s = ss.accept();

		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();

		Scanner scanner = new Scanner(is);
		PrintWriter pw = new PrintWriter(os, true);// auto flush

		pw.println("welcome");

		boolean running = true;
		while (running && scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println(line);
			pw.println("echo: " + line);
			if (line.trim().equalsIgnoreCase("byte")) {
				running = false;
			}
		}

		scanner.close();
		pw.close();
		s.close();
		ss.close();
	}

}
