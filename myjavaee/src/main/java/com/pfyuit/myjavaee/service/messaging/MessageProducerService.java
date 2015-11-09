package com.pfyuit.myjavaee.service.messaging;

import com.pfyuit.myjavaee.model.messaging.Notify;

/**
 * Message producer service interface.
 * @author yupengfei
 */
public interface MessageProducerService {

	public void sendMessage(Notify notify);

}
