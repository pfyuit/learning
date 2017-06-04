package com.pfyuit.myjavaee.dao.messaging.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Kafka dao layer to send and consume message.
 * 
 * @author yupengfei
 */
@Service
public class KafkaDaoImpl implements KafkaDao {

	@Autowired
	private KafkaConfig config;

	@Autowired
	private KafkaProducer<String, String> kafkaProducer;

	@Override
	public void sendMessage(String msgKey, String msgValue) {
		ProducerRecord<String, String> kafkaRecord = new ProducerRecord<String, String>(config.getTopic(), msgKey,
				msgValue);
		kafkaProducer.send(kafkaRecord);
	}

}
