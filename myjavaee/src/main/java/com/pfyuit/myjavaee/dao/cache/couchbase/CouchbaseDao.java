package com.pfyuit.myjavaee.dao.cache.couchbase;

/**
 * Inteface of couchbase dao layer.
 * @author yupengfei
 */
public interface CouchbaseDao {
	
	public Object get(String key);
	
	public void insert(String key, Object value);

}
