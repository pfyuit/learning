package com.pfyuit.myjavaee.service.messaging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfyuit.myjavaee.model.messaging.Notify;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class MessageTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageTest.class);

	@Autowired
	private MessageProducer messageProducer;

	@Test
	public void sendMessage() {
		LOGGER.info("Test send message to ActiveMQ");
		Notify notify = new Notify();
		notify.setNotifyId("N100001");
		notify.setNotifyMsg("This is a test message from Jms");
		messageProducer.sendMessage(notify);
	}

}
