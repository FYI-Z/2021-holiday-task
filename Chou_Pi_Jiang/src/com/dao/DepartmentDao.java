package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.entity.Departments;
import com.util.DBUtil;
import com.util.SQLConstant;

/*
 * description: 部门管理数据访问
 * author: 李章
 * time: 2021.02.08
 * the name of the class: DepartmentDao 
 * */
public class DepartmentDao {
	static int sum = 0;		//部门总数
	
	/* description: 将现有部门存入List
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: 
	 * 返回类型: List<Departments>
	 * */		
	public List<Departments> AllDepartment(){
		List<Departments> list = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = SQLConstant.Select_Department;
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeQuery();
			while(rs.next()) {
				sum++;
				Departments departments = new Departments();
				departments.setName(rs.getString("name"));
				departments.setOperator(rs.getString("operator"));
				list.add(departments);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/* description: 返回现有部门总个数
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: 
	 * 返回类型: int
	 * */
	public int getDepartmentSum() {
		return sum;
	}
	
	/* description: 部门查询
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: name
	 * 返回类型: Departments
	 * */
	public Departments FindDepartment(String name) {
		Departments departments = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = SQLConstant.Select_Department + " " + "where name='"+name+"'";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeQuery();
			if(rs.next()) {
				departments = new Departments();
			}
		} catch (SQLException e) {
			System.out.println("部门查询失败！！！");
			e.printStackTrace();
		}
		return departments;
	}
	  
	/* description: 创建部门
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: name,operator
	 * 返回类型: int
	 * */
	public int AddDepartment(String name, String operator) {
		PreparedStatement st = null;
		String sql = SQLConstant.Insert_Department + " " + "value('"+name+"','"+operator+"');";
		st = DBUtil.getPreparedStatement(sql);
		int count = 0;
		try {
			count = st.executeUpdate(sql);
		}catch(SQLException e) {
			System.out.println("数据库创建部门失败！！！");
			e.printStackTrace();
		}
		return count; 
	}
	
	/* description: 删除部门
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: name
	 * 返回类型: int
	 * */
	public int DeleteDepartment(String name) {
		PreparedStatement st = null;
		String sql = SQLConstant.Delete_Department + " " + "where name = '"+name+"';";
		st = DBUtil.getPreparedStatement(sql);
		int count = 0;
		try {
			count = st.executeUpdate(sql);
		}catch(SQLException e) {
			System.out.println("数据库删除部门数据失败！！！");
			e.printStackTrace();
		}
		return count; 
	}
	
	/* description: 部门更名
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: name，new_name,changed_operator
	 * 返回类型: int
	 * */
	public int EditDepartment(String name, String new_name, String changed_operator) {
		int rs = -1;
		PreparedStatement st = null;
		String sql = SQLConstant.Update_Department + " " + "set name='"+new_name+"',operator='"+changed_operator+"' where name='"+name+"';";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("数据库部门更名失败！！！");
			e.printStackTrace();
		}
		return rs;
	}
	
	/* description: 对员工部门进行更新
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: list，new_name
	 * 返回类型: int
	 * */
	public int UpdateStaffDepartment(List<String> list, String new_name) {
		int count = 0;
		int rs = -1;
		PreparedStatement st = null;
		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			String sql = SQLConstant.Update_Information + " " + "set department='"+new_name+"' where username='"+it.next()+"'";
			st = DBUtil.getPreparedStatement(sql);
			try {
				rs = st.executeUpdate();
				count += rs;
			} catch (SQLException e) {
				System.out.println("员工部门更新出错"+rs);
				e.printStackTrace();
			}
		}
		return count;
	}
	
	/* description: 对所有员工用户名进行查询
	 * author: 李章
	 * time: 2021.02.08
	 * 参数: list，new_name
	 * 返回类型: List<String>
	 * */
	public List<String> FindStaffUsername(String name) {
		List<String> list = new ArrayList<String>();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = SQLConstant.Select_Information + " " + "where department='"+name+"'";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeQuery();
			if(rs.next()) {
				do {
					list.add(rs.getString(1));
				}while(rs.next());
			}
			else { 
				System.out.println("无该员工");
			}
		} catch (SQLException e) {
			System.out.println("查询所有员工的失败！！！");
			e.printStackTrace();
		}
		return list;
	}
}
