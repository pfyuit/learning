package com.pfyuit.myjavaee.dao.cache.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfyuit.myjavaee.dao.cache.redis.RedisDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/cache/redis/myjavaee-cache-redis-test.xml" })
public class RedisTest {

	@Autowired
	private RedisDao redisService;

	@Test
	public void testSet() {
		redisService.stringSet("key1", "value1");
	}

	@Test
	public void testGet() {
		redisService.stringGet("key1");
	}

	@Test
	public void testDelete() {
		// TODO
	}

	@Test
	public void testListInsert() {
		redisService.listListInsert("key2", "value1");
		redisService.listListInsert("key2", "value2");
	}

	@Test
	public void testListDelete() {
		redisService.listDelete("key2", 0, "value1");
	}

	@Test
	public void testListGetAll() {
		redisService.listGetAll("key2");
	}
}
