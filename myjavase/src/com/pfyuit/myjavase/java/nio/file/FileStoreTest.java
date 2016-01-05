package com.pfyuit.myjavase.java.nio.file;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yupengfei
 */
public class FileStoreTest {

	public static void main(String[] args) throws IOException {
		System.out.println("==>testGetFileStore");
		Path file = Paths.get("E:", "temp", "abc.txt");
		FileStore fs = Files.getFileStore(file);
		System.out.println(fs.getTotalSpace());
		System.out.println(fs.getUnallocatedSpace());
		System.out.println(fs.getUsableSpace());
		System.out.println(fs.isReadOnly());
		System.out.println(fs.name());
		System.out.println(fs.type());
	}

}
