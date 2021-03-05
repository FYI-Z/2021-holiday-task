package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import dao.AddressDao;
import entity.AddressEntity;
import entity.Goods;
import service.serviceImp.AddressServiceImp;
import util.Constant;



public class AddressController extends HttpServlet {
	AddressServiceImp addressServiceImp = new AddressServiceImp(); 
	AddressEntity addressEntity = new AddressEntity();
	String json = "";
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		try {
			doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		String flag = request.getParameter("flag");
		try {
			Constant.Base(request, response);
			if(flag.equals("plusaddress")) {
				plusAddress(request, response);
			}
			else if (flag.equals("deleteaddress")) {
				deleteAddress(request, response);
			}
			else if (flag.equals("findaddress")) {
				findAddress(request, response);
			}
			else if (flag.equals("updataaddress")) {
				updataAddress(request, response);
			}
			else if (flag.equals("showaddress")) {
				showAddress(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void plusAddress(HttpServletRequest request, HttpServletResponse response)  {
		String userid=request.getParameter("userid"),
		name=request.getParameter("name"),
		phone=request.getParameter("phone"),
		address=request.getParameter("address");
		addressEntity = addressServiceImp.addAddress(userid, name, phone, address);
		json = JSON.toJSONString(addressEntity);
		Constant.out.println(json);
	}
	protected void deleteAddress(HttpServletRequest request, HttpServletResponse response)  {
		int addressid = Integer.valueOf(request.getParameter("addressid"));
		addressEntity = addressServiceImp.deleteAddress(addressid);
		json = JSON.toJSONString(addressEntity);
		Constant.out.println(json);
	}
	protected void findAddress(HttpServletRequest request, HttpServletResponse response)  {
		String userid = request.getParameter("userid");
		ArrayList<AddressEntity> list = addressServiceImp.findGoodsId(userid);
		Map map = new HashMap();
		map.put("code", "0");
		map.put("msg", "");
		map.put("count", AddressDao.Number);
		map.put("data",list);
		json = JSON.toJSONString(map);
		Constant.out.print(json);
	}
	protected void updataAddress(HttpServletRequest request, HttpServletResponse response)  {
		int addressid = Integer.valueOf(request.getParameter("addressid"));
		String userid=request.getParameter("userid"),
		name=request.getParameter("name"),
		phone=request.getParameter("phone"),
		address=request.getParameter("address");
		addressEntity = addressServiceImp.updataAddress(userid, addressid, name, phone, address);
		json = JSON.toJSONString(addressEntity);
		Constant.out.print(json);
	}
	protected void showAddress(HttpServletRequest request, HttpServletResponse response)  {
		ArrayList<AddressEntity> list = addressServiceImp.showAddress();
		Map map = new HashMap();
		map.put("code", "0");
		map.put("msg", "");
		map.put("count", AddressDao.Number);
		map.put("data",list);
		json = JSON.toJSONString(map);
		Constant.out.print(json);
	}
	
}
