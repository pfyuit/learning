package com.pfyuit.myjavase.java.nio.file;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Paths test
 * @author yupengfei
 */
public class PathsTest {

	public static void main(String[] args) throws URISyntaxException {
		testGet();
	}

	private static void testGet() throws URISyntaxException {
		System.out.println("==>testGet");
		Path file = Paths.get("D:", "temp");
		System.out.println(file);

		file = Paths.get(new URI("file:///D:/temp"));
		System.out.println(file);
	}

}
