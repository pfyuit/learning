package com.pfyuit.myjavaee.service.cache;

import java.util.List;

public interface RedisService {

	public void testSet(String key, String value);

	public String testGet(String key);

	public void testDelete(String key);

	public void testListInsert(String key, String value);

	public void testListDelete(String key, long index, String value);

	public List<String> testListGetAll(String key);

}
