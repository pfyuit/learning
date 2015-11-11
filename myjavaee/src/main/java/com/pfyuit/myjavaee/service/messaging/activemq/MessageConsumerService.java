package com.pfyuit.myjavaee.service.messaging.activemq;

import com.pfyuit.myjavaee.model.messaging.activemq.Notify;

/**
 * Message consumer service interface.
 * @author yupengfei
 */
public interface MessageConsumerService {

	public void receiveMessage(Notify notify);

}
