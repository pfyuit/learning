package com.pfyuit.myjavaee.dao.cache.memcached;

/**
 * Interface for memcached dao layer.
 * @author yupengfei
 */
public interface MemcachedDao {

	public void check();

	public void set(String key, String value);

	public String get(String key);

	public void delete(String key);

}