package com.pfyuit.myjavaee.service.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pfyuit.myjavaee.model.messaging.Notify;

public class MessageConsumerImpl implements MessageConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

	public void receiveMessage(Notify notify) {
		LOGGER.info("Message received: {}==>{}", notify.getNotifyId(), notify.getNotifyMsg());
	}

}
