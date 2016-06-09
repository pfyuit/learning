package com.pfyuit.myjavase.java.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;

/**
 * @author yupengfei
 */
public class FileTest {

	private static final String TEST_FILE = "test.txt";

	public static void main(String[] args) throws IOException {
		URL url = FileTest.class.getResource(TEST_FILE);
		File file = new File(url.getPath());

		System.out.println("File getAbsolutePath(): " + file.getAbsolutePath());
		System.out.println("File getCanonicalPath(): " + file.getCanonicalPath());

		System.out.println("File lastModified(): " + file.lastModified());
		System.out.println("File length(): " + file.length());

		System.out.println("File getFreeSpace(): " + file.getFreeSpace());
		System.out.println("File getTotalSpace(): " + file.getTotalSpace());
		System.out.println("File getUsableSpace(): " + file.getUsableSpace());

		System.out.println("File getName(): " + file.getName());
		System.out.println("File getParent(): " + file.getParent());

		System.out.println("File getPath(): " + file.getPath());
		System.out.println("File toURI(): " + file.toURI());

		System.out.println("File canExecute(): " + file.canExecute());
		System.out.println("File canRead(): " + file.canRead());
		System.out.println("File canWrites(): " + file.canWrite());

		System.out.println("File isFile(): " + file.isFile());
		System.out.println("File isDirectory(): " + file.isDirectory());
		System.out.println("File isHidden(): " + file.isHidden());
		System.out.println("File isAbsolute(): " + file.isAbsolute());

		file = new File("C:/testFolder");
		file.mkdir();

		file = new File("C:/Users");
		String[] fileNames = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.startsWith("Admin");
			}
		});
		if (fileNames != null) {
			for (String fileName : fileNames) {
				System.out.println("File name:" + fileName);
			}
		}

		File tempFile = File.createTempFile("temp", "bak");
		System.out.println("Temp file: " + tempFile.getCanonicalPath());
		tempFile.delete();

	}

}
