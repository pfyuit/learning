package com.pfyuit.myjavaee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pfyuit.myjavaee.model.Notify;

public class MessageConsumerImpl implements MessageConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

	public void receiveMessage(Notify notify) {
		LOGGER.info("Message received: {}==>{}", notify.getNotifyId(), notify.getNotifyMsg());
	}

}
