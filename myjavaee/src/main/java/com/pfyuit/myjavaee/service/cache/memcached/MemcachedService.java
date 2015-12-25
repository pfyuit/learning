package com.pfyuit.myjavaee.service.cache.memcached;

/**
 * Interface for Memcached client.
 * @author yupengfei
 */
public interface MemcachedService {

	public void check();

	public void set(String key, String value);

	public String get(String key);

	public void delete(String key);

}