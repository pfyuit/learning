package com.pfyuit.myjavaee.service.messaging;

import com.pfyuit.myjavaee.model.messaging.Notify;

public interface MessageConsumer {

	public void receiveMessage(Notify notify);

}
