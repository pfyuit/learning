package com.pfyuit.myjavase.java.security;

/** 
 * @author yupengfei
 */
public class SecurityManagerTest {

	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		System.out.println(securityManager.getClass());
	}

}
