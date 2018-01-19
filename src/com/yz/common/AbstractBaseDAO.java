package com.yz.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public abstract class AbstractBaseDAO {
	
	DataSource ds;
	
	{
		ds = new ComboPooledDataSource("myc3p0"); 
	}
	
	public Connection getConn() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public Connection getConn1() {
		Connection conn = null;
		try {
			InitialContext context = new InitialContext(); // 连接连接池
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/datasource");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
