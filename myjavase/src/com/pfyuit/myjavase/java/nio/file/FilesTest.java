package com.pfyuit.myjavase.java.nio.file;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.concurrent.TimeUnit;

/**
 * @author yupengfei
 */
public class FilesTest {

	public static void main(String[] args) throws IOException {
		testIsReadable();
		testIsWritable();
		testIsExecutable();
		testIsHidden();
		testIsDirectory();
		testIsRegularFile();
		testIsSymbolicLink();

		testGetAttribute();
		testGetFileAttributeView();
		testGetFileStore();
		testGetLastModifiedTime();
		testGetOwner();

		testCreateDirectories();
		testCreateDirectory();
		testCreateFile();
		testCreateLink();
		testCreateSymbolicLink();
		testCreateTempDirectory();
		testCreateTempFile();

		testDelete();
		testDeleteIfExists();

		testCopy();

		testMove();
	}

	private static void testIsReadable() {
		System.out.println("==>testIsReadable");
		Path file = Paths.get("E:", "temp", "abc.txt");
		boolean isReadable = Files.isReadable(file);
		System.out.println(isReadable);
	}

	private static void testIsWritable() {
		System.out.println("==>testIsWritable");
		Path file = Paths.get("E:", "temp", "abc.txt");
		boolean isWritable = Files.isWritable(file);
		System.out.println(isWritable);
	}

	private static void testIsExecutable() {
		System.out.println("==>testIsExecutable");
		Path file = Paths.get("E:", "temp", "abc.txt");
		boolean isExecutable = Files.isExecutable(file);
		System.out.println(isExecutable);
	}

	private static void testIsHidden() throws IOException {
		System.out.println("==>testIsHidden");
		Path file = Paths.get("E:", "temp", "abc.txt");
		boolean isHidden = Files.isHidden(file);
		System.out.println(isHidden);
	}

	private static void testIsDirectory() throws IOException {
		System.out.println("==>testIsDirectory");
		Path file = Paths.get("E:", "temp", "abc.txt");
		boolean isDirectory = Files.isDirectory(file);
		System.out.println(isDirectory);
	}

	private static void testIsRegularFile() throws IOException {
		System.out.println("==>testIsRegularFile");
		Path file = Paths.get("E:", "temp", "abc.txt");
		boolean isRegularFile = Files.isRegularFile(file);
		System.out.println(isRegularFile);
	}

	private static void testIsSymbolicLink() throws IOException {
		System.out.println("==>testIsSymbolicLink");
		Path file = Paths.get("E:", "temp", "abc.txt");
		boolean isSymbolicLink = Files.isSymbolicLink(file);
		System.out.println(isSymbolicLink);
	}

	private static void testGetAttribute() throws IOException {
		System.out.println("==>testGetAttribute");
		Path file = Paths.get("E:", "temp", "abc.txt");
		// Object attrValue = Files.getAttribute(file, "unix:uid");
		// System.out.println(attrValue);
	}

	/**
	 * @see {@link com.pfyuit.myjavase.java.nio.file.attribute.BasicFileAttributesTest#main(String[])}
	 * @see {@link com.pfyuit.myjavase.java.nio.file.attribute.FileOwnerAttributeViewTest#main(String[])}
	 * @throws IOException
	 */
	private static void testGetFileAttributeView() throws IOException {
		System.out.println("==>testGetFileAttributeView");
		Path file = Paths.get("E:", "temp", "abc.txt");

	}

	private static void testGetFileStore() throws IOException {
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

	private static void testGetLastModifiedTime() throws IOException {
		System.out.println("==>testGetLastModifiedTime");
		Path file = Paths.get("E:", "temp", "abc.txt");
		FileTime ft = Files.getLastModifiedTime(file);
		System.out.println(ft.to(TimeUnit.SECONDS));
		System.out.println(ft.toMillis());
	}

	private static void testGetOwner() throws IOException {
		System.out.println("==>testGetOwner");
		Path file = Paths.get("E:", "temp", "abc.txt");
		UserPrincipal principal = Files.getOwner(file);
		System.out.println(principal.getName());
	}

	private static void testCreateDirectories() throws IOException {
		System.out.println("==>testCreateDirectories");
		Path file = Paths.get("E:", "temp1");
		Files.createDirectories(file);
	}

	private static void testCreateDirectory() throws IOException {
		System.out.println("==>testCreateDirectory");
		Path file = Paths.get("E:", "temp2");
		Files.createDirectory(file);
	}

	private static void testCreateFile() throws IOException {
		System.out.println("==>testCreateFile");
		Path file = Paths.get("E:", "temp", "ghi.txt");
		Files.createFile(file);
	}

	private static void testCreateLink() throws IOException {
		System.out.println("==>testCreateLink");
		Path file = Paths.get("E:", "temp", "abc.lnk");
		Path file1 = Paths.get("E:", "temp", "abc.txt");
		Files.createLink(file, file1);
	}

	private static void testCreateSymbolicLink() throws IOException {
		System.out.println("==>testCreateSymbolicLink");
		Path file = Paths.get("E:", "temp", "cdf.lnk");
		Path file1 = Paths.get("E:", "temp", "cdf.txt");
		Files.createSymbolicLink(file, file1);
	}

	private static void testCreateTempDirectory() throws IOException {
		System.out.println("==>testCreateTempDirectory");
		Files.createTempDirectory("prefix_");
	}

	private static void testCreateTempFile() throws IOException {
		System.out.println("==>testCreateTempFile");
		Files.createTempFile("prefix_", "_suffix");
	}

	private static void testDelete() throws IOException {
		System.out.println("==>testDelete");
		Path file = Paths.get("E:", "temp1");
		Files.delete(file);
	}

	private static void testDeleteIfExists() throws IOException {
		System.out.println("==>testDeleteIfExists");
		Path file = Paths.get("E:", "temp2");
		Files.deleteIfExists(file);
	}

	private static void testCopy() throws IOException {
		System.out.println("==>testCopy");
		Path file = Paths.get("E:", "temp", "abc.txt");
		Path file1 = Paths.get("E:", "temp", "abc_copy.txt");
		Files.copy(file, file1);
	}

	private static void testMove() throws IOException {
		System.out.println("==>testMove");
		Path file1 = Paths.get("E:", "temp", "abc_copy.txt");
		Path file2 = Paths.get("E:", "temp", "abc_move.txt");
		Files.move(file1, file2);
	}

}
