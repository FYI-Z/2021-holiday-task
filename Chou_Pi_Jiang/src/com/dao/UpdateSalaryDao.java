package com.dao;

import java.sql.*;

import com.util.DBUtil;



/**
 * des:操作工资表信息
 * author:邓涛
 * time:2021/2/8 20:36
 * param：
 * return:
 * 
 */

public class UpdateSalaryDao {
	
	/**
	 * des:添加工资信息到工资表中
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：String username, String basic, String overtime, String commission, String bonus, String vacate,
			String late, String absenteeism, String actual
	 * return:flag
	 * 
	 */
	
	public int Add(String username, String basic, String overtime, String commission, String bonus, String vacate,
			String late, String absenteeism, String actual) {
		PreparedStatement stmt = null;
		ResultSet results = null;
		int flag = -1;
		
		String sqlInsert = "insert into emp_salary value('";
		sqlInsert += username+"',";
		sqlInsert += basic+",";
		sqlInsert += overtime+",";
		sqlInsert += commission+",";
		sqlInsert += bonus+",";
		sqlInsert += vacate+",";
		sqlInsert += late+",";
		sqlInsert += absenteeism+",";
		sqlInsert += actual;
		sqlInsert+=",'未确认')";
		
		try {
			stmt = DBUtil.conn.prepareStatement(sqlInsert);
			int upRow = stmt.executeUpdate();
			if(upRow!=0) {
				flag = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	/**
	 * des:删除工资信息
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：String username
	 * return:flag
	 * 
	 */
	
	public int Del(String username) {
		PreparedStatement stmt = null;
		ResultSet results = null;
		int flag = -1;
		
		String sql = "delete from emp_salary where username='"+username+"'";
		
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			int delRow = stmt.executeUpdate();
			if(delRow!=0) {
				flag = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}


}
