package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.serviceImp.CommentsServiceImp;

/*
 * description:工具类封装
 * author:三人组
 * time:2021/2/26 12:30
 * param：
 * return:
 * */

public class Constant {	
	public static String JDBC_Driver = "com.mysql.jdbc.Driver";
	public static String DBUSER = "root";
	public static String DBPASSWORD = "123456";				//数据库db_webshop
	public static String DBURL = "jdbc:mysql://192.168.40.130:3306/db_webshop?characterEncoding=UTF-8&useSSL=false";
	public static String ContentType = "text/json;charset=utf-8";
	

	public static void JsonToFrontend(String json, HttpServletResponse response) {
		try {
			CommentsServiceImp commentsServiceImp = new CommentsServiceImp();
			PrintWriter out = response.getWriter();
			json = PageUtil.getJsonTree(commentsServiceImp.getCommentsSum(), "", json, 0);
			out.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static final String liftCycle = "900";
	public static long ExpireTime = Integer.parseInt(liftCycle)*1000;
	public static PrintWriter out;
	public static HttpSession session;
	static public void Base(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			//response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
