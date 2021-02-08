package com.miku.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.miku.DB.UpdateAttendanceDao;
import com.miku.DB.UpdateSalaryDao;
import com.miku.Entity.SalaryData;
import com.miku.Service.serviceimp.AttendanceServiceImp;
import com.miku.Service.serviceimp.SalaryServiceImp;

/**
 * author:邓涛
 */
public class AttendHander extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			doPost(request,response);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		response.setContentType("appication/json;Charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String search = request.getParameter("search");
		String status = request.getParameter("status");
		System.out.println(search);
		if("Total".equalsIgnoreCase(status)) {
			showTotal(request,response);
		}
		 if("add".equalsIgnoreCase(status)) {
			AddAttendance(request,response);
		}
		if("search".equalsIgnoreCase(search)) {
			SearchOper(request,response,username);//这个就是搜索结果
		}
	}
	
	/*
	 * 
	 */
	
	private void SearchOper(HttpServletRequest request, HttpServletResponse response, String username) {
		try {
			PrintWriter out = response.getWriter();
			SalaryServiceImp searchInfo = new SalaryServiceImp();
			List<SalaryData> list = searchInfo.listSearch(username);
			String jsonArray = JSON.toJSONString(list);
			out.print(jsonArray);
			out.flush();
			out.close();
			System.out.println(jsonArray);
		} catch (IOException e) {	
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 
	 */

	private void AddAttendance(HttpServletRequest request, HttpServletResponse response) {
		UpdateAttendanceDao upAttend = new UpdateAttendanceDao();
		int res = -1;
		String username = request.getParameter("username");
		String leave_days =request.getParameter("leave_days");
		String late_days = request.getParameter("late_days");
		String absenteeism_days = request.getParameter("absenteeism_days");
		String overtime_hours = request.getParameter("overtime_hours");
		
		try {
			res = upAttend.Add(username,leave_days,late_days,absenteeism_days,overtime_hours);
			System.out.println("添加成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 
	 */
	private void showTotal(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			AttendanceServiceImp serviceTotal = new AttendanceServiceImp();
			List<SalaryData> list = serviceTotal.ListAll();
			String jsonArray = JSON.toJSONString(list);
			out.print(jsonArray);
			out.flush();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
