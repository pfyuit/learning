package com.pfyuit.myjavaee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	private static final String CACHE_DATA_PREFIX = "cache_";

	@Override
	public void testSet(String key, String value) {
		redisTemplate.opsForValue().set(CACHE_DATA_PREFIX + key, value);
	}

	@Override
	public String testGet(String key) {
		return redisTemplate.opsForValue().get(CACHE_DATA_PREFIX + key);
	}

	@Override
	public void testDelete(String key) {
		// TODO
	}

	@Override
	public void testListInsert(String key, String value) {
		redisTemplate.opsForList().leftPush(CACHE_DATA_PREFIX + key, value);
	}

	@Override
	public void testListDelete(String key, long index, String value) {
		redisTemplate.opsForList().remove(CACHE_DATA_PREFIX + key, index, value);
	}

	@Override
	public List<String> testListGetAll(String key) {
		String redisKey = CACHE_DATA_PREFIX + key;
		long length = redisTemplate.opsForList().size(redisKey);
		List<String> messages = redisTemplate.opsForList().range(redisKey, 0, length);
		return messages;
	}
}
