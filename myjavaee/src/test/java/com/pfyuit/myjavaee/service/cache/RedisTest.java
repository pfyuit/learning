package com.pfyuit.myjavaee.service.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class RedisTest {

	@Autowired
	private RedisService redisService;

	@Test
	public void testSet() {
		redisService.testSet("key1", "value1");
	}

	@Test
	public void testGet() {
		redisService.testGet("key1");
	}

	@Test
	public void testDelete() {
		// TODO
	}

	@Test
	public void testListInsert() {
		redisService.testListInsert("key2", "value1");
		redisService.testListInsert("key2", "value2");
	}

	@Test
	public void testListDelete() {
		redisService.testListDelete("key2", 0, "value1");
	}

	@Test
	public void testListGetAll() {
		redisService.testListGetAll("key2");
	}
}
