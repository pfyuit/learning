package com.pfyuit.myjavaee.service;

import com.pfyuit.myjavaee.model.Notify;

public interface MessageProducer {

	public void sendMessage(Notify notify);

}
