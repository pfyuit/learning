package com.pfyuit.myjavaee.service.search;

import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

public interface SolrService {

	public List<Integer> searchBlog(String key) throws SolrServerException;

}
