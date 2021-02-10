package com.dao;

import java.sql.*;

import com.entity.LoginResult;
import com.util.DBUtil;


public class LoginDao {

	public LoginResult Login(String username, String password) {
			//Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			int flag = -1; 
			LoginResult loginResult = new LoginResult();
			loginResult.setUsername(username);
			loginResult.setPassword(password);
			String sql = "select username,password,permission from emp_information";
			
			try {
				stmt = DBUtil.conn.prepareStatement(sql);
				result = stmt.executeQuery();
				while(result.next()) {
					String user = result.getString("username");
					String pass = result.getString("password");
					int permission = result.getInt("permission");
					
					if(username == null || password == null) {
						return null;
					}
					if(username.equals("")|| password.equals("")) {
						loginResult.setPower(-1);
						loginResult.setResult("NullError");                           //账号或密码为空
						break;
					}else if(user.equals(username) && pass.equals(password)) {
						loginResult.setPower(permission);
						loginResult.setResult("True");                                //通过
						break;
					}else if(user.equals(username) && !pass.equals(password)) {
						loginResult.setPower(-1);
						loginResult.setResult("PswError");                            //密码错误
						break;
					}
				}
				if(loginResult.getResult() == null) {
					loginResult.setPower(-1);
					loginResult.setResult("UnError");                            //账号不存在
				}
			}catch(Exception e) {
				e.printStackTrace();
				}
			return loginResult;
	}
}
