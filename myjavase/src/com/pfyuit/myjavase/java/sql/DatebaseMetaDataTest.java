package com.pfyuit.myjavase.java.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author yupengfei
 */
public class DatebaseMetaDataTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://mysql-server-master:3306/myblog";

		Connection con = DriverManager.getConnection(url, "root", "123456");

		DatabaseMetaData meta = con.getMetaData();
		System.out.println(meta.allProceduresAreCallable());
		System.out.println(meta.allTablesAreSelectable());
		System.out.println(meta.autoCommitFailureClosesAllResultSets());
		System.out.println(meta.supportsBatchUpdates());
		// More operations put here.
	}

}
