package com.pfyuit.myjavaee.service.messaging.localvm;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * @author yupengfei
 */
@Service
public class LocalService {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Destination testQueue;

	public void sendMessage(final String msg) {
		jmsTemplate.send(testQueue, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}

}
