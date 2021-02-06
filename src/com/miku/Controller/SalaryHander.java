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
import com.miku.Entity.SalaryData;
import com.miku.Service.SalaryService;
import com.miku.Service.serviceimp.SalaryServiceImp;

/**
 * author:邓涛
 */
public class SalaryHander extends HttpServlet {
	

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("appication/json;Charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			SalaryServiceImp service = new SalaryServiceImp();
			List<SalaryData> list = service.list();
			String jsonArray = JSON.toJSONString(list);
			out.print(jsonArray);
			out.flush();
			out.close();
			System.out.println(jsonArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
