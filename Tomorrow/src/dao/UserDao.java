package dao;


import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.UUID;




import entity.User;

import entity.UserToken;
import util.*;

public class UserDao {
	private static PreparedStatement st = null;
	private static ResultSet rs = null;
	static String sql ="";
	static int count =0;
	public  static int Number = 0;
	
	public ArrayList<User> FindUser(User user){
		ArrayList<User> list = new ArrayList<User>();
		sql=SQLConstant.Find_Usertable+" userid = ?";
		try {
			st= DBUtil.getPreparedStatement(sql);
			st.setString(1, user.getUsername());
			rs=st.executeQuery();
			Number=0;
			while(rs.next()) {
				user = new User();
				user.setUsername(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setAge(rs.getInt("age"));
				user.setPhone(rs.getString("phone"));
				user.setNickname(rs.getString("nickname"));
				user.setPermission(rs.getString("permission"));
				user.setSex(rs.getString("sex"));
				Number++;
				list.add(user);
			}
			
			
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean DeleteTable(User user) {
		sql=SQLConstant.Delete_Usertable;
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setString(1, user.getUsername());
			count=st.executeUpdate();
			st.close();
			if(count>0) {
				System.out.println("删除成功");
				return true;
			}
			else {
				System.out.println("删除失败");
				return false;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User UpdataTable(User user) {
		sql=SQLConstant.Update_Usertable;
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setString(1, user.getPassword());
			st.setString(2, user.getNickname());
			st.setString(3, user.getSex());
			st.setInt(4, user.getAge());
			st.setString(5, user.getPhone());
			st.setString(6, user.getPermission());
			st.setString(7, user.getEmail());
			st.setString(8, user.getUsername());
			count=st.executeUpdate();
			if(count>0) {
				user.setStatus("修改信息成功");
			}else {
				user.setStatus("修改信息成功");
			}
			st.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public ArrayList<User> showTable(){
		ArrayList<User> list = new ArrayList<User>();
		
		sql=SQLConstant.Find_AllUsertable;
		try {
			st=DBUtil.getPreparedStatement(sql);
			rs=st.executeQuery();
			Number=0;
			while(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setAge(rs.getInt("age"));
				user.setPhone(rs.getString("phone"));
				user.setNickname(rs.getString("nickname"));
				user.setPermission(rs.getString("permission"));
				user.setSex(rs.getString("sex"));
				Number++;
				list.add(user);
			}
			
			rs.close();
			st.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public User Register(User user) {
		sql=SQLConstant.Insert_Usertable+"(?,?,?,?,?,?,?,?)";
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			st.setString(3, user.getNickname());
			st.setString(4, user.getSex());
			st.setInt(5, user.getAge());
			st.setString(6, user.getPhone());
			st.setString(7, "用户");
			st.setString(8, user.getEmail());
			count=st.executeUpdate();
			st.close();	
			if(count>0)
			{
				user.setStatus("增加成功");
			}
			else {
				user.setStatus("增加失败");
			}
		} 
		catch (SQLException e) {
			user.setStatus("userid重复");
			e.printStackTrace();
			return user;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public UserToken saveToken(User user) {
		UserToken userToken = new UserToken();
		String token = UUID.randomUUID()+"";
		userToken.setToken(token);
		sql=SQLConstant.Insert_Token+"(?, ?, ?,?,?)";
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setString(1, token);
			System.out.println(token);
			st.setString(2, user.getUsername());
			st.setString(3, user.getPermission());
			st.setString(4, String.valueOf(System.currentTimeMillis()+Constant.ExpireTime));
			System.out.println("DAO:"+String.valueOf(Constant.ExpireTime));
			st.setString(5, "正常");
			count=st.executeUpdate();
			rs.close();
			st.close();
		
			if(count>0) {
				userToken.setStatus("正常");
				System.out.println("Dao正常");
				return userToken;
			}
			else {
				userToken.setStatus("生成token失败");
				System.out.println("失败");
				return userToken;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		catch (Exception e) {
			e.getStackTrace();
		}
		return userToken;
	}
	
	public User chekToken(UserToken userToken) {
		User user = new User();
		sql=SQLConstant.Find_Token+"token=?";
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setString(1, userToken.getToken());
			rs=st.executeQuery();
			if(rs.next()) {
				user.setUsername(rs.getString("username"));
				userToken.setExpireTime(rs.getString("time"));
			}
			else {
				user.setStatus("不存在的token");
				return user;
			}
			
			if(System.currentTimeMillis()-Long.valueOf(userToken.getExpireTime())<=Long.valueOf(Constant.liftCycle)*1000) {
				//令牌没有过期，查询另一个表中的用户信息
				sql=SQLConstant.Find_Usertable+" userid=?";
				st=DBUtil.getPreparedStatement(sql);
				st.setString(1, user.getUsername());
				rs=st.executeQuery();
				while(rs.next()) {
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setAge(rs.getInt("age"));
					user.setPhone(rs.getString("phone"));
					user.setNickname(rs.getString("nickname"));
					user.setPermission(rs.getString("permission"));
					user.setSex(rs.getString("sex"));
					user.setStatus("已获取用户信息");
				}
				rs.close();
				st.close();
				
			}
			else 
			{	//令牌时间为15分钟，15分钟后过期，过期执行以下语句
				sql=SQLConstant.Update_Token+" state=? where token=? ";
				st=DBUtil.getPreparedStatement(sql);
				st.setString(1,"过期");
				st.setString(2,userToken.getToken());
				st.executeUpdate();
				user.setUsername(user.getUsername());
				user.setStatus("token过期");
			}
		
		} catch (SQLException e) {
			System.out.println("数据库语句执行错误或者数据库异常");
			user.setUsername("根据此令牌无法获取数据");
			e.printStackTrace();
			return user;
		}
		catch (Exception e) {
			System.out.println("其它的错误");
			e.printStackTrace();
		}
		return user;
	}
	
	
	public User Login(User user) {
		sql=SQLConstant.Find_Usertable+"userid=? AND password=?";
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setString(1, user.getUsername());
			System.out.println(user.getUsername()+"  "+user.getPassword());
			st.setString(2, user.getPassword());
			rs=st.executeQuery();
			count =0;
			while (rs.next()) {
				user.setUsername(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setNickname(rs.getString("nickname"));
				user.setAge(rs.getInt("age"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setPermission(rs.getString("permission"));
				count++;
			}
				if(count<=0) {
					user.setStatus("账号或密码错误");
					//System.out.println("账号或密码错误");
				}
				else {
					user.setStatus("账号密码正确");
				}
				rs.close();
				st.close();
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}
	

}
