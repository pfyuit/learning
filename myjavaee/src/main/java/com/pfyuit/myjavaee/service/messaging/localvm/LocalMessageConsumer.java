package com.pfyuit.myjavaee.service.messaging.localvm;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;

/**
 * @author yupengfei
 */
public class LocalMessageConsumer implements MessageConsumer {

	private Destination destination;

	@Override
	public String getMessageSelector() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message receive() throws JMSException {
		Message message = LocalMessageBroker.getInstance().take(destination);
		return message;
	}

	@Override
	public Message receive(long timeout) throws JMSException {
		Message message = LocalMessageBroker.getInstance().take(destination);
		return message;
	}

	@Override
	public Message receiveNoWait() throws JMSException {
		Message message = LocalMessageBroker.getInstance().take(destination);
		return message;
	}

	@Override
	public void close() throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public MessageListener getMessageListener() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMessageListener(MessageListener listener) throws JMSException {
		// TODO Auto-generated method stub
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

}
