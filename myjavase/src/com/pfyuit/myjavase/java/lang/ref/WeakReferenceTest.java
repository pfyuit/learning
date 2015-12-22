package com.pfyuit.myjavase.java.lang.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Weak reference test
 * @author yupengfei
 */
public class WeakReferenceTest {

	public static void main(String[] args) {
		TargetObject obj = new TargetObject();
		obj.setId(2);

		ReferenceQueue<TargetObject> weakRefQueue = new ReferenceQueue<TargetObject>();
		WeakReference<TargetObject> weakRef = new WeakReference<TargetObject>(obj, weakRefQueue);

		print(weakRef);

		obj = null;

		if (weakRef != null) {
			System.out.println("Weak reference run get():" + weakRef.get());
			System.out.println("Check weak reference queue:" + weakRefQueue.poll());
		}

		System.gc();
		System.runFinalization();

		if (weakRef != null) {
			System.out.println("Weak reference run get():" + weakRef.get());
			System.out.println("Check weak reference queue:" + weakRefQueue.poll());
		}
	}

	public static void print(Reference<TargetObject> ref) {
		TargetObject obj = ref.get();
		System.out.println("The reference is " + ref.toString() + " and with object " + obj + " which is " + (obj == null ? "null" : "not null"));
	}

}
