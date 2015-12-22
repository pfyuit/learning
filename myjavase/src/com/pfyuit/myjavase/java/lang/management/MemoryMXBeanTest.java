package com.pfyuit.myjavase.java.lang.management;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * MemoryMXBean test
 * @author yupengfei
 */
public class MemoryMXBeanTest {

	public static void main(String[] args) {
		MemoryMXBean mxbean = ManagementFactory.getMemoryMXBean();
		MemoryUsage heap = mxbean.getHeapMemoryUsage();
		System.out.println("Heap committed:" + heap.getCommitted() + " init:" + heap.getInit() + " max:" + heap.getMax() + " used:" + heap.getUsed());

		MemoryUsage noHeap = mxbean.getNonHeapMemoryUsage();
		System.out.println("Non-Heap committed:" + noHeap.getCommitted() + " init:" + noHeap.getInit() + " max:" + noHeap.getMax() + " used:"
				+ noHeap.getUsed());
	}

}
