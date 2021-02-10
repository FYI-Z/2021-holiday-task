package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.service.serviceImp.DepartmentServiceImp;
import com.util.Constant;
import com.util.PageUtil;

/*
 * description: 实现部门管理对应的操作
 * author: 李章
 * time: 2021.02.08
 * the name of the class: DepartmentController
 * */
public class DepartmentController extends HttpServlet {
	
	/* description: 打印现有部门
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: request,response
	 * 返回类型: void
	 * */	
	DepartmentServiceImp departmentServiceImp = new DepartmentServiceImp();
	public void PrintDepartment(HttpServletRequest request, HttpServletResponse response){
			try {
				PrintWriter out = response.getWriter();
				Map<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
				linkedHashMap.put("code", 0);
				linkedHashMap.put("msg", "success");
				linkedHashMap.put("item", departmentServiceImp.AllDepartment());
				String json = JSON.toJSONString(linkedHashMap);
				System.out.println(json);	
				out.write(json);	
			} catch (IOException e) {
				System.out.println("DepartmentController�е�PrintDepartment�쳣");
				e.printStackTrace();
			}
	}
	
	/* description: 获取部门名称和操作者并存放到字符串数组中
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: request,response
	 * 返回类型: List<String>
	 * */	
	public List<String> GetDeptNameAndOperator(HttpServletRequest request, HttpServletResponse response) {
			List<String> list = new ArrayList<String>();
			response.setContentType(Constant.ContentType);
			list.add(request.getParameter("name"));
			list.add(request.getParameter("operator"));
		return list;
	}
	
	/* description: 将字符串转成json数据格式并传到前端
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: json,response
	 * 返回类型: void
	 * */
	public void JsonToFrontend(String json, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			json = PageUtil.getJsonTree(departmentServiceImp.getDepartmentSum(), "", json, 0);
			out.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* description: 创建一个新的部门
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: request,response
	 * 返回类型: void
	 * */
	public void AddDepartment(HttpServletRequest request, HttpServletResponse response){
			List<String> list = GetDeptNameAndOperator(request,response);
			String json = JSON.toJSONString(departmentServiceImp.AddDepartment(list.get(0),list.get(1)));	//转为json
			JsonToFrontend(json, response);
	}
	
	/* description: 创建一个新的部门
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: request,response
	 * 返回类型: void
	 * */
	public void DeleteDepartment(HttpServletRequest request, HttpServletResponse response){
		List<String> list = GetDeptNameAndOperator(request,response);
		String json = JSON.toJSONString(departmentServiceImp.DeleteDepartment(list.get(0),list.get(1)));	//转为json
		JsonToFrontend(json, response);
	}
	
	/* description: 删除指定的部门
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: request,response
	 * 返回类型: void
	 * */
	public void EditDepartment(HttpServletRequest request, HttpServletResponse response){
		List<String> list = GetDeptNameAndOperator(request,response);
		String changed_name = request.getParameter("changed_name");  //更名后的部门名称
		String rs = departmentServiceImp.EditDepartment(list.get(0), changed_name, list.get(1));
		String json = JSON.toJSONString(rs); //转化为json字符串
		JsonToFrontend(json, response);
	}
	
	/* description: 指定的部门合并
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: request,response
	 * 返回类型: void
	 * */
	public void CombineDepartment(HttpServletRequest request, HttpServletResponse response){
		List<String> list = GetDeptNameAndOperator(request,response);
		String data = request.getParameter("data"); 
		List<String> operatorlist = departmentServiceImp.JSONToString(data);
		String json = JSON.toJSONString(departmentServiceImp.CombineDepartment(operatorlist,list.get(0),list.get(1))); 
		JsonToFrontend(json, response);
	}
}

