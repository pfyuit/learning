package com.pfyuit.myjavaee.util;

import java.lang.reflect.Field;

/**
 * @author yupengfei
 */
public class BeanUtil {

	public static <T> void printModel(T model) {
		Field[] fields = model.getClass().getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				sb.append(field.get(model)).append("::");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sb.toString());
	}

}
