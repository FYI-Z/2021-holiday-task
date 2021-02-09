package com.miku.DB;

import java.sql.*;

import com.miku.Util.DBUtil;

public class UpdateAttendanceDao {
	public int Add(String username, String leave_days, String late_days, String absenteeism_days, String overtime_hours, String status) {
		//Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet results = null;
		int flag = -1;
		String sql = null;
		String temp = null;
		temp = "'"+username+"',";
		temp += leave_days+",";
		temp += late_days+",";
		temp += absenteeism_days+",";
		temp += overtime_hours;
		if(status.equalsIgnoreCase("add")) {
			sql = "insert into emp_attendance value("+temp+")";
		}
			try {
				stmt = DBUtil.conn.prepareStatement(sql);
				int upRow = stmt.executeUpdate();
				if(upRow!=0) {
					flag = 1;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
					
		
		return flag;
		
	}
	
	public int Del(String username) {
		PreparedStatement stmt = null;
		ResultSet results = null;
		int flag = -1;
		
		String sql = "delete from emp_attendance where username='"+username+"'";
		
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
