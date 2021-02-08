package com.miku.DB;

import java.sql.*;

import com.miku.Util.DBUtil;

public class UpdateAttendanceDao {
	public int Add(String username, String leave_days, String late_days, String absenteeism_days, String overtime_hours) {
		PreparedStatement stmt = null;
		ResultSet results = null;
		int flag = -1;
		
		String sqlInsert = "insert into emp_attendance value('";
		sqlInsert += username+"',";
		sqlInsert += leave_days+",";
		sqlInsert += late_days+",";
		sqlInsert += absenteeism_days+",";
		sqlInsert += overtime_hours+")";
		
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
}
