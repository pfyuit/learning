package com.pfyuit.myjavase.java.lang.management;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * ThreadMXBean test
 * @author yupengfei
 */
public class ThreadMXBeanTest {

	public static void main(String[] args) {
		ThreadMXBean mxbean = ManagementFactory.getThreadMXBean();
		System.out.println("ThreadCount:" + mxbean.getThreadCount());
		System.out.println("AllThreadIds:" + mxbean.getAllThreadIds());
		System.out.println("CurrentThreadUserTime" + mxbean.getCurrentThreadUserTime());
	}

}
