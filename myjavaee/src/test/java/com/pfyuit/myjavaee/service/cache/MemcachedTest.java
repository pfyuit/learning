package com.pfyuit.myjavaee.service.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class MemcachedTest {

	@Autowired
	private MemcachedService memcachedService;

	@Test
	public void testSet() {
		memcachedService.set("key1", "value1");
	}

	@Test
	public void testGet() {
		memcachedService.get("key1");
	}

	@Test
	public void testDelete() {
		memcachedService.delete("key1");
	}
}
