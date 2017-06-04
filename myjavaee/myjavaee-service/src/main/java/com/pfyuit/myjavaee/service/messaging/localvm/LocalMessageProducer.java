package com.pfyuit.myjavaee.service.messaging.localvm;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

/**
 * @author yupengfei
 */
public class LocalMessageProducer implements MessageProducer {

	private Destination destination;

	public LocalMessageProducer(Destination destination) {
		this.destination = destination;
	}

	@Override
	public void setDisableMessageID(boolean value) throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean getDisableMessageID() throws JMSException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDisableMessageTimestamp(boolean value) throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean getDisableMessageTimestamp() throws JMSException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDeliveryMode(int deliveryMode) throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public int getDeliveryMode() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPriority(int defaultPriority) throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public int getPriority() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTimeToLive(long timeToLive) throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public long getTimeToLive() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Destination getDestination() throws JMSException {
		return this.destination;
	}

	@Override
	public void close() throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public void send(Message message) throws JMSException {
		LocalMessageBroker.getInstance().put(destination, message);
		System.out.println("Send message: " + ((TextMessage) message).getText());
	}

	@Override
	public void send(Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
		System.out.println("Send message: " + ((TextMessage) message).getText());
	}

	@Override
	public void send(Destination destination, Message message) throws JMSException {
		LocalMessageBroker.getInstance().put(destination, message);
		System.out.println("Send message: " + ((TextMessage) message).getText());
	}

	@Override
	public void send(Destination destination, Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
		LocalMessageBroker.getInstance().put(destination, message);
		System.out.println("Send message: " + ((TextMessage) message).getText());
	}

}
