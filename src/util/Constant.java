package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

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
	
	/* description: 将字符串转成json数据格式并传到前端
	 * author: 李章
	 * time: 2021.02.28
	 * 参数: json,response
	 * 返回类型: void
	 * */
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
	
	
}
