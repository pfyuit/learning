package com.pfyuit.myjavaee.dao.messaging.activemq;

import com.pfyuit.myjavaee.model.messaging.activemq.Notify;

/**
 * Message consumer service interface.
 * @author yupengfei
 */
public interface MessageConsumerService {

	public void receiveMessage(Notify notify);

}
