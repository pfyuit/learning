package com.pfyuit.myjavase.java.lang.management;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * GarbageCollectorMXBean test
 * @author yupengfei
 */
public class GarbageCollectorMXBeanTest {

	public static void main(String[] args) {
		List<GarbageCollectorMXBean> mxbeans = ManagementFactory.getGarbageCollectorMXBeans();
		for (GarbageCollectorMXBean mxbean : mxbeans) {
			System.out.println("GCName:" + mxbean.getName());
			System.out.println("CollectionCount:" + mxbean.getCollectionCount());
			System.out.println("CollectionTime:" + mxbean.getCollectionTime());
		}
	}

}
