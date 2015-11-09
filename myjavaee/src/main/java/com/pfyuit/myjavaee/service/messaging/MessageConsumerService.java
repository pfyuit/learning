package com.pfyuit.myjavaee.service.messaging;

import com.pfyuit.myjavaee.model.messaging.Notify;

/**
 * Message consumer service interface.
 * @author yupengfei
 */
public interface MessageConsumerService {

	public void receiveMessage(Notify notify);

}
