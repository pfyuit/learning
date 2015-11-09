package com.pfyuit.myjavaee.service.cache;

import net.spy.memcached.MemcachedClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation for Memcached client.
 * @author yupengfei
 */
@Service
public class MemcachedServiceImpl implements MemcachedService {

	@Autowired
	private MemcachedClient memcachedClient;

	private static final String CACHE_DATA_PREFIX = "cache_";

	@Override
	public void set(String key, String value) {
		memcachedClient.set(CACHE_DATA_PREFIX + key, 3600, value);
	}

	@Override
	public String get(String key) {
		String result = (String) memcachedClient.get(CACHE_DATA_PREFIX + key);
		return result;
	}

	@Override
	public void delete(String key) {
		memcachedClient.delete(CACHE_DATA_PREFIX + key);
	}

}
