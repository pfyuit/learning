package com.pfyuit.myjavaee.service.messaging.localvm;

import javax.jms.JMSException;
import javax.jms.Queue;

/**
 * @author yupengfei
 */
public class LocalQueue implements Queue {

	@Override
	public String getQueueName() throws JMSException {
		return "test.queue";
	}

	@Override
	public String toString() {
		return "test.queue";
	}

}
