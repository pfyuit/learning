package com.pfyuit.myjavaee.service.cache;

public interface MemcachedService {

	public abstract void testSet(String key, String value);

	public abstract String testGet(String key);

	public abstract void testDelete(String key);

}