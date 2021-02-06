package com.miku.Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.miku.Entity.UserData;
import com.miku.Service.UserService;
import com.miku.Service.serviceimp.UserServiceImp;
import com.miku.Util.DBUtil;
import com.miku.Util.JsonTypeChange;
import com.miku.imple.DelUserDaoImp;
import com.miku.imple.InsertDaoImp;
import com.miku.imple.UpdateDaoImp;

import java.util.List;

public class UserHander extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//相应内容
		response.setContentType("appication/json;Charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String status = request.getParameter("status");
		System.out.println(status);

		UserService service = new UserServiceImp();
		
		//展示数据
		List<UserData> list = service.list();
		String jsonArray = JSON.toJSONString(list);
		out.print(jsonArray);
		out.flush();
		out.close();
		System.out.println(jsonArray);
		if("del".equalsIgnoreCase(status)) {
			DelOper(request,response,username);
		}
		else if("update".equalsIgnoreCase(status)||"insert".equalsIgnoreCase(status)) {
			UpdateOper(request,response,status);
		}

	}
	//del
	public void DelOper(HttpServletRequest request, HttpServletResponse response,String username) throws IOException{
		DelUserDaoImp del = new DelUserDaoImp();
		int res = 0;
		
		try {
			res = del.Del(username);
			if(res!=0) {
				System.out.println("成功删除!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Updata
	public void UpdateOper(HttpServletRequest request, HttpServletResponse response,String status) {
		UpdateDaoImp update = new UpdateDaoImp();
		InsertDaoImp insert = new InsertDaoImp();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String department = request.getParameter("department");
		String position = request.getParameter("position");
		String contact = request.getParameter("contact");
		String permission = request.getParameter("permission");
		int res = 0;
		
		if("update".equalsIgnoreCase(status)) {
			String sqlUpdate = "update emp_information set ";
			sqlUpdate += "password='"+password+"',";
			sqlUpdate += "name='"+name+"',";
			sqlUpdate += "sex='"+sex+"',";
			sqlUpdate += "age='"+age+"',";
			sqlUpdate += "department='"+department+"',";
			sqlUpdate += "position='"+position+"',";
			sqlUpdate += "contact='"+contact+"',";
			sqlUpdate += "permission='"+permission+"'";
			sqlUpdate += "where username='"+username+"'";
			
			try {
				res = update.UpdateData(sqlUpdate);
				System.out.println("更新成功");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if("insert".equalsIgnoreCase(status)) {
			String sqlInsert = "insert into emp_information value('";
			sqlInsert += username+"','";
			sqlInsert += password+"','";
			sqlInsert += name+"','";
			sqlInsert += sex+"','";
			sqlInsert += age+"','";
			sqlInsert += department+"','";
			sqlInsert += position+"','";
			sqlInsert += contact+"','";
			sqlInsert += permission+"')";
			
			try {
				res = insert.Insert(sqlInsert);
				if(res>0) {
					System.out.println("添加成功");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//update结束
	
}
