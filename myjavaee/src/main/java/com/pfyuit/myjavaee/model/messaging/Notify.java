package com.pfyuit.myjavaee.model.messaging;

import java.io.Serializable;

public class Notify implements Serializable {

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
