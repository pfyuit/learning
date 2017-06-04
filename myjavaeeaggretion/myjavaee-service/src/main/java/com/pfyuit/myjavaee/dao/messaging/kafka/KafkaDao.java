package com.pfyuit.myjavaee.dao.messaging.kafka;

/**
 * Interface of kafka dao layer.
 * 
 * @author yupengfei
 */
public interface KafkaDao {

	public void sendMessage(String msgKey, String msgValue);

}
