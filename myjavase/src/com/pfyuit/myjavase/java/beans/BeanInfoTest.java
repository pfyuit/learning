package com.pfyuit.myjavase.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

/**
 * @author yupengfei
 */
public class BeanInfoTest {

	public static void main(String[] args) throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
		beanInfo.getAdditionalBeanInfo();
		beanInfo.getBeanDescriptor();
		beanInfo.getDefaultEventIndex();
		beanInfo.getDefaultPropertyIndex();
		beanInfo.getEventSetDescriptors();
		beanInfo.getIcon(0);
		beanInfo.getMethodDescriptors();
		beanInfo.getPropertyDescriptors();
	}

}
