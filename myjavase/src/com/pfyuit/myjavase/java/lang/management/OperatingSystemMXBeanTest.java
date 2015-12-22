package com.pfyuit.myjavase.java.lang.management;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 * OperatingSystemMXBean test
 * @author yupengfei
 */
public class OperatingSystemMXBeanTest {

	public static void main(String[] args) {
		OperatingSystemMXBean mxbean = ManagementFactory.getOperatingSystemMXBean();
		System.out.println("Architecture: " + mxbean.getArch());
		System.out.println("Processors: " + mxbean.getAvailableProcessors());
		System.out.println("System name: " + mxbean.getName());
		System.out.println("System version: " + mxbean.getVersion());
		System.out.println("Last minute load: " + mxbean.getSystemLoadAverage());
	}

}
