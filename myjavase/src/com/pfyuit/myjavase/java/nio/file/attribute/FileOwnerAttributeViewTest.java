package com.pfyuit.myjavase.java.nio.file.attribute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;

/**
 * @author yupengfei
 */
public class FileOwnerAttributeViewTest {

	public static void main(String[] args) throws IOException {
		testName();
		testGetOwner();
	}

	private static void testName() throws IOException {
		System.out.println("==>testName");
		Path file = Paths.get("E:", "temp", "abc.txt");
		FileOwnerAttributeView view = Files.getFileAttributeView(file, FileOwnerAttributeView.class);
		System.out.println(view.name());
	}

	private static void testGetOwner() throws IOException {
		System.out.println("==>testGetOwner");
		Path file = Paths.get("E:", "temp", "abc.txt");
		FileOwnerAttributeView view = Files.getFileAttributeView(file, FileOwnerAttributeView.class);
		System.out.println(view.getOwner());
	}

}
