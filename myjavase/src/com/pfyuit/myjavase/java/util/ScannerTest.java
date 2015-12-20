package com.pfyuit.myjavase.java.util;

import java.io.StringBufferInputStream;
import java.util.Scanner;

/**
 * @author yupengfei
 */
public class ScannerTest {

	public static void main(String[] args) {
		Scanner consoleScanner = new Scanner(System.in);
		System.out.println("What's your name?");
		String name = consoleScanner.nextLine();
		System.out.println("How old are you?");
		int age = consoleScanner.nextInt();
		System.out.println(name + ": " + age);
		consoleScanner.close();

		String input = "But code is a bit different (pun intended), and it¡¯s always been a little ambiguous how CC-BY-SA covers code\r\n"
				+ "This has led to uncertainty among conscientious developers as they've struggled to understand\r\n"
				+ "what (if anything) the license requires of them when grabbing a few lines of code from a post on\r\n"
				+ "Stack Exchange. Uncertainty is a drag on productivity, for you and for us,\r\n"
				+ "and we feel obligated to make code use more clear.";
		Scanner inputScanner = new Scanner(new StringBufferInputStream(input));
		while (inputScanner.hasNext()) {
			System.out.println(inputScanner.nextLine());
		}
		inputScanner.close();
	}

}
