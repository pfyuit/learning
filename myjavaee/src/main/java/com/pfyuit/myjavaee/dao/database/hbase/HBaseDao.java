package com.pfyuit.myjavaee.dao.database.hbase;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;

/**
 * Interface of hbase dao layer.
 * @author yupengfei
 *
 */
public interface HBaseDao {

	void createTable(String tableName, String family) throws IOException;

	List<Result> scanRow(String tableName, String family, Map<String, byte[]> qualifierKv) throws IOException;

	Map<String, byte[]> scanRow(String tableName, String family, String qualifier) throws IOException;

	List<Result> scanRow(String tableName) throws IOException;

	List<String> scanRowKey(String tableName) throws IOException;

	void scan(String tableName, String startRow, String endRow) throws IOException;

	void delete(String tableName, String row, String family, String qualifier) throws IOException;

	Map<byte[], byte[]> get(String tableName, String row, String family) throws IOException;

	byte[] getCellValue(String tableName, String row, String family, String qualifier) throws IOException;

	String get(String tableName, String row, String family, String qualifier) throws IOException;

	void put(String tableName, String row, String family, String qualifier, String value) throws IOException;

	void put(String tableName, Put put);

}
