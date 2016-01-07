package com.pfyuit.myjavaee.service.messaging.localvm;

import javax.jms.Connection;
import javax.jms.ConnectionConsumer;
import javax.jms.ConnectionMetaData;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.ServerSessionPool;
import javax.jms.Session;
import javax.jms.Topic;

/**
 * @author yupengfei
 */
public class LocalConnection implements Connection, QueueConnection {

	@Override
	public Session createSession(boolean transacted, int acknowledgeMode) throws JMSException {
		LocalSession session = new LocalSession();
		return session;
	}

	@Override
	public String getClientID() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setClientID(String clientID) throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public ConnectionMetaData getMetaData() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExceptionListener getExceptionListener() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setExceptionListener(ExceptionListener listener) throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public void start() throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public void stop() throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public void close() throws JMSException {
		// TODO Auto-generated method stub
	}

	@Override
	public ConnectionConsumer createConnectionConsumer(Destination destination, String messageSelector, ServerSessionPool sessionPool, int maxMessages)
			throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionConsumer createDurableConnectionConsumer(Topic topic, String subscriptionName, String messageSelector,
			ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueueSession createQueueSession(boolean transacted, int acknowledgeMode) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionConsumer createConnectionConsumer(Queue queue, String messageSelector, ServerSessionPool sessionPool, int maxMessages)
			throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

}
