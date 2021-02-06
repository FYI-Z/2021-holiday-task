package com.miku.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {
	
	public static Connection conn  = null;
		static {
			try {
				Class.forName(Constant.JDBC_DRIVER);
				conn = DriverManager.getConnection(Constant.URL, Constant.USERNAME, Constant.PASSWORD);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	public Connection getConnection() {
		return this.conn;
	}
	
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
}
