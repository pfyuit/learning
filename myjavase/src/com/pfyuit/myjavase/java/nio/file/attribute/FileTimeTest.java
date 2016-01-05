package com.pfyuit.myjavase.java.nio.file.attribute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.concurrent.TimeUnit;

import com.pfyuit.myjavase.java.nio.file.FilesTest;

/**
 * @see {@link FilesTest#testGetFileTime()}
 * @author yupengfei
 */
public class FileTimeTest {

	public static void main(String[] args) throws IOException {
		System.out.println("==>testGetLastModifiedTime");
		Path file = Paths.get("E:", "temp", "abc.txt");
		FileTime ft = Files.getLastModifiedTime(file);
		System.out.println(ft.to(TimeUnit.SECONDS));
		System.out.println(ft.toMillis());
	}

}
