package com.pfyuit.myjavase.java.beans;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

/**
 * java.beans package is mainly designed for IDE(NetBeans). But is also used by Spring or other applications.
 * BeanInfo->BeanDescriptor->PropertyDescriptor->MethodDescriptor
 * @author yupengfei
 */
public class BeanDescriptorTest {

	public static void main(String[] args) throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);

		System.out.println("==>BeanDescriptor");
		BeanDescriptor beanDesc = beanInfo.getBeanDescriptor();
		Class<?> clazz = beanDesc.getBeanClass();
		System.out.println(clazz.getName());

	}

}
