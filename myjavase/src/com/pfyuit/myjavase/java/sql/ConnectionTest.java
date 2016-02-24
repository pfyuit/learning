package com.pfyuit.myjavase.java.sql;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * @author yupengfei
 */
public class ConnectionTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://mysql-server-master:3306/myblog";

		Connection con = DriverManager.getConnection(url, "root", "123456");
		System.out.println(con.getAutoCommit());
		System.out.println(con.getCatalog());
		System.out.println(con.getHoldability());
		System.out.println(con.getSchema());
		System.out.println(con.getTransactionIsolation());
		System.out.println(con.isClosed());
		System.out.println(con.isReadOnly());
		System.out.println(con.isValid(1000));

		Blob blob = con.createBlob();
		Clob clob = con.createClob();
		SQLXML sqlXML = con.createSQLXML();

		SQLWarning warnings = con.getWarnings();

		Statement statement = con.createStatement();
		PreparedStatement preparedStat = con.prepareStatement("SELECT * FROM blog");

		con.setAutoCommit(false);
		con.commit();
		con.rollback();

		Savepoint sp = con.setSavepoint("savepoint");
		con.releaseSavepoint(sp);
		
		con.clearWarnings();
		con.close();
	}

}
