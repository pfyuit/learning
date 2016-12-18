package com.pfyuit.myjavaee.service.distribute.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ZooKeeper configuration with cluster endpoint, port and timeout.
 * @author yupengfei
 */
@Configuration
public class ZooKeeperConfig {

	@Value("${zookeeper.cluster.contact}")
	private String clusterEndpoint;

	@Value("${zookeeper.cluster.port}")
	private String clusterPort;

	@Value("${zookeeper.cluster.timeout}")
	private int clusterTimeout;

	@Bean(name = "zooKeeper")
	public ZooKeeper zooKeeper() throws IOException {
		Watcher wathcher = new ZooKeeperWatcher();
		ZooKeeper zooKeeper = new ZooKeeper(clusterEndpoint + ":" + clusterPort, clusterTimeout, wathcher);
		return zooKeeper;
	}

}
