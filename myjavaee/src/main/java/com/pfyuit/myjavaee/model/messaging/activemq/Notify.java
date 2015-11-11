package com.pfyuit.myjavaee.model.messaging.activemq;

import java.io.Serializable;

/**
 * Notify model for ActiveMQ. Must implements java.io.Serializable to make it
 * serializable and deserializable.
 * @author yupengfei
 */
public class Notify implements Serializable {

	/**
	 * Need explicitly specify a seraiVersionUID to avoid the
	 * InvalidCastException exception
	 */
	private static final long serialVersionUID = 6600872732821628135L;

	private String notifyId;
	private String notifyMsg;

	public String getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}

	public String getNotifyMsg() {
		return notifyMsg;
	}

	public void setNotifyMsg(String notifyMsg) {
		this.notifyMsg = notifyMsg;
	}

}
