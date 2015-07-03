package com.pfyuit.myjavaee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfyuit.myjavaee.dto.BlogDto;
import com.pfyuit.myjavaee.service.BlogService;

@Controller
@RequestMapping(value = { "/api" })
public class ApiController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public String testGet() {
		LOGGER.info("get");

		BlogDto blogDto = blogService.getBlogByMyBatis(10);

		return "success";
	}

}
