package com.pfyuit.myjavase.java.lang.management;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

/**
 * MemoryPoolMXBean test
 * @author yupengfei
 */
public class MemoryPoolMXBeanTest {

	public static void main(String[] args) {
		List<MemoryPoolMXBean> mxbeans = ManagementFactory.getMemoryPoolMXBeans();
		for (MemoryPoolMXBean mxbean : mxbeans) {
			System.out.println("Name:" + mxbean.getName());
			System.out.println("CollectionUsage:" + mxbean.getCollectionUsage());
			System.out.println("Type:" + mxbean.getType());
		}
	}

}
