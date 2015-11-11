package com.pfyuit.myjavaee.service.cache.redis;

import java.util.List;

/**
 * Interface for Redis client.
 * @author yupengfei
 */
public interface RedisService {

	public void stringSet(String key, String value);

	public String stringGet(String key);

	public void stringDelete(String key);

	public void listListInsert(String key, String value);

	public void listDelete(String key, long index, String value);

	public List<String> listGetAll(String key);

}
