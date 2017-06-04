package com.pfyuit.myjavaee.dao.database.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HConnection;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of hbase dao layer.
 * 
 * @author yupengfei
 */
@Service
public class HBaseDaoImpl implements HBaseDao {

	private static final Logger logger = LoggerFactory.getLogger(HBaseDaoImpl.class);

	@Autowired
	private HConnection conn;

	@Override
	public void put(String tableName, Put put) {
		HTableInterface table;
		try {
			table = conn.getTable(Bytes.toBytes(tableName));
			table.put(put);
			table.close();
		} catch (IOException e) {
			logger.info("put error:" + e);
		}
	}

	@Override
	public void put(String tableName, String row, String family, String qualifier, String value) throws IOException {
		HTableInterface table = conn.getTable(Bytes.toBytes(tableName));
		Put put = new Put(Bytes.toBytes(row));
		put.add(Bytes.toBytes(family), Bytes.toBytes(qualifier), Bytes.toBytes(value));
		table.put(put);
		table.close();
	}

	@Override
	public String get(String tableName, String row, String family, String qualifier) throws IOException {
		HTableInterface table = conn.getTable(Bytes.toBytes(tableName));

		Get get = new Get(Bytes.toBytes(row));
		get.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier));
		Result result = table.get(get);
		byte[] value = result.getValue(Bytes.toBytes(family), Bytes.toBytes(qualifier));

		table.close();
		return Bytes.toString(value);
	}

	@Override
	public byte[] getCellValue(String tableName, String row, String family, String qualifier) throws IOException {
		HTableInterface table = conn.getTable(Bytes.toBytes(tableName));

		Get get = new Get(Bytes.toBytes(row));
		get.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier));
		Result result = table.get(get);
		byte[] value = result.getValue(Bytes.toBytes(family), Bytes.toBytes(qualifier));

		table.close();
		return value;
	}

	@Override
	public Map<byte[], byte[]> get(String tableName, String row, String family) throws IOException {
		HTableInterface table = conn.getTable(Bytes.toBytes(tableName));
		Get get = new Get(Bytes.toBytes(row));
		Result result = table.get(get);
		Map<byte[], byte[]> map = result.getFamilyMap(Bytes.toBytes(family));
		table.close();
		return map;
	}

	@Override
	public void delete(String tableName, String row, String family, String qualifier) throws IOException {
		HTableInterface table = conn.getTable(Bytes.toBytes(tableName));

		Delete delete = new Delete(Bytes.toBytes(row));
		delete.deleteColumns(Bytes.toBytes(family), Bytes.toBytes(qualifier));
		table.delete(delete);

		table.close();
	}

	@Override
	public void scan(String tableName, String startRow, String endRow) throws IOException {
		HTableInterface table = conn.getTable(Bytes.toBytes(tableName));

		Scan scan = new Scan();
		ResultScanner scanner = table.getScanner(scan);
		for (Result result = scanner.next(); (result != null); result = scanner.next()) {
			logger.info("In scan get row: " + Bytes.toString(result.getRow()) + " size:" + result.listCells().size());
		}

		table.close();
	}

	@Override
	public List<String> scanRowKey(String tableName) throws IOException {
		List<String> rowKeys = new ArrayList<String>();
		HTableInterface table = conn.getTable(Bytes.toBytes(tableName));
		Scan scan = new Scan();
		ResultScanner scanner = table.getScanner(scan);
		for (Result result = scanner.next(); result != null; result = scanner.next()) {
			rowKeys.add(Bytes.toString(result.getRow()));
		}
		table.close();
		return rowKeys;
	}

	@Override
	public List<Result> scanRow(String tableName) throws IOException {
		List<Result> rows = new ArrayList<Result>();
		HTableInterface table = conn.getTable(Bytes.toBytes(tableName));
		Scan scan = new Scan();
		ResultScanner scanner = table.getScanner(scan);
		for (Result result = scanner.next(); result != null; result = scanner.next()) {
			rows.add(result);
		}
		table.close();
		return rows;
	}

	@Override
	public Map<String, byte[]> scanRow(String tableName, String family, String qualifier) throws IOException {
		Map<String, byte[]> rowKeys = new HashMap<String, byte[]>();
		HTableInterface table = conn.getTable(Bytes.toBytes(tableName));
		Scan scan = new Scan();
		ResultScanner scanner = table.getScanner(scan);
		for (Result result = scanner.next(); result != null; result = scanner.next()) {
			rowKeys.put(Bytes.toString(result.getRow()),
					result.getValue(Bytes.toBytes(family), Bytes.toBytes(qualifier)));
		}
		table.close();
		return rowKeys;
	}

	@Override
	public List<Result> scanRow(String tableName, String family, Map<String, byte[]> qualifierKv) throws IOException {
		List<String> rowKeys = new ArrayList<String>();
		List<Result> rows = new ArrayList<Result>();
		HTableInterface table = conn.getTable(Bytes.toBytes(tableName));
		Scan scan = new Scan();

		FilterList list = new FilterList(new Filter[0]);
		for (String qualifier : qualifierKv.keySet()) {
			byte[] value = (byte[]) qualifierKv.get(qualifier);
			Filter filter = new SingleColumnValueFilter(Bytes.toBytes(family), Bytes.toBytes(qualifier),
					CompareFilter.CompareOp.EQUAL, value);
			list.addFilter(filter);
		}
		scan.setFilter(list);

		ResultScanner scanner = table.getScanner(scan);
		for (Result result = scanner.next(); result != null; result = scanner.next()) {
			rows.add(result);
			rowKeys.add(Bytes.toString(result.getRow()));
		}
		table.close();
		return rows;
	}

	@Override
	public void createTable(String tableName, String family) throws IOException {
		org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
		HBaseAdmin admin = new HBaseAdmin(conf);

		HTableDescriptor tableDesc = new HTableDescriptor(tableName);
		tableDesc.addFamily(new HColumnDescriptor(family));
		if (!admin.tableExists(tableDesc.getTableName())) {
			admin.createTable(tableDesc);
		} else {
			logger.info("Table already exists!");
		}
		admin.close();
	}
}
