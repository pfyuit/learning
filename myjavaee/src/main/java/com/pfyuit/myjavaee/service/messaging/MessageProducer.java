package com.pfyuit.myjavaee.service.messaging;

import com.pfyuit.myjavaee.model.messaging.Notify;

public interface MessageProducer {

	public void sendMessage(Notify notify);

}
