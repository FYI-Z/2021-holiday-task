package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.dao.UpdateAttendanceDao;
import com.entity.SalaryData;
import com.service.serviceImp.AttendanceServiceImp;
import com.service.serviceImp.SalaryServiceImp;


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
	 * des:接受前端发送的请求根据对应状态进入相应函数
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：request，response
	 * return:无
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
		else if("add".equalsIgnoreCase(status)) {
			addAttendance(request,response,status);
		}
		else if("totalAttend".equalsIgnoreCase(status)) {
			showAttend(request,response);
		}
		else if("del".equalsIgnoreCase(status)) {
			delAttendance(request,response,username);
		}
	    if("search".equalsIgnoreCase(search)) {
			SearchOper(request,response,username);//这个就是搜索结果
		}
	}
	
	/**
	 * des:删除考勤表中的数据
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：request，response，username
	 * return:无
	 * 
	 */
	private void delAttendance(HttpServletRequest request, HttpServletResponse response,String username) {
		
		UpdateAttendanceDao del = new UpdateAttendanceDao();
		int res = -1;
		try {
			res = del.Del(username);
			System.out.println("删除成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * des:显示工资表中所有数据
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：request，response
	 * return:无
	 * 
	 */
	private void showAttend(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			PrintWriter out = response.getWriter();
			AttendanceServiceImp serviceTotal = new AttendanceServiceImp();
			List<SalaryData> list = serviceTotal.list();
			String jsonArray = JSON.toJSONString(list);
			out.print(jsonArray);
			out.flush();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * des:根据username查找对应数据
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：request，response，username
	 * return:list
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
	
	/**
	 * des:添加工资表数据
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：request，response
	 * return:无
	 * 
	 */

	private void addAttendance(HttpServletRequest request, HttpServletResponse response, String status) {
		UpdateAttendanceDao upAttend = new UpdateAttendanceDao();
		int res = -1;
		String username = request.getParameter("username");
		String leave_days =request.getParameter("leave_days");
		String late_days = request.getParameter("late_days");
		String absenteeism_days = request.getParameter("absenteeism_days");
		String overtime_hours = request.getParameter("overtime_hours");
		
		try {
			res = upAttend.Add(username,leave_days,late_days,absenteeism_days,overtime_hours,status);
			System.out.println("更新成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * des:拿到工资报表的数据，两表合起来的结果
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：request，response
	 * return:无
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
