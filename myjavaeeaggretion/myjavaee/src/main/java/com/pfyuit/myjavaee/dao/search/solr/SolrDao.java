package com.pfyuit.myjavaee.dao.search.solr;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

/**
 * Solr search dao interface.
 * @author yupengfei
 */
public interface SolrDao {

	public List<Integer> searchBlog(String key) throws SolrServerException, IOException;

}
