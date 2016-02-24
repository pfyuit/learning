package com.pfyuit.myjavase.java.sql;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
 * @author yupengfei
 */
public class DriverTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://mysql-server-master:3306/myblog";

		Driver driver = DriverManager.getDriver(url);
		System.out.println(driver.getMajorVersion());
		System.out.println(driver.getMinorVersion());
		System.out.println(driver.jdbcCompliant());
		System.out.println(driver.acceptsURL(url));
	}

}
