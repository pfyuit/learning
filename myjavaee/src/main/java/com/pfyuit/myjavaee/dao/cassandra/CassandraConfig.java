package com.pfyuit.myjavaee.dao.cassandra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

/**
 * Configuration bean for Cassandra client.
 * @author yupengfei
 */
@Configuration
public class CassandraConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(CassandraConfig.class);

	/** Cassandra cluster endpoint */
	@Value("${cassandra.cluster.contact}")
	private String clusterEndpoint;

	@Bean(name = "cassandraSession")
	public Session cassandraSession() {
		Cluster cluster = Cluster.builder().addContactPoint(clusterEndpoint).build();

		Metadata metadata = cluster.getMetadata();
		LOGGER.info("Connected to cluster: {}", metadata.getClusterName());
		for (Host host : metadata.getAllHosts()) {
			LOGGER.info("Datacenter:{}, host:{}", host.getDatacenter(), host.getAddress());
		}

		Session session = cluster.connect();
		return session;
	}

}
