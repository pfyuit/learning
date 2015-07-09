package com.pfyuit.myjavaee.service;

import com.pfyuit.myjavaee.model.Notify;

public interface MessageConsumer {

	public void receiveMessage(Notify notify);

}
