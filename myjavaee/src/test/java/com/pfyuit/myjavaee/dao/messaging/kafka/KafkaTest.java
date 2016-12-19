package com.pfyuit.myjavaee.dao.messaging.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfyuit.myjavaee.dao.messaging.kafka.KafkaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/messaging/kafka/myjavaee-messaging-kafka-test.xml" })
public class KafkaTest {

	@Autowired
	private KafkaDao kafkaDao;

	@Test
	public void sendMessage() {
		for (int i = 0; i < 100; i++) {
			kafkaDao.sendMessage("mykey", "myvalue" + i);
		}
	}

}
