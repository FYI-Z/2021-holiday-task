package com.miku.imple;

import java.sql.*;

import com.miku.DB.UpdataDao;
import com.miku.Util.DBUtil;

public class UpdateDaoImp implements UpdataDao{

	@Override
	public int UpdateData(String sql) {
		PreparedStatement stmt = null;
		ResultSet results = null;
		int flag = -1;
		
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
