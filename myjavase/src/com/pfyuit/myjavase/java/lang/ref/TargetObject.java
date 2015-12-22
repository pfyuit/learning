package com.pfyuit.myjavase.java.lang.ref;

/**
 * Target class of reference testing.
 * @author yupengfei
 */
public class TargetObject {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return super.toString() + "[id=" + this.id + "]";
	}

	@Override
	protected void finalize() {
		System.out.println("Object [" + this.hashCode() + "][id=" + this.id + "] come into finalize");
		try {
			super.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}