package com.pfyuit.myjavaee.dao.cache.couchbase;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.couchbase.client.CouchbaseClient;

/**
 * Couchbase client factory bean to initialize and destroy couchbase client.
 * 
 * @author yupengfei
 */
public class CouchbaseClientFactoryBean implements FactoryBean, InitializingBean, DisposableBean {

	private String servers;
	private String bucket;
	private String password;
	private CouchbaseClient client;

	@Override
	public Object getObject() throws Exception {
		return client;
	}

	@Override
	public Class<CouchbaseClient> getObjectType() {
		return CouchbaseClient.class;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		List<URI> list = buildServerUri();
		try {
			client = new CouchbaseClient(list, bucket, password);
		} catch (IOException e) {
		}
	}

	private List<URI> buildServerUri() {
		String[] uriArray = servers.split(",");
		List<String> uris = Arrays.asList(uriArray);
		List<URI> list = new ArrayList<URI>();
		for (String s : uris) {
			try {
				URI uri = URI.create(String.format("http://%s/pools", s));
				list.add(uri);
			} catch (Exception e) {
			}
		}
		return list;
	}

	@Override
	public void destroy() throws Exception {
		client.shutdown();
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public String getServers() {
		return servers;
	}

	public void setServers(String servers) {
		this.servers = servers;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CouchbaseClient getClient() {
		return client;
	}

	public void setClient(CouchbaseClient client) {
		this.client = client;
	}

}
