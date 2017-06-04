package com.pfyuit.myjavaee.dao.cache.redis;

import java.util.List;

/**
 * Interface for redis dao layer.
 * @author yupengfei
 */
public interface RedisDao {

	public void stringSet(String key, String value);

	public String stringGet(String key);

	public void stringDelete(String key);

	public void listListInsert(String key, String value);

	public void listDelete(String key, long index, String value);

	public List<String> listGetAll(String key);

}
