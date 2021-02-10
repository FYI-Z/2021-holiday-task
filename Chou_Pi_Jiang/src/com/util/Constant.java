package com.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description:工具类封装
 * author:三人组
 * time:2021/2/8 20:36
 * param：JDBC_DRIVER,URL,USERNAME,PASSWORD
 * return:
 * 
 */

public class Constant {
	
	public static String JDBC_Driver = "com.mysql.jdbc.Driver";
	public static String DBUSER = "root";
	public static String DBPASSWORD = "123456";				//数据库db_user
	public static String DBURL = "jdbc:mysql://localhost:3306/db_user?characterEncoding=UTF-8&useSSL=false";
	public static String ContentType = "text/json;charset=utf-8";


	static public void infoController(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
