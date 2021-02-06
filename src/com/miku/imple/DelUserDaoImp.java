package com.miku.imple;


import java.sql.*;

import com.miku.DB.DelUserDao;
import com.miku.Util.DBUtil;

public class DelUserDaoImp implements DelUserDao{

	@Override
	public int Del(String username) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		int flag = -1;
		
		try {
			
			String sql;
			sql = "delete from emp_information where username='"+username+"'";
			stmt = DBUtil.conn.prepareStatement(sql);
		    int delRpow = stmt.executeUpdate();
			if(delRpow!=0) {
				flag = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
