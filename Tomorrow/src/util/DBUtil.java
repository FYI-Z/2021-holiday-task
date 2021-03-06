package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * 
 * description: 数据库连接工具类封装
 * author: 三人小组
 * time: 2021.02.26
 * the name of the class: DBUtil
 * */

public class DBUtil {
	public static Connection conn  = null;
	public static PreparedStatement st = null;
	static {
		try {
			Class.forName(Constant.JDBC_Driver);
			conn = DriverManager.getConnection(Constant.DBURL, Constant.DBUSER, Constant.DBPASSWORD);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static PreparedStatement getPreparedStatement(String sql) {
		try {
			st = conn.prepareStatement(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return st;
	}
}
