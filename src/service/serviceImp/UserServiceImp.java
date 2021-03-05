package service.serviceImp;

import java.util.ArrayList;


import dao.UserDao;
import entity.User;

import entity.UserToken;
import service.UserService;

public class UserServiceImp implements UserService {
	
	UserDao userDao = new UserDao();
	UserToken userToken = new UserToken();
	User user = new User();
	
	
	public ArrayList<User> FindUser(String userid){
		user.setUsername(userid);
		ArrayList<User> list = userDao.FindUser(user);
		return list;
	}
	
	public boolean DeleteUsertable(String userid) {
		user.setUsername(userid);
		if(userDao.DeleteTable(user))
			return true;
		else {
			return false;
		}
	}
	
	public User UpdataTable(String userid,String password,String nickname,String sex,Integer age,String phone,String permission,String email) {
		user.setAge(age);
		user.setEmail(email);
		user.setNickname(nickname);
		user.setPassword(password);
		user.setPermission(permission);
		user.setPhone(phone);
		user.setSex(sex);
		user.setUsername(userid);
		user=userDao.UpdataTable(user);
		return user;
	}
	public ArrayList<User> showUserTable(){
		ArrayList<User> list = userDao.showTable();
		return list;
	}
	
	public User register(String username,String password,String nickname ,String phone,String sex,int age,String email) {
		user.setUsername(username);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setPhone(phone);
		user.setSex(sex);
		user.setAge(age);
		user.setEmail(email);
		user=userDao.Register(user);
		return user;
	}
	
	public User checkToken(UserToken userToken) {
		
		User user = userDao.chekToken(userToken);
		return user;
	}
	
	public UserToken saveToken(User user) {
		System.out.println("进入了IMP的savatoken");
		userToken = userDao.saveToken(user);
		//userToken.outPut();
		return userToken;
	}
	public User Login (String username,String password) {
		user.setUsername(username);
		user.setPassword(password);
		user = userDao.Login(user);
		return user;
	}
}
