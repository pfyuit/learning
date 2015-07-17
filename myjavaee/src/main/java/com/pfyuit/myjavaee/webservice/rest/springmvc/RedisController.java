package com.pfyuit.myjavaee.webservice.rest.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfyuit.myjavaee.service.cache.RedisService;

@Controller
@RequestMapping(value = { "/redis" })
public class RedisController {

	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/testSet", method = RequestMethod.GET)
	@ResponseBody
	public String testSet() {
		redisService.testSet("key1", "value1");
		return "success";
	}

	@RequestMapping(value = "/testGet", method = RequestMethod.GET)
	@ResponseBody
	public String testGet() {
		return redisService.testGet("key1");
	}

	@RequestMapping(value = "/testDelete", method = RequestMethod.GET)
	@ResponseBody
	public String testDelete() {
		// TODO
		return "success";
	}

	@RequestMapping(value = "/testListInsert", method = RequestMethod.GET)
	@ResponseBody
	public String testListInsert() {
		redisService.testListInsert("key2", "value1");
		redisService.testListInsert("key2", "value2");
		return "success";
	}

	@RequestMapping(value = "/testListDelete", method = RequestMethod.GET)
	@ResponseBody
	public String testListDelete() {
		redisService.testListDelete("key2", 0, "value1");
		return "success";
	}

	@RequestMapping(value = "/testListGetAll", method = RequestMethod.GET)
	@ResponseBody
	public List<String> testListGetAll() {
		return redisService.testListGetAll("key2");
	}
}
