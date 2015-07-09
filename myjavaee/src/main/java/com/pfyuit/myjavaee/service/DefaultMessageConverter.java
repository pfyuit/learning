package com.pfyuit.myjavaee.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.pfyuit.myjavaee.model.Notify;

@Component
public class DefaultMessageConverter implements MessageConverter {

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		if (object instanceof Notify) {
			ActiveMQObjectMessage msg = (ActiveMQObjectMessage) session.createObjectMessage();
			msg.setObject((Notify) object);
			return msg;
		}
		return null;
	}

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		if (message instanceof ObjectMessage) {
			ObjectMessage oMsg = (ObjectMessage) message;
			if (oMsg instanceof ActiveMQObjectMessage) {
				ActiveMQObjectMessage aMsg = (ActiveMQObjectMessage) oMsg;
				try {
					Notify noticeInfo = (Notify) aMsg.getObject();
					return noticeInfo;
				} catch (Exception e) {
					throw new JMSException("Message:" + message.toString() + "is not a instance of NoticeInfo." + message.toString());
				}
			} else {
				throw new JMSException("Message:" + message.toString() + "is not a instance of ActiveMQObjectMessage." + message.toString());
			}
		} else {
			throw new JMSException("Message:" + message.toString() + "is not a instance of ObjectMessage." + message.toString());
		}
	}

}
