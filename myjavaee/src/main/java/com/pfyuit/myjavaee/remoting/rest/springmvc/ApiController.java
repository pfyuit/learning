package com.pfyuit.myjavaee.remoting.rest.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring MVC controller, can be used in RESTful web service design. Access
 * http://localhost:8080/myjavaee/springmvc/api/get to test.
 * @author yupengfei
 */
@Controller
@RequestMapping(value = { "/api" })
public class ApiController {

	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public String testGet() {
		logger.info("get");
		return "success";
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	@ResponseBody
	public String testPost() {
		logger.info("post");
		return "success";
	}

	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	@ResponseBody
	public String testPut() {
		logger.info("put");
		return "success";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String testDeletes() {
		logger.info("delete");
		return "success";
	}

}
