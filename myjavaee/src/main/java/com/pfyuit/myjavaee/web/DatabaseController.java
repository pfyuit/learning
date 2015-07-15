package com.pfyuit.myjavaee.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfyuit.myjavaee.model.Apply;
import com.pfyuit.myjavaee.model.BlogModel;
import com.pfyuit.myjavaee.service.ApplyService;
import com.pfyuit.myjavaee.service.BlogService;

@Controller
@RequestMapping(value = { "/databases" })
public class DatabaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseController.class);

	@Autowired
	private BlogService blogService;

	@Autowired
	private ApplyService applyService;

	@RequestMapping(value = "/testSingleDataSouce", method = RequestMethod.GET)
	@ResponseBody
	public String testSingleDataSource() {
		LOGGER.info("testSingleDataSource");

		// Insert

		// Delete

		// Update

		// Select
		BlogModel model = blogService.findById(3);

		return "success";
	}

	@RequestMapping(value = "/testMultiDataSouce", method = RequestMethod.GET)
	@ResponseBody
	public String testMultiDataSource() {
		LOGGER.info("testMultiDataSouce");

		// Insert

		// Delete

		// Update

		// Select
		BlogModel model = blogService.findById(3);
		Apply apply = applyService.findById(36);

		return "success";
	}

}
