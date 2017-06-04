package com.pfyuit.myjavaee.dao.distribute.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A default ZooKeeper watcher implementation.
 * @author yupengfei
 */
public class ZooKeeperWatcher implements Watcher {

	private Logger logger = LoggerFactory.getLogger(ZooKeeperWatcher.class);

	@Override
	public void process(WatchedEvent event) {
		logger.info("Watcher received new notify: {}", event.toString());
	}

}
