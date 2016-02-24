package com.pfyuit.myjavase.java.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** 
 * @author yupengfei
 */
public class ResultSetTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://mysql-server-master:3306/myblog";

		Connection con = DriverManager.getConnection(url, "root", "123456");
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM blog");
		
		while(rs.next()){
			System.out.println(rs.getInt("blog_id"));
		}
		
		rs.close();
		statement.close();
		con.close();
	}

}
