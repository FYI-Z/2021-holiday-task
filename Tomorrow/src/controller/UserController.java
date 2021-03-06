package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.alibaba.fastjson.JSON;


import entity.User;

import entity.UserToken;
import service.serviceImp.UserServiceImp;
import util.Constant;



public class UserController extends HttpServlet {
	UserServiceImp userServiceImp = new UserServiceImp();
	User user = new User();
	UserToken userToken = new UserToken();
	String json = "";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		Constant.Base(request, response);
		String flag = request.getParameter("flag");
		if(flag.equals("login")) {
			Login(request, response);
		}
		else if (flag.equals("checkToken")) {
			checkToken(request,response);
		}
		else if (flag.equals("register")) {
			Register(request,response);
		}
		else if (flag.equals("showtable")) {
			ShowTable(request, response);
		}
		else if (flag.equals("UpdataTable")) {
			UpdataTable(request, response);
		}
		else if (flag.equals("DeleteTable")) {
			DeleteTable(request, response);
		}
		else if (flag.equals("findUser")) {
			FindUser(request, response);
		}
	}
	
	protected void FindUser(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		Map map = new HashMap<>();
		map.put("code", "0");
		map.put("msg", "");
		map.put("count", 50);
		map.put("data",userServiceImp.FindUser(userid));
		json=JSON.toJSONString(map);
		Constant.out.write(json);
	}
	
	protected void DeleteTable(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		Map map = new HashMap<>();
		if(userServiceImp.DeleteUsertable(userid)) {
			map.put("result", "删除成功");
		}
		else {
			map.put("result", "删除失败");
		}
		json=JSON.toJSONString(map);
		Constant.out.write(json);
	}
	protected void UpdataTable(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		int age = Integer.valueOf(request.getParameter("age"));
		String permission= request.getParameter("permission");
		String email = request.getParameter("email");
		user= userServiceImp.UpdataTable(userid, password, nickname, sex, age, phone, permission, email);
		Map map = new HashMap<>();
		if(user.getStatus().equals("修改信息成功")) {
			map.put("code", "0");
			map.put("msg", "success");
			map.put("userid", user.getUsername());
		}
		else {
			map.put("code", "1");
			map.put("msg", "fail");
			map.put("userid", user.getUsername());
		}
		json=JSON.toJSONString(user);
		Constant.out.write(json);
	}
	protected void ShowTable(HttpServletRequest request, HttpServletResponse response) {
		Map map = new HashMap<>();
		map.put("code", "0");
		map.put("msg", "");
		map.put("count", 50);
		map.put("data",userServiceImp.showUserTable());
		json = JSON.toJSONString(map);
		Constant.out.write(json);
	}
	protected void Register(HttpServletRequest request, HttpServletResponse response) {
		try {
			String userid = request.getParameter("userid");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			String phone = request.getParameter("phone");
			String sex = request.getParameter("sex");
			int age = Integer.valueOf(request.getParameter("age"));
			String email = request.getParameter("email");
			user=userServiceImp.register(userid, password, nickname, phone, sex, age, email);
			Map map = new HashMap<>();
			if(user.getStatus().equals("userid重复")) {
				map.put("msg", "fail");
			}
			else {
				map.put("msg", "success");
			}
			map.put("data", user);
			json = JSON.toJSONString(map);
			Constant.out.write(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void Login(HttpServletRequest request, HttpServletResponse response){
		try {
			
			String username=request.getParameter("userid");
			String password=request.getParameter("password");
			user = userServiceImp.Login(username, password);
			Map map = new HashMap<>();
			if(user.getStatus().equals("账号密码正确"))
			{
				map.put("status", "账号密码正确");
				System.out.println("账号密码正确");
			}
			else {
				map.put("status", "账号或密码错误");
				Constant.out.write(JSON.toJSONString(map));
				return;
			}
			
			userToken=userServiceImp.saveToken(user);
			HttpSession session =request.getSession();
			session.setAttribute("token", userToken);
			map.put("token", userToken);
			json = JSON.toJSONString(map);
			Constant.out.write(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void checkToken(HttpServletRequest request, HttpServletResponse response) {
		try {
			String token = request.getParameter("token");
			userToken.setToken(token);
			user = userServiceImp.checkToken(userToken);
			Map map = new HashMap<>();
			map.put("data", user);
			map.put("token", token);
			json = JSON.toJSONString(map);
			Constant.out.write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
