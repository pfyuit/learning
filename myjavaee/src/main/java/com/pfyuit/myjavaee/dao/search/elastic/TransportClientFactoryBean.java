package com.pfyuit.myjavaee.dao.search.elastic;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Elastic search transport client factory bean to initialize and destroy
 * transport client.
 * 
 * @author yupengfei
 */
public class TransportClientFactoryBean implements FactoryBean, InitializingBean, DisposableBean {

	private String hosts;
	private int port;
	private String cluster;
	private TransportClient client;

	@Override
	public Object getObject() throws Exception {
		return client;
	}

	@Override
	public Class<TransportClient> getObjectType() {
		return TransportClient.class;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		String[] hostArray = hosts.split(",");
		Settings settings = Settings.settingsBuilder().put("cluster.name", cluster).put("client.transport.sniff", true)
				.build();
		try {
			client = TransportClient.builder().settings(settings).build();
			for (String host : hostArray) {
				client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() throws Exception {
		client.close();
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public String getHosts() {
		return hosts;
	}

	public void setHosts(String hosts) {
		this.hosts = hosts;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public TransportClient getClient() {
		return client;
	}

	public void setClient(TransportClient client) {
		this.client = client;
	}

}
