package com.pfyuit.myjavase.java.lang.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * Phantom reference test
 * @author yupengfei
 */
public class PhantomReferenceTest {

	public static void main(String[] args) {
		TargetObject obj = new TargetObject();
		obj.setId(3);

		ReferenceQueue<TargetObject> phanRefQueue = new ReferenceQueue<TargetObject>();
		PhantomReference<TargetObject> phanRef = new PhantomReference<TargetObject>(obj, phanRefQueue);

		print(phanRef);

		obj = null;

		if (phanRef != null) {
			System.out.println("Phantom reference run get():" + phanRef.get());
			System.out.println("Check phantom reference queue:" + phanRefQueue.poll());
		}

		System.gc();
		System.runFinalization();

		if (phanRef != null) {
			System.out.println("Phantom reference run get():" + phanRef.get());
			System.out.println("Check phantom reference queue:" + phanRefQueue.poll());
		}

		// 对于虚引用对象，在经过多次 GC 之后， 才会加入到队列中去
		Reference<? extends TargetObject> mynewphan = null;
		int refCount = 1;
		while (mynewphan == null) {
			mynewphan = phanRefQueue.poll();
			System.gc();
			System.runFinalization();
			if (mynewphan != null) {
				System.out.println("Check phantom queue:" + mynewphan);
				System.out.println("Count for " + refCount + " times");
				break;
			}
			refCount++;
		}
	}

	public static void print(Reference<TargetObject> ref) {
		TargetObject obj = ref.get();
		System.out.println("The reference is " + ref.toString() + " and with object " + obj + " which is " + (obj == null ? "null" : "not null"));
	}
}
