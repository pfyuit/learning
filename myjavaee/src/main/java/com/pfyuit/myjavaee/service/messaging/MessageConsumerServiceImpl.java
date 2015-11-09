package com.pfyuit.myjavaee.service.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pfyuit.myjavaee.model.messaging.Notify;

/**
 * Message consumer service implementation.
 * @author yupengfei
 */
public class MessageConsumerServiceImpl implements MessageConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumerService.class);

	public void receiveMessage(Notify notify) {
		LOGGER.info("Message received: {}==>{}", notify.getNotifyId(), notify.getNotifyMsg());
	}

}
