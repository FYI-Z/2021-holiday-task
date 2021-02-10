package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.dao.UpdateSalaryDao;
import com.dao.UpdateStatusDao;
import com.entity.SalaryData;
import com.service.serviceImp.SalaryServiceImp;
import com.util.SumTotalSalary;


/**
 * author:邓涛
 */
public class SalaryHander extends HttpServlet {
	
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("appication/json;Charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		String status = request.getParameter("status");
		String username = request.getParameter("username");

		
		if("1".equalsIgnoreCase(method)||"2".equalsIgnoreCase(method)) {
			confirmSuccess(request,response,method);
		}
		if("add".equalsIgnoreCase(status)) {
			AddSalary(request,response);
		}
		else if("del".equalsIgnoreCase(status)) {
			DelOper(request,response,username);
		}
			ShowTotal(request,response);
//			SearchOper(request,response,username);
		
	}
	
	/**
	 * des:拿到数据库中工资表的所有数据
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：request，response
	 * return:无
	 * 
	 */
	
	private void ShowTotal(HttpServletRequest request, HttpServletResponse response) {

		try {
			PrintWriter out = response.getWriter();
			SalaryServiceImp Total = new SalaryServiceImp();
			List<SalaryData> list = Total.list();
			String jsonArray = JSON.toJSONString(list);
			out.print(jsonArray);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	

	/**
	 * des:删除工资表中的对应一行的数据
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：request，response
	 * return:无
	 * 
	 */
	private void DelOper(HttpServletRequest request, HttpServletResponse response, String username) {
		UpdateSalaryDao del = new UpdateSalaryDao();
		int res = -1;
		try {
			res = del.Del(username);
			System.out.println("删除成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * des:添加工资数据到数据库中
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：request，response
	 * return:无
	 * 
	 */
	public void AddSalary(HttpServletRequest request, HttpServletResponse response) {
		UpdateSalaryDao upSalary = new UpdateSalaryDao();
		int res = -1;
		String username = request.getParameter("username");
		String basic = request.getParameter("basic");
		String overtime = request.getParameter("overtime");
		String commission = request.getParameter("commission");
		String bonus = request.getParameter("bonus");
		String vacate = request.getParameter("vacate");
		String late = request.getParameter("late");
		String absenteeism = request.getParameter("absenteeism");
		String actual = SumTotalSalary.SumSalary(basic,overtime,commission,bonus,vacate,late,absenteeism);
		
		try {
			res = upSalary.Add(username,basic,overtime,commission,bonus,vacate,late,absenteeism,actual);
			System.out.println("添加成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * des:前端审核数据是否有误
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：request，response
	 * return:无
	 * 
	 */
	public void confirmSuccess(HttpServletRequest request, HttpServletResponse response,String method) {
		String username = request.getParameter("username");
		UpdateStatusDao upStatus = new UpdateStatusDao();
		int res = 0;
		try {
			res = upStatus.Update(username, method);
			if(res>0) {
				System.out.println("更新状态成功");
				//request.getRequestDispatcher("/SalaryCheck.html").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
