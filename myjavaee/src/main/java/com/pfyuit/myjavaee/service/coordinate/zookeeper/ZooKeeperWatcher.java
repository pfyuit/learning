package com.pfyuit.myjavaee.service.coordinate.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A default ZooKeeper watcher implementation.
 * @author yupengfei
 */
public class ZooKeeperWatcher implements Watcher {

	private Logger LOGGER = LoggerFactory.getLogger(ZooKeeperWatcher.class);

	@Override
	public void process(WatchedEvent event) {
		LOGGER.info("Watcher received new notify: {}", event.toString());
	}

}
