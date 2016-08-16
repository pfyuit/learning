package com.pfyuit.myjavase.java.lang;

/** 
 * @author yupengfei
 */
public class ClassLoaderTest {

	public static void main(String[] args) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();	
		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
		
		System.out.println(loader.toString());
		System.out.println(loader.getParent());
		System.out.println(loader.getParent().getParent());
		
		System.out.println(classLoader.getResource("StringBufferTest.java"));
		System.out.println(classLoader.getResourceAsStream("StringBufferTest.java"));

		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println(systemLoader.toString());
	}

}
