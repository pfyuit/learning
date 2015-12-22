package com.pfyuit.myjavase.java.lang.management;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryManagerMXBean;
import java.util.List;

/**
 * MemoryManagerMXBean test
 * @author yupengfei
 */
public class MemoryManagerMXBeanTest {

	public static void main(String[] args) {
		List<MemoryManagerMXBean> mxbeans = ManagementFactory.getMemoryManagerMXBeans();
		for (MemoryManagerMXBean mxbean : mxbeans) {
			System.out.println("Name:" + mxbean.getName());
			System.out.println("isValid:" + mxbean.isValid());
			System.out.println("MemoryPoolNames:" + mxbean.getMemoryPoolNames().toString());
		}
	}

}
