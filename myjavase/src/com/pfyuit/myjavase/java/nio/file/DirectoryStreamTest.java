package com.pfyuit.myjavase.java.nio.file;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yupengfei
 */
public class DirectoryStreamTest {

	public static void main(String[] args) throws IOException {
		testIterator();
	}

	private static void testIterator() throws IOException {
		System.out.println("==>testIterator");
		Path path = Paths.get("E:", "temp");
		DirectoryStream<Path> ds = Files.newDirectoryStream(path);
		for (Path file : ds) {
			System.out.println(file.getFileName());
		}
	}

}
