package com.pfyuit.myjavase.java.nio.file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author yupengfei
 */
public class FileVisitorTest {

	public static void main(String[] args) throws IOException {
		testVisit();
	}

	private static void testVisit() throws IOException {
		Path path = Paths.get("E:", "temp");
		Files.walkFileTree(path, new MySimpleFileVisitor());
	}
}

class MySimpleFileVisitor extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.format("preVisitDirectory %s \n", dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.format("visit file %s \n", file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		System.out.format("visitFileFailed %s \n", file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		System.out.format("postVisitDirectory %s \n", dir);
		return FileVisitResult.CONTINUE;
	}

}
