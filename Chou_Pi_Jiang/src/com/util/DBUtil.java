package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * des:数据库连接工具类封装
 * author:三人组
 * time:2021/2/8 20:36
 * param：
 * return:
 * 
 */

public class DBUtil {
	
	public static Connection conn  = null;
	
	private static PreparedStatement st = null;
	
		static {
			try {
				Class.forName(Constant.JDBC_Driver);
				conn = DriverManager.getConnection(Constant.DBURL, Constant.DBUSER, Constant.DBPASSWORD);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			try {
				conn = DriverManager.getConnection(Constant.DBURL, Constant.DBUSER, Constant.DBPASSWORD);
				if(conn == null) {
					System.out.println("连接为空！！！");
				}
			} catch (SQLException e) {
				System.out.println("连接数据库失败！！！");
				e.printStackTrace();
			}
		}
		
		public static PreparedStatement getPreparedStatement(String sql) {
			try {
				st = conn.prepareStatement(sql);
			}catch(SQLException e) {
				System.out.println("初始化实例对象失败！！");
				e.printStackTrace();
			}
			if(st == null) {
				System.out.println("实例对象为空！！！");
			}
			return st;
		}
		
			
		
	public Connection getConnection() {
		return this.conn;
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void closeDBResource() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
