package com.miku.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {
	
	private static Connection conn  = null;
	public DBUtil() throws ClassNotFoundException{
		try {
			Class.forName(Constant.JDBC_DRIVER);
			conn = DriverManager.getConnection(Constant.URL, Constant.USERNAME, Constant.PASSWORD);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  Connection getConnection() {
		return conn;
	}
	
	public static void close(Connection conn,PreparedStatement stmt,ResultSet results) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(results!=null) {
			try {
				results.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
