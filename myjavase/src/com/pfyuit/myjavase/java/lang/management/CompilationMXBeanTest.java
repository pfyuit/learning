package com.pfyuit.myjavase.java.lang.management;

import java.lang.management.CompilationMXBean;
import java.lang.management.ManagementFactory;

/**
 * CompilationMXBean test
 * @author yupengfei
 */
public class CompilationMXBeanTest {

	public static void main(String[] args) {
		CompilationMXBean com = ManagementFactory.getCompilationMXBean();
		// Return the name of Just-in-time (JIT) compiler.
		System.out.println("name:" + com.getName());

		// Returns the approximate accumlated elapsed time (in milliseconds) spent in compilation.
		System.out.println("TotalCompilationTime:" + com.getTotalCompilationTime());

		System.out.println("isCompilationTimeMonitoringSupported:" + com.isCompilationTimeMonitoringSupported());
	}

}
