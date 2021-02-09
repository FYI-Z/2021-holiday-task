package com.miku.DB;

import java.sql.*;

import com.miku.Util.DBUtil;

public class UpdateStatusDao {
	public int Update(String username,String method) {
		PreparedStatement stmt = null;
		int flag = -1;
		String sql = null;
		
		if("1".equalsIgnoreCase(method)) {
			sql = "Update emp_Salary set confirm='审核通过' where username='"+username+"'";
		}
		else if("2".equalsIgnoreCase(method)) {
			sql = "Update emp_Salary set confirm='审核不通过' where username='"+username+"'";
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
}
