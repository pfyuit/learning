package com.pfyuit.myjavaee.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfyuit.myjavaee.service.MemcachedService;

@Controller
@RequestMapping(value = { "/memcached" })
public class MemcachedController {

	@Autowired
	private MemcachedService memcachedService;

	@RequestMapping(value = "/testSet", method = RequestMethod.GET)
	@ResponseBody
	public String testSet() {
		memcachedService.testSet("key1", "value1");
		return "success";
	}

	@RequestMapping(value = "/testGet", method = RequestMethod.GET)
	@ResponseBody
	public String testGet() {
		return memcachedService.testGet("key1");
	}

	@RequestMapping(value = "/testDelete", method = RequestMethod.GET)
	@ResponseBody
	public String testDelete() {
		memcachedService.testDelete("key1");
		return "success";
	}
}
