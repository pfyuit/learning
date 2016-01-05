package com.pfyuit.myjavase.java.nio.file.attribute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author yupengfei
 */
public class BasicFileAttributesTest {

	public static void main(String[] args) throws IOException {
		testFileKey();
		testIsDirectory();
		testIsOther();
		testIsRegularFile();
		testIsSymbolicLink();
		testSize();
		testCreationTime();
		testLastAccessTime();
		testLastModifiedTime();
	}

	private static void testFileKey() throws IOException {
		System.out.println("==>testFileKey");
		Path file = Paths.get("E:", "temp", "abc.txt");
		BasicFileAttributeView view = Files.getFileAttributeView(file, BasicFileAttributeView.class);
		BasicFileAttributes attribute = view.readAttributes();
		System.out.println(attribute.fileKey());
	}

	private static void testIsDirectory() throws IOException {
		System.out.println("==>testIsDirectory");
		Path file = Paths.get("E:", "temp", "abc.txt");
		BasicFileAttributeView view = Files.getFileAttributeView(file, BasicFileAttributeView.class);
		BasicFileAttributes attribute = view.readAttributes();
		System.out.println(attribute.isDirectory());
	}

	private static void testIsOther() throws IOException {
		System.out.println("==>testIsOther");
		Path file = Paths.get("E:", "temp", "abc.txt");
		BasicFileAttributeView view = Files.getFileAttributeView(file, BasicFileAttributeView.class);
		BasicFileAttributes attribute = view.readAttributes();
		System.out.println(attribute.isOther());
	}

	private static void testIsRegularFile() throws IOException {
		System.out.println("==>testIsRegularFile");
		Path file = Paths.get("E:", "temp", "abc.txt");
		BasicFileAttributeView view = Files.getFileAttributeView(file, BasicFileAttributeView.class);
		BasicFileAttributes attribute = view.readAttributes();
		System.out.println(attribute.isRegularFile());
	}

	private static void testIsSymbolicLink() throws IOException {
		System.out.println("==>testIsSymbolicLink");
		Path file = Paths.get("E:", "temp", "abc.txt");
		BasicFileAttributeView view = Files.getFileAttributeView(file, BasicFileAttributeView.class);
		BasicFileAttributes attribute = view.readAttributes();
		System.out.println(attribute.isSymbolicLink());
	}

	private static void testSize() throws IOException {
		System.out.println("==>testSize");
		Path file = Paths.get("E:", "temp", "abc.txt");
		BasicFileAttributeView view = Files.getFileAttributeView(file, BasicFileAttributeView.class);
		BasicFileAttributes attribute = view.readAttributes();
		System.out.println(attribute.size());
	}

	private static void testCreationTime() throws IOException {
		System.out.println("==>testCreationTime");
		Path file = Paths.get("E:", "temp", "abc.txt");
		BasicFileAttributeView view = Files.getFileAttributeView(file, BasicFileAttributeView.class);
		BasicFileAttributes attribute = view.readAttributes();
		System.out.println(attribute.creationTime());
	}

	private static void testLastAccessTime() throws IOException {
		System.out.println("==>testLastAccessTime");
		Path file = Paths.get("E:", "temp", "abc.txt");
		BasicFileAttributeView view = Files.getFileAttributeView(file, BasicFileAttributeView.class);
		BasicFileAttributes attribute = view.readAttributes();
		System.out.println(attribute.lastAccessTime());
	}

	private static void testLastModifiedTime() throws IOException {
		System.out.println("==>testLastModifiedTime");
		Path file = Paths.get("E:", "temp", "abc.txt");
		BasicFileAttributeView view = Files.getFileAttributeView(file, BasicFileAttributeView.class);
		BasicFileAttributes attribute = view.readAttributes();
		System.out.println(attribute.lastModifiedTime());
	}

}
