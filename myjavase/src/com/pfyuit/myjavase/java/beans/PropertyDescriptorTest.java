package com.pfyuit.myjavase.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author yupengfei
 */
public class PropertyDescriptorTest {

	public static void main(String[] args) throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);

		System.out.println("==>PropertyDescriptor");
		PropertyDescriptor[] propDescs = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propDesc : propDescs) {
			System.out.println(propDesc.getDisplayName());
			System.out.println(propDesc.getName());
			System.out.println(propDesc.getShortDescription());
			System.out.println(propDesc.getValue("name"));
			System.out.println(propDesc.getPropertyEditorClass().getCanonicalName());
			System.out.println(propDesc.getPropertyType().getCanonicalName());

			Method methodR = propDesc.getReadMethod();
			if (methodR != null) {
				System.out.println(methodR.getName());
			}
			Method methodW = propDesc.getWriteMethod();
			if (methodW != null) {
				System.out.println(methodW.getName());
			}
		}
	}

}
