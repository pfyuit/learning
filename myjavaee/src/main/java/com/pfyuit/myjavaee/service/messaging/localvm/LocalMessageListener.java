package com.pfyuit.myjavaee.service.messaging.localvm;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author yupengfei
 */
public class LocalMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message == null) {
			return;
		}
		TextMessage text = (TextMessage) message;
		try {
			System.out.println("Received message: " + text.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
