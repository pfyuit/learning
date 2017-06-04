package com.pfyuit.myjavaee.service.messaging.localvm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/messaging/localvm/myjavaee-messaging-localvm-test.xml" })
public class MessageTest {

	private static final Logger logger = LoggerFactory.getLogger(MessageTest.class);

	@Autowired
	private LocalService localService;

	@Test
	public void sendMessage() {
		logger.info("Test send message to LocalVM");
		for (int i = 0; i <= 100; i++) {
			localService.sendMessage("hello world");
		}
	}

}
