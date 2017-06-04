package com.pfyuit.myjavaee.dao.search.solr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration bean for solrJ. It will read parameters from the external
 * properties file.
 * @author yupengfei
 */
@Configuration
public class SolrConfig {

	@Value("${solr.url}")
	private String url;

	@Value("${solr.soTimeout}")
	private String soTimeout;

	@Value("${solr.connectionTimeout}")
	private String connectionTimeout;

	@Value("${solr.defaultMaxConnectionsPerHost}")
	private String defaultMaxConnectionsPerHost;

	@Value("${solr.maxTotalConnections}")
	private String maxTotalConnections;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSoTimeout() {
		return soTimeout;
	}

	public void setSoTimeout(String soTimeout) {
		this.soTimeout = soTimeout;
	}

	public String getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(String connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public String getDefaultMaxConnectionsPerHost() {
		return defaultMaxConnectionsPerHost;
	}

	public void setDefaultMaxConnectionsPerHost(String defaultMaxConnectionsPerHost) {
		this.defaultMaxConnectionsPerHost = defaultMaxConnectionsPerHost;
	}

	public String getMaxTotalConnections() {
		return maxTotalConnections;
	}

	public void setMaxTotalConnections(String maxTotalConnections) {
		this.maxTotalConnections = maxTotalConnections;
	}

}
