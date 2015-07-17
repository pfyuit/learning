package com.pfyuit.myjavaee.model.search;

import org.apache.solr.client.solrj.beans.Field;

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
