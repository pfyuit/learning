package com.pfyuit.myjavase.java.lang.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * Soft reference test.
 * <p>
 * Note: soft/weak reference can use ReferenceQueue or not. But phantom reference must use RefernceQueue.
 * @author yupengfei
 */
public class SoftReferenceTest {

	public static void main(String[] args) {
		// 创建软引用类型所需对象
		TargetObject obj = new TargetObject();
		obj.setId(1);

		ReferenceQueue<TargetObject> softRefQueue = new ReferenceQueue<TargetObject>();
		SoftReference<TargetObject> softRef = new SoftReference<TargetObject>(obj, softRefQueue);

		// 打印正常情况对象引用
		print(softRef);

		// 将对象清空
		obj = null;

		// 打印引用队列及 get() 方法所能取到的对象自身
		if (softRef != null) {
			System.out.println("Soft reference run get():" + softRef.get());
			System.out.println("Check soft reference queue:" + softRefQueue.poll());
		}

		// 开始执行垃圾回收
		System.gc();
		System.runFinalization();

		// 检查队列，是否已经被加入队列，是否还能取回对象
		if (softRef != null) {
			System.out.println("Soft reference run get():" + softRef.get());
			System.out.println("Check soft reference queue:" + softRefQueue.poll());
		}
	}

	public static void print(Reference<TargetObject> ref) {
		TargetObject obj = ref.get();
		System.out.println("The reference is " + ref.toString() + " and with object " + obj + " which is " + (obj == null ? "null" : "not null"));
	}
}