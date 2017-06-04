package com.pfyuit.myjavaee.dao.messaging.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration of kafka settings.
 * 
 * @author yupengfei
 */
@Configuration
public class KafkaConfig {

	@Value("${kafka.topic.name}")
	private String topic;

	@Value("${kafka.key.serializer}")
	private String keySerializer;

	@Value("${kafka.value.serializer}")
	private String valueSerializer;

	@Value("${kafka.bootstrap.servers}")
	private String servers;

	@Bean(name = "kafkaProducer")
	public KafkaProducer<String, String> kafkaProducer() {
		Properties properties = new Properties();
		properties.put("key.serializer", keySerializer);
		properties.put("value.serializer", valueSerializer);
		properties.put("bootstrap.servers", servers);
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
		return producer;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getKeySerializer() {
		return keySerializer;
	}

	public void setKeySerializer(String keySerializer) {
		this.keySerializer = keySerializer;
	}

	public String getValueSerializer() {
		return valueSerializer;
	}

	public void setValueSerializer(String valueSerializer) {
		this.valueSerializer = valueSerializer;
	}

	public String getServers() {
		return servers;
	}

	public void setServers(String servers) {
		this.servers = servers;
	}

}
