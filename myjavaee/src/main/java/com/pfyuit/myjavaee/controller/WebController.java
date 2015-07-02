package com.pfyuit.myjavaee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pfyuit.myjavaee.dto.BlogDto;
import com.pfyuit.myjavaee.service.BlogService;

@Controller
@RequestMapping(value = { "/web" })
public class WebController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);
	
	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView testGet() {
		LOGGER.info("index");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		
		BlogDto blogDto = blogService.getBlog(10);
		mav.addObject(blogDto);
		
		return mav;
	}
}
