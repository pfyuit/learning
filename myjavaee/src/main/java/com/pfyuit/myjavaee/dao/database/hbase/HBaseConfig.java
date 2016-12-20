package com.pfyuit.myjavaee.dao.database.hbase;

import java.io.IOException;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HConnection;
import org.apache.hadoop.hbase.client.HConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration of hbase connections.
 * 
 * @author yupengfei
 */
@Configuration
public class HBaseConfig {

	@Bean
	public HConnection hConnection() {
		org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
		HConnection conn =null;
		try {
			conn = HConnectionManager.createConnection(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
