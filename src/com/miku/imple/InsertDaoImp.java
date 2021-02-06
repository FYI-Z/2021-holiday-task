package com.miku.imple;

import java.sql.*;

import com.miku.DB.InsertData;
import com.miku.Util.DBUtil;

public class InsertDaoImp implements InsertData{

	@Override
	public int Insert(String sql) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet results = null;
		int flag = -1;
		
		try {
			DBUtil util = new DBUtil();
			conn = util.getConnection();
			stmt = conn.prepareStatement(sql);
			int inRow = stmt.executeUpdate();
			if(inRow!=0) {
				flag = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, results);
		}
		return flag;
	}

}
