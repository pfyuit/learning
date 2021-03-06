package com.pfyuit.myjavaee.dao.messaging.activemq;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.pfyuit.myjavaee.model.messaging.activemq.Notify;

/**
 * Message producer service implementation.
 * @author yupengfei
 */
@Service
public class MessageProducerServiceImpl implements MessageProducerService {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Destination testQueue;

	@Autowired
	private DefaultMessageConverter messageConverter;

	@Override
	public void sendMessage(Notify notify) {
		jmsTemplate.setMessageConverter(messageConverter);
		jmsTemplate.setPubSubDomain(false);
		jmsTemplate.convertAndSend(testQueue, notify);
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public Destination getNotifyQueue() {
		return testQueue;
	}

	public void setNotifyQueue(Destination notifyQueue) {
		this.testQueue = notifyQueue;
	}

	public DefaultMessageConverter getMessageConverter() {
		return messageConverter;
	}

	public void DefaultMessageConverter(DefaultMessageConverter messageConverter) {
		this.messageConverter = messageConverter;
	}
}
