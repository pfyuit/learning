package com.pfyuit.myjavase.java.beans;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author yupengfei
 */
public class IntrospectorTest {

	public static void main(String[] args) throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);

		System.out.println("==>BeanDescriptor");
		BeanDescriptor beanDesc = beanInfo.getBeanDescriptor();
		Class<?> clazz = beanDesc.getBeanClass();
		System.out.println(clazz.getName());

		System.out.println("==>PropertyDescriptor");
		PropertyDescriptor[] propDescs = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propDesc : propDescs) {
			Method methodR = propDesc.getReadMethod();
			if (methodR != null) {
				System.out.println(methodR.getName());
			}
			Method methodW = propDesc.getWriteMethod();
			if (methodW != null) {
				System.out.println(methodW.getName());
			}
		}

		System.out.println("==>MethodDescriptor");
		MethodDescriptor[] methodDescs = beanInfo.getMethodDescriptors();
		for (MethodDescriptor method : methodDescs) {
			System.out.println(method.getName());
		}

	}

}
