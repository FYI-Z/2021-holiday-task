package com.miku.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.miku.DB.UpdateSalaryDao;
import com.miku.DB.UpdateStatusDao;
import com.miku.Entity.SalaryData;
import com.miku.Service.SalaryService;
import com.miku.Service.serviceimp.SalaryServiceImp;
import com.miku.Util.DBUtil;
import com.miku.Util.SumTotalSalary;

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
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("appication/json;Charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		String status = request.getParameter("status");
		String username = request.getParameter("username");
		//System.out.println(username);

		
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
	
	/*
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
			//System.out.println(jsonArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	

	/*
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

	/*
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

	/*
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
