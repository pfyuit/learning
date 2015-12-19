package com.pfyuit.myjavase.java.lang.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.annotation.Resource;

public class ReflectTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException,
			NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class<?> clazz = loader.loadClass("com.pfyuit.java.lang.reflect.User");
		User user = (User) clazz.newInstance();
		user.setName("pfyuit");
		user.setSex("male");

		// Test field
		{
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field.getName());
			}

			Field sexField = clazz.getDeclaredField("sex");
			String type = sexField.getType().getCanonicalName();
			String modifier = Modifier.toString(sexField.getModifiers());
			String name = sexField.getName();
			String value = (String) sexField.get(user);
			System.out.println(modifier + " " + type + " " + name + " " + value);

			Field nameField = clazz.getDeclaredField("name");
			nameField.setAccessible(true);
			nameField.set(user, "peng");
			value = (String) nameField.get(user);
			type = nameField.getType().getCanonicalName();
			modifier = Modifier.toString(nameField.getModifiers());
			name = nameField.getName();
			value = (String) nameField.get(user);
			System.out.println(modifier + " " + type + " " + name + " " + value);

			Annotation[] annotations = sexField.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation.annotationType().getName());
			}
			Resource annotation = sexField.getAnnotation(Resource.class);
			System.out.println(annotation.name() + " " + annotation.lookup());
		}

		// Test method
		{
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method.getName());
			}

			Method getNameMethod = clazz.getDeclaredMethod("getName");
			String modifier = Modifier.toString(getNameMethod.getModifiers());
			String returnType = getNameMethod.getReturnType().getCanonicalName();
			String name = getNameMethod.getName();
			Class[] paramTypes = getNameMethod.getParameterTypes();
			String types = "(";
			for (Class paramType : paramTypes) {
				types = types + "," + paramType;
			}
			types += " )";
			System.out.println(modifier + " " + returnType + " " + name + " " + types);

			String result = (String) getNameMethod.invoke(user);
			System.out.println("Invoke result: " + result);
		}

		// Test constructor
		{
			Constructor[] constructors = clazz.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				System.out.println(constructor.getName());
			}

			Constructor aConstructor = clazz.getDeclaredConstructor(String.class, String.class);
			String modifier = Modifier.toString(aConstructor.getModifiers());
			String name = aConstructor.getName();
			Class[] paramTypes = aConstructor.getParameterTypes();
			String types = "(";
			for (Class paramType : paramTypes) {
				types = types + "," + paramType;
			}
			types += " )";
			System.out.println(modifier + " " + name + " " + types);
			
			User user1 = (User)aConstructor.newInstance("name","female");
			System.out.println(user1.getName()+":"+user1.getSex());
		}

	}

}

class User {

	private String name;

	@Resource(name = "sex resource")
	public String sex;

	public User() {
	}

	public User(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
