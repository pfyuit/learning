package com.pfyuit.myjavase.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.ParameterDescriptor;

/**
 * @author Administrator
 */
public class ParameterDescriptorTest {

	public static void main(String[] args) throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);

		System.out.println("==>ParameterDescriptor");
		MethodDescriptor[] methodDescs = beanInfo.getMethodDescriptors();
		for (MethodDescriptor methodDesc : methodDescs) {
			ParameterDescriptor[] paramDescs = methodDesc.getParameterDescriptors();
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
