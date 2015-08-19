package com.pfyuit.myjavaee.dao.cassandra;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.RegularStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;

@Service
public class UsersDaoImpl implements UsersDao {

	//@Autowired
	//@Qualifier("cassandraSession")
	private Session session;

	@Override
	public void createKeySpace() {
		session.execute("CREATE KEYSPACE IF NOT EXISTS ks1 WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};");
	}

	@Override
	public void createTable() {
		Session ks1Session = session.getCluster().connect("ks1");
		ks1Session.execute("CREATE TABLE tbl(a INT,  b INT, c INT, PRIMARY KEY(a));");
	}

	@Override
	public void save() {
		Session ks1Session = session.getCluster().connect("ks1");
		RegularStatement insert = QueryBuilder.insertInto("kp", "tbl").values(new String[] { "a", "b", "c" }, new Object[] { 1, 2, 3 });
		ks1Session.execute(insert);
	}

	@Override
	public void delete() {
		Session ks1Session = session.getCluster().connect("ks1");
		RegularStatement delete = QueryBuilder.delete().from("kp", "tbl").where(QueryBuilder.eq("a", 1));
		ks1Session.execute(delete);
	}

	@Override
	public void update() {
		Session ks1Session = session.getCluster().connect("ks1");
		RegularStatement update = QueryBuilder.update("kp", "tbl").with(QueryBuilder.set("b", 6)).where(QueryBuilder.eq("a", 3));
		ks1Session.execute(update);
	}

	@Override
	public void find() {
		Session ks1Session = session.getCluster().connect("ks1");
		RegularStatement select = QueryBuilder.select().from("kp", "tbl").where(QueryBuilder.eq("a", 3));
		ResultSet rs = ks1Session.execute(select);
		Iterator<Row> iterator = rs.iterator();
		while (iterator.hasNext()) {
			Row row = iterator.next();
			System.out.println("a=" + row.getInt("a"));
			System.out.println("b=" + row.getInt("b"));
			System.out.println("c=" + row.getInt("c"));
		}
	}

}
