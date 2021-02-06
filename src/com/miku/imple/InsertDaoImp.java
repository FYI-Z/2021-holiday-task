package com.miku.imple;

import java.sql.*;

import com.miku.DB.InsertData;
import com.miku.Util.DBUtil;

public class InsertDaoImp implements InsertData{

	@Override
	public int Insert(String sql) {
		PreparedStatement stmt = null;
		ResultSet results = null;
		int flag = -1;
		
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			int inRow = stmt.executeUpdate();
			if(inRow!=0) {
				flag = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
