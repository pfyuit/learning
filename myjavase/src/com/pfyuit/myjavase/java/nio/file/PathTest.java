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
		// File path: D:/temp/
		System.out.println("==>file path");
		Path file = Paths.get("D:", "temp");
		System.out.println(file);

		System.out.println("==>file ends with temp?");
		System.out.println(file.endsWith("temp"));

		System.out.println("==>file name");
		System.out.println(file.getFileName());

		System.out.println("==>file system");
		System.out.println(file.getFileSystem());
		
		System.out.println("==>file is absolute?");
		System.out.println(file.isAbsolute());
		
		System.out.println("==>file toFile");
		File ioFile = file.toFile();
		System.out.println(ioFile.getAbsolutePath());
		
		System.out.println("==>file toURI");
		URI uri = file.toUri();
		System.out.println(uri.toString());		

		// File path: D:/temp/abc.txt
		System.out.println("==>file2 path");
		Path file2 = file.resolve("abc.txt");
		System.out.println(file2);

		// File path: D:/temp/1
		System.out.println("==>file3 path");
		Path file3 = file2.resolveSibling("1");
		System.out.println(file3);

		// File path: ../1
		System.out.println("==>file4 relative path");
		Path file4 = file2.relativize(file3);
		System.out.println(file4);

		System.out.println("==>file3 name count");
		System.out.println(file3.getNameCount());

		System.out.println("==>file4 name count");
		System.out.println(file4.getNameCount());

		System.out.println(file3.getName(0));

		System.out.println("==>file3 root");
		System.out.println(file3.getRoot());

		System.out.println("==>file4 root");
		System.out.println(file4.getRoot());
	}

}
