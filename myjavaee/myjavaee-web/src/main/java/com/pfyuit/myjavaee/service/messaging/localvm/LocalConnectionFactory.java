package com.pfyuit.myjavaee.service.messaging.localvm;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;

/**
 * @author yupengfei
 */
public class LocalConnectionFactory implements ConnectionFactory, QueueConnectionFactory {

	@Override
	public Connection createConnection() throws JMSException {
		LocalConnection connection = new LocalConnection();
		return connection;
	}

	@Override
	public Connection createConnection(String userName, String password) throws JMSException {
		LocalConnection connection = new LocalConnection();
		return connection;
	}

	@Override
	public QueueConnection createQueueConnection() throws JMSException {
		LocalConnection connection = new LocalConnection();
		return connection;
	}

	@Override
	public QueueConnection createQueueConnection(String userName, String password) throws JMSException {
		LocalConnection connection = new LocalConnection();
		return connection;
	}

}
