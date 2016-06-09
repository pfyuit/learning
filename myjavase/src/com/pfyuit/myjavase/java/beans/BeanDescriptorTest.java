package com.pfyuit.myjavase.java.beans;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Enumeration;

/**
 * java.beans package is mainly designed for IDE(NetBeans). But is also used by Spring or other applications.
 * BeanInfo->BeanDescriptor->PropertyDescriptor->MethodDescriptor->ParameterDescriptor
 * @author yupengfei
 */
public class BeanDescriptorTest {

	public static void main(String[] args) throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);

		System.out.println("==>BeanDescriptor getBeanClass()");
		BeanDescriptor beanDesc = beanInfo.getBeanDescriptor();
		Class<?> clazz = beanDesc.getBeanClass();
		System.out.println(clazz.getName());

		System.out.println("==>BeanDescriptor getDisplayName()");
		System.out.println(beanDesc.getDisplayName());

		System.out.println("==>BeanDescriptor getName()");
		System.out.println(beanDesc.getName());

		System.out.println("==>BeanDescriptor getShortDescription()");
		System.out.println(beanDesc.getShortDescription());

		System.out.println("==>BeanDescriptor getValue()");
		System.out.println(beanDesc.getValue("name"));

		System.out.println("==>BeanDescriptor attributeNames()");
		Enumeration<String> attrNames = beanDesc.attributeNames();
		while (attrNames.hasMoreElements()) {
			System.out.println(attrNames.nextElement());
		}
	}

}
