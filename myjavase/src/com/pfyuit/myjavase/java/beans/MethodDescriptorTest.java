package com.pfyuit.myjavase.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.ParameterDescriptor;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class MethodDescriptorTest {

	public static void main(String[] args) throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);

		System.out.println("==>MethodDescriptor");
		MethodDescriptor[] methodDescs = beanInfo.getMethodDescriptors();
		for (MethodDescriptor method : methodDescs) {
			System.out.println(method.getName());
			System.out.println(method.getDisplayName());
			System.out.println(method.getShortDescription());
			System.out.println(method.getValue("getName"));

			System.out.println("==>MethodDescriptor/ReflectionMethod");
			Method reflectMethod = method.getMethod();
			System.out.println(reflectMethod.getName());

			System.out.println("==>MethodDescriptor/ParameterDescriptor");
			ParameterDescriptor[] paramDescs = method.getParameterDescriptors();
			if (paramDescs != null) {
				for (ParameterDescriptor paramDesc : paramDescs) {
					System.out.println(paramDesc.getName());
					System.out.println(paramDesc.getDisplayName());
					System.out.println(paramDesc.getShortDescription());
					System.out.println(paramDesc.getValue("name"));
				}
			}

		}
	}

}
