package com.pfyuit.myjavaee.dao.cache.memcached;

import java.net.SocketAddress;
import java.util.Collection;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.MemcachedNode;
import net.spy.memcached.NodeLocator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation for memcached dao layer.
 * @author yupengfei
 */
@Service
public class MemcachedDaoImpl implements MemcachedDao {

	private static Logger logger = LoggerFactory.getLogger(MemcachedDaoImpl.class);

	@Autowired
	private MemcachedClient memcachedClient;

	private static final String CACHE_DATA_PREFIX = "cache_";

	@Override
	public void check() {
		Collection<SocketAddress> servers = memcachedClient.getAvailableServers();
		for (SocketAddress server : servers) {
			logger.info("[MemcachedLogging][GetServers] " + server.toString());
		}
	}

	@Override
	public void set(String key, String value) {
		locateMemcachedNode(key);
		memcachedClient.set(CACHE_DATA_PREFIX + key, 3600, value);
	}

	@Override
	public String get(String key) {
		locateMemcachedNode(key);
		String result = (String) memcachedClient.get(CACHE_DATA_PREFIX + key);
		return result;
	}

	@Override
	public void delete(String key) {
		locateMemcachedNode(key);
		memcachedClient.delete(CACHE_DATA_PREFIX + key);
	}

	private void locateMemcachedNode(String key) {
		NodeLocator locator = memcachedClient.getNodeLocator();
		MemcachedNode node = locator.getPrimary(key);
		logger.info("[MemcachedLogging][LocateServer] " + node.toString());
	}

}
