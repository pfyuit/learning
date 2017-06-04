package com.pfyuit.myjavaee.dao.database.hbase;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/hbase/myjavaee-database-hbase-test.xml" })
public class HBaseDaoTest {

	@Autowired
	private HBaseDao hbaseDao;

	@Test
	public void test() throws IOException {
		hbaseDao.put("test", "1", "d", "name", "tom");
		hbaseDao.put("test", "2", "d", "age", "20");
		System.out.println(hbaseDao.get("test", "1", "d", "name"));
	}

}
