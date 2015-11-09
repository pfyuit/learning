package com.pfyuit.myjavaee.model.search;

import org.apache.solr.client.solrj.beans.Field;

/**
 * Search model for solrJ. Use annotations to tell solrJ mapping the fields.
 * @author yupengfei
 */
public class SearchItem {

	@Field
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
