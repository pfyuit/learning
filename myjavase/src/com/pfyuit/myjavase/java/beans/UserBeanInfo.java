package com.pfyuit.myjavase.java.beans;

import java.awt.Image;
import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * @author yupengfei
 */
public class UserBeanInfo extends SimpleBeanInfo {

	@Override
	public BeanDescriptor getBeanDescriptor() {
		// TODO Auto-generated method stub
		return super.getBeanDescriptor();
	}

	@Override
	public PropertyDescriptor[] getPropertyDescriptors() {
		PropertyDescriptor namePropertyDescriptor = null;
		try {
			namePropertyDescriptor = new PropertyDescriptor("name", User.class);
		} catch (IntrospectionException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
		namePropertyDescriptor.setPropertyEditorClass(UserNamePropertyEditor.class);
		return new PropertyDescriptor[] { namePropertyDescriptor };
	}

	@Override
	public int getDefaultPropertyIndex() {
		// TODO Auto-generated method stub
		return super.getDefaultPropertyIndex();
	}

	@Override
	public EventSetDescriptor[] getEventSetDescriptors() {
		// TODO Auto-generated method stub
		return super.getEventSetDescriptors();
	}

	@Override
	public int getDefaultEventIndex() {
		// TODO Auto-generated method stub
		return super.getDefaultEventIndex();
	}

	@Override
	public MethodDescriptor[] getMethodDescriptors() {
		// TODO Auto-generated method stub
		return super.getMethodDescriptors();
	}

	@Override
	public BeanInfo[] getAdditionalBeanInfo() {
		// TODO Auto-generated method stub
		return super.getAdditionalBeanInfo();
	}

	@Override
	public Image getIcon(int iconKind) {
		// TODO Auto-generated method stub
		return super.getIcon(iconKind);
	}

	@Override
	public Image loadImage(String resourceName) {
		// TODO Auto-generated method stub
		return super.loadImage(resourceName);
	}

}