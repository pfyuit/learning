package com.pfyuit.myjavaee.model.database.mongodb;

/**
 * Task model for the MongoDb.
 * @author yupengfei
 */
public class Task {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
