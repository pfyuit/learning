package com.pfyuit.myjavaee.dao.cache.couchbase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.couchbase.client.CouchbaseClient;

/**
 * Implementation of couchbase dao layer.
 * @author yupengfei
 */
@Repository
public class CouchbaseDaoImpl implements CouchbaseDao{
	
	private static Logger logger = LoggerFactory.getLogger(CouchbaseDaoImpl.class);

	@Autowired
	private CouchbaseClient client;
	
	public Object get(String key) {
		return client.get(key);
	}

	public void insert(String key, Object value) {
		try {
			client.set(key, value);
		} catch (Exception e) {
			logger.error("Error happens while insert value to couchbase", e);
		}
	}
	
}
