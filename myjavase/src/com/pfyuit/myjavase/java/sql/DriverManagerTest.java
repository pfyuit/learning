package com.pfyuit.myjavase.java.sql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * @author yupengfei
 */
public class DriverManagerTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://mysql-server-master:3306/myblog";

		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			System.out.println(drivers.nextElement().toString());
		}

		Driver driver = DriverManager.getDriver(url);
		System.out.println(driver.toString());

		Connection con = DriverManager.getConnection(url, "root", "123456");
		System.out.println(con.toString());
	}

}
