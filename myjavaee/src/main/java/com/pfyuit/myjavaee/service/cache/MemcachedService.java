package com.pfyuit.myjavaee.service.cache;

/**
 * Interface for Memcached client.
 * @author yupengfei
 */
public interface MemcachedService {
	
	public abstract void check();

	public abstract void set(String key, String value);

	public abstract String get(String key);

	public abstract void delete(String key);

}