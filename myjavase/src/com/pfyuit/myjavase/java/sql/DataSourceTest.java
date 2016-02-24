package com.pfyuit.myjavase.java.sql;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/** 
 * @author yupengfei
 */
public class DataSourceTest {

	public static void main(String[] args) throws NamingException, SQLException {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("");
		
		Connection con = ds.getConnection("root", "123456");
	}

}
