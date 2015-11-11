package com.pfyuit.myjavaee.service.cache.memcached;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfyuit.myjavaee.service.cache.memcached.MemcachedService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class MemcachedTest {

	@Autowired
	private MemcachedService memcachedService;

	@Test
	public void testCheck() {
		memcachedService.check();
	}

	@Test
	public void testSet() {
		memcachedService.set("key1", "value1");
		memcachedService.set("key2", "value2");
		memcachedService.set("anexamplekey", "value2");
	}

	@Test
	public void testGet() {
		memcachedService.get("key1");
		memcachedService.get("key2");
		memcachedService.get("anexamplekey");
	}

	@Test
	public void testDelete() {
		memcachedService.delete("key1");
		memcachedService.delete("key2");
		memcachedService.delete("anexamplekey");
	}
}
