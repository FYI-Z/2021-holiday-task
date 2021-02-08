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
		showTotal(request,response);
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
