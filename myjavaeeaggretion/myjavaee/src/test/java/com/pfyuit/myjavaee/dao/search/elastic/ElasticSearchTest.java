package com.pfyuit.myjavaee.dao.search.elastic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfyuit.myjavaee.model.search.elastic.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/search/elastic/myjavaee-search-elastic-test.xml" })
public class ElasticSearchTest {

	@Autowired
	private ElasticSearchDao searchDao;

	@Test
	public void testIndexUser() {
		User model = new User();
		model.setUserId("10001");
		model.setUserName("Andrew");
		model.setUserFavorite("Aireplane");
		searchDao.indexUser("10001", model);
	}

	@Test
	public void testUpsertUser() {
		User model = new User();
		model.setUserId("10001");
		model.setUserName("Andrew");
		model.setUserFavorite("Software");
		searchDao.upsertUser("10001", model);
	}
}
