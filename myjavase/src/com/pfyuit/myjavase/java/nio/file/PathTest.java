package com.pfyuit.myjavase.java.nio.file;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path test
 * @author yupengfei
 */
public class PathTest {

	public static void main(String[] args) {
		testToString();
		testEndsWith();
		testGetFileName();
		testGetFileSystem();
		testIsAbsolute();
		testToFile();
		testToUri();

		testResolve();
		testResolveSibling();
		testRelativize();
		testGetNameCount();
		testGetName();
		testGetRoot();
	}

	private static void testGetRoot() {
		System.out.println("==>testGetRoot");
		Path file = Paths.get("D:", "temp");
		System.out.println(file.getRoot());
	}

	private static void testGetName() {
		System.out.println("==>testGetName");
		Path file = Paths.get("D:", "temp");
		System.out.println(file.getName(0));
	}

	private static void testGetNameCount() {
		System.out.println("==>testGetNameCount");
		Path file = Paths.get("D:", "temp");
		System.out.println(file.getNameCount());
	}

	private static void testRelativize() {
		System.out.println("==>testRelativize");
		Path file = Paths.get("D:", "temp");
		Path file1 = Paths.get("D:", "temp1");
		Path file2 = file.relativize(file1);
		System.out.println(file2);
		System.out.println(file2.isAbsolute());
	}

	private static void testResolveSibling() {
		System.out.println("==>testResolveSibling");
		Path file = Paths.get("D:", "temp");
		Path file1 = file.resolveSibling("temp1");
		System.out.println(file1);
	}

	private static void testResolve() {
		System.out.println("==>testResolve");
		Path file = Paths.get("D:", "temp");
		Path file1 = file.resolve("abc.txt");
		System.out.println(file1);
	}

	private static void testToUri() {
		System.out.println("==>testToUri");
		Path file = Paths.get("D:", "temp");
		URI uri = file.toUri();
		System.out.println(uri.toString());
	}

	private static void testToFile() {
		System.out.println("==>testToFile");
		Path file = Paths.get("D:", "temp");
		File ioFile = file.toFile();
		System.out.println(ioFile.getAbsolutePath());
	}

	private static void testIsAbsolute() {
		System.out.println("==>testIsAbsolute");
		Path file = Paths.get("D:", "temp");
		System.out.println(file.isAbsolute());
	}

	private static void testGetFileSystem() {
		System.out.println("==>testGetFileSystem");
		Path file = Paths.get("D:", "temp");
		System.out.println(file.getFileSystem());
	}

	private static void testGetFileName() {
		System.out.println("==>testGetFileName");
		Path file = Paths.get("D:", "temp");
		System.out.println(file.getFileName());
	}

	private static void testEndsWith() {
		System.out.println("==>testEndsWith");
		Path file = Paths.get("D:", "temp");
		System.out.println(file.endsWith("temp"));
	}

	private static void testToString() {
		System.out.println("==>testToString");
		Path file = Paths.get("D:", "temp");
		System.out.println(file);
	}

}
