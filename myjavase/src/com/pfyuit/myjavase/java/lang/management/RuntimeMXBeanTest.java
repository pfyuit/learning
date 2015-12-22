package com.pfyuit.myjavase.java.lang.management;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * RuntimeMXBean test
 * @author yupengfei
 */
public class RuntimeMXBeanTest {

	public static void main(String[] args) {
		RuntimeMXBean mxbean = ManagementFactory.getRuntimeMXBean();
		System.out.println("jvm indeifier:" + mxbean.getName());
		String vendor = mxbean.getVmVendor();
		System.out.println("jvm vendor:" + vendor);
		System.out.println("jvm name:" + mxbean.getVmName());
		System.out.println("jvm version:" + mxbean.getVmVersion());
		System.out.println("jvm bootClassPath:" + mxbean.getBootClassPath());
		System.out.println("jvm start time:" + mxbean.getStartTime());
	}

}
