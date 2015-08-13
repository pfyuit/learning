package com.pfyuit.myjavaee.service.search;

import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class SolrTest {

	@Autowired
	private SolrService solrService;

	@Test
	public void searchBlog() throws SolrServerException {
		solrService.searchBlog("mysql");
	}
}
