package com.pfyuit.myjavase.java.lang.management;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

/**
 * ClassLoadingMXBean test
 * @author yupengfei
 */
public class ClassLoadingMXBeanTest {

	public static void main(String[] args) {
		ClassLoadingMXBean mxbean = ManagementFactory.getClassLoadingMXBean();
		System.out.println("TotalLoadedClassCount: " + mxbean.getTotalLoadedClassCount());
		System.out.println("LoadedClassCount:" + mxbean.getLoadedClassCount());
		System.out.println("UnloadedClassCount:" + mxbean.getUnloadedClassCount());
		System.out.println("isVerbose:" + mxbean.isVerbose());
	}

}
