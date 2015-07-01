package com.pfyuit.myjavaee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = { "/api" })
public class ApiController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public String testGet() {
		LOGGER.info("get");
		return "success";
	}

}
