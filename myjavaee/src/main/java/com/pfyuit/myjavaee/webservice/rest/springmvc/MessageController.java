package com.pfyuit.myjavaee.webservice.rest.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfyuit.myjavaee.model.messaging.Notify;
import com.pfyuit.myjavaee.service.messaging.MessageProducer;

@Controller
@RequestMapping(value = { "/messages" })
public class MessageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private MessageProducer messageProducer;

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	@ResponseBody
	public String sendMessage() {
		LOGGER.info("sendMessage");

		Notify notify = new Notify();
		notify.setNotifyId("N100001");
		notify.setNotifyMsg("This is a test message from Jms");
		messageProducer.sendMessage(notify);

		return "success";
	}

}
