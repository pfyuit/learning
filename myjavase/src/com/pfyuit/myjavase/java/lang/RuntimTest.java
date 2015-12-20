package com.pfyuit.myjavase.java.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Runtime class.
 * @author yupengfei
 */
public class RuntimTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Shutdown hook.
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Something before jvm shutdown");
			}
		});

		// System parameters.
		System.out.println("Avaliable processors: " + Runtime.getRuntime().availableProcessors());
		System.out.println("Max memory: " + Runtime.getRuntime().maxMemory());
		System.out.println("Total memory: " + Runtime.getRuntime().totalMemory());

		// Run external command.
		String line;
		Process process = Runtime.getRuntime().exec("cmd /c dir \\Windows");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		process.waitFor();

	}

}
