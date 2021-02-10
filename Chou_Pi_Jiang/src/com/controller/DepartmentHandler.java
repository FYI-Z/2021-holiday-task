package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.Constant;


/*
 * description: 对部门管理页面操作的处理
 * author: 李章
 * time: 2021.02.08
 * the name of the class: DepartmentHandler
 * */
public class DepartmentHandler extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			doPost(request, response);
		}catch(Exception e) {
			System.out.println("DepartmentHandler中doGet异常！！！");
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			response.setContentType(Constant.ContentType);
			DepartmentController departmentController = new DepartmentController();
			String method = request.getParameter("method");
			System.out.println(method);
			if(method.equals("getAll")) {
				departmentController.PrintDepartment(request, response);
			}else if(method.equals("add")) {
				departmentController.AddDepartment(request, response);
			}else if(method.equals("del")) {
				departmentController.DeleteDepartment(request, response);
			}else if(method.equals("edit")) {
				departmentController.EditDepartment(request, response);
			}else if(method.equals("combine")) {
				departmentController.CombineDepartment(request, response);
			}
		}catch(Exception e) {
			System.out.println("DepartmentHandler中doPost异常！！！");
			e.printStackTrace();
		}
	}
}
