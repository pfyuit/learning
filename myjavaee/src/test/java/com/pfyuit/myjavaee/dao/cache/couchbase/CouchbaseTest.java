package com.pfyuit.myjavaee.dao.cache.couchbase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/cache/couchbase/myjavaee-cache-couchbase-test.xml" })
public class CouchbaseTest {

	@Autowired
	private CouchbaseDao couchbaseDao;

	@Test
	public void testGet() {
		couchbaseDao.get("key1");
	}

	@Test
	public void testInsert() {
		couchbaseDao.insert("key1", "value1");
	}
}
