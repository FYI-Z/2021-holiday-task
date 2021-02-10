package com.service.serviceImp;

import java.util.List;

import com.dao.DepartmentDao;
import com.entity.Departments;
import com.service.DepartmentService;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * description: 对部门管理的操作进行逻辑处理
 * author: 李章
 * time: 2021.02.08
 * the name of the class: DepartmentServiceImp
 * */
public class DepartmentServiceImp implements DepartmentService{
	DepartmentDao departmentDao = new DepartmentDao();
	static int sum = 0;
	
	/* description: 查询现有所有部门
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: 
	 * 返回类型: List<Departments>
	 * */	
	public List<Departments> AllDepartment(){
		sum = departmentDao.getDepartmentSum();
		return departmentDao.AllDepartment();
	}
	
	/* description: 获取现有部门个数
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: 
	 * 返回类型: int
	 * */	
	public int getDepartmentSum() {
		return sum;
	}
	
	/* description: 创建部门
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: name,operator
	 * 返回类型: String
	 * */	
	public String AddDepartment(String name, String operator) {
		if(departmentDao.AddDepartment(name, operator) != 0) {
			return "部门创建成功";
		}
		else {
			return "创建失败！！！";
		}
	}
	
	/* description: 删除部门
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: name,operator
	 * 返回类型: String
	 * */	
	public String DeleteDepartment(String name, String operator) {
		if(departmentDao.DeleteDepartment(name) != 0) {
			return "删除成功";
		}
		else {
			return "ɾ删除失败！！！";
		}
	}
	
	/* description: 对部门进行更名
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: name,new_name,changed_operator
	 * 返回类型: String
	 * */
	public String EditDepartment(String name, String new_name, String changed_operator) {
		Departments department = departmentDao.FindDepartment(new_name);
		if(department == null) {
			int count = departmentDao.EditDepartment(name, new_name, changed_operator);
			if(count != -1) {
				UpdateDepartment(name,new_name);
				return "更名成功";
			}
		}
		return "更名失败，请检查该部门名称是否冲突";
	}
	
	/* description: 对员工部门信息进行更新
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: name,new_name
	 * 返回类型: void
	 * */
	public void UpdateDepartment(String name, String new_name) {
		List<String> list = departmentDao.FindStaffUsername(name);
		for (Iterator<String> it1 = list.iterator(); it1.hasNext();) {
			System.out.println(it1.next());
		}
		departmentDao.UpdateStaffDepartment(list,new_name);
	}
	
	/* description: 从字符串中获取部门名称
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: data
	 * 返回类型: List<String>
	 * */
	public List<String> JSONToString(String data) {
		List<String> rs_list = new ArrayList<String>();
		String[] tmp_list = data.split(",");
		String[] dtmp_list;
		String str;
		for(int i=0;i<tmp_list.length;i++)
		{
			if(i % 2 == 0) {
				dtmp_list = tmp_list[i].split(":");
				str = dtmp_list[1];
				str = str.replaceAll("\"", "");
				str.replace(" ", "");
				rs_list.add(str);
			}	
		}
		return rs_list;
	}
	
	/* description: 对部门进行合并
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: before_department,name,operator
	 * 返回类型: String
	 * */
	public String CombineDepartment(List<String> before_department, String name, String operator) { 
		int falg = 0;
		List<String> tmp_list = new ArrayList<String>();
		List<String> username_list = new ArrayList<String>();
		Departments departments = departmentDao.FindDepartment(name);
		//��ѯ���������Ƿ��ͻ
		for (Iterator<String> it1 = before_department.iterator(); it1.hasNext();) {
			if(it1.next().equals(name) || departments == null) { 
				falg = 1;
			}
		}
		if(falg == 0) {
			return "部门名称冲突，请更换";
		}
		//找出合并前部门的员工username
		for (Iterator<String> it1 = before_department.iterator(); it1.hasNext();) {
			tmp_list = departmentDao.FindStaffUsername(it1.next()); 
			for (Iterator<String> it2 = tmp_list.iterator(); it2.hasNext();) {  
				username_list.add(it2.next());
			}
		}
		//通过部门名称删除合并前部门
		for (Iterator<String> it1 = before_department.iterator(); it1.hasNext();) {
			departmentDao.DeleteDepartment(it1.next());
		}
		departmentDao.AddDepartment(name, operator);
		departmentDao.UpdateStaffDepartment(username_list, name);
		return "合并成功";
	}
	
}
