package com.pfyuit.myjavase.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yupengfei
 */
public class AtomicReferenceTest {

	public static void main(String[] args) {
		AtomicReference<User> ar = new AtomicReference<User>();

		User user = new User();
		user.setName("tom");

		System.out.println(ar.getAndSet(user));

		user.setName("jerry");
		System.out.println(ar.get().getName());

	}

	public static class User {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
