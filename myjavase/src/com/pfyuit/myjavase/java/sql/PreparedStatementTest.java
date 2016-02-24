package com.pfyuit.myjavase.java.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author yupengfei
 */
public class PreparedStatementTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://mysql-server-master:3306/myblog";

		Connection con = DriverManager.getConnection(url, "root", "123456");
		PreparedStatement statement = con.prepareStatement("SELECT * FROM blog WHERE blog_id=?");
		statement.setInt(1, 7);
		ResultSet rs = statement.executeQuery();
	}

}
