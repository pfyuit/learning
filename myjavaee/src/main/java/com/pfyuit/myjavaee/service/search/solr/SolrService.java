package com.pfyuit.myjavaee.service.search.solr;

import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

/**
 * Solr search service interface.
 * @author yupengfei
 */
public interface SolrService {

	public List<Integer> searchBlog(String key) throws SolrServerException;

}
