package com.pfyuit.myjavaee.service.search.solr;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/search/solr/myjavaee-search-solr-test.xml" })
public class SolrTest {

	@Autowired
	private SolrService solrService;

	@Test
	public void searchBlog() throws SolrServerException, IOException {
		List<Integer> blogIds = solrService.searchBlog("mysql");
		assertNotNull(blogIds);
	}
}
