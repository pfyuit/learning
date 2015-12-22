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
		// ���������������������
		TargetObject obj = new TargetObject();
		obj.setId(1);

		ReferenceQueue<TargetObject> softRefQueue = new ReferenceQueue<TargetObject>();
		SoftReference<TargetObject> softRef = new SoftReference<TargetObject>(obj, softRefQueue);

		// ��ӡ���������������
		print(softRef);

		// ���������
		obj = null;

		// ��ӡ���ö��м� get() ��������ȡ���Ķ�������
		if (softRef != null) {
			System.out.println("Soft reference run get():" + softRef.get());
			System.out.println("Check soft reference queue:" + softRefQueue.poll());
		}

		// ��ʼִ����������
		System.gc();
		System.runFinalization();

		// �����У��Ƿ��Ѿ���������У��Ƿ���ȡ�ض���
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