package com.pfyuit.myjavase.java.io;

import java.io.Console;

/**
 * Operations for java.io.Console
 * @author yupengfei
 */
public class ConsoleTest {

	public static void main(String[] args) {
		Console console = System.console();
		String username = console.readLine();
		char[] password = console.readPassword();
		System.out.println(username + ": " + new String(password));
	}

}
