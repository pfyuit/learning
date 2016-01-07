package com.pfyuit.myjavaee.service.messaging.localvm;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import javax.jms.Destination;
import javax.jms.Message;

/**
 * @author yupengfei
 */
public class LocalMessageBroker {

	private static final int MESSAGE_QUEUE_CAPACITY = 1000;

	private static LocalMessageBroker instance = new LocalMessageBroker();

	private Map<Destination, BlockingQueue<Message>> messages = new ConcurrentHashMap<>();

	private LocalMessageBroker() {
	}

	public static LocalMessageBroker getInstance() {
		return instance;
	}

	public void put(Destination destination, Message message) {
		if (!messages.containsKey(destination)) {
			messages.put(destination, new ArrayBlockingQueue<Message>(MESSAGE_QUEUE_CAPACITY));
		}
		try {
			messages.get(destination).put(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Message take(Destination destination) {
		try {
			if (messages.get(destination) != null) {
				return messages.get(destination).take();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
