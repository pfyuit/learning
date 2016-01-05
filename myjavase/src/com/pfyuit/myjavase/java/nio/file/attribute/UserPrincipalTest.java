package com.pfyuit.myjavase.java.nio.file.attribute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;

/**
 * @author yupengfei
 */
public class UserPrincipalTest {

	public static void main(String[] args) throws IOException {
		testGetName();
	}

	private static void testGetName() throws IOException {
		System.out.println("==>testGetName");
		Path file = Paths.get("E:", "temp", "abc.txt");
		UserPrincipal principal = Files.getOwner(file);
		System.out.println(principal.getName());
	}

}
