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

import dao.GoodsDao;
import entity.Goods;
import service.serviceImp.GoodsServiceImp;
import util.Constant;


public class GoodsController extends HttpServlet {
	String json = "";
	Goods goods = new Goods();
	GoodsServiceImp goodsServiceImp = new GoodsServiceImp();
	GoodsDao goodsDao = new GoodsDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String flag = request.getParameter("flag");
		Constant.Base(request, response);
		if(flag.equals("addgoods")) {
			addGoods(request, response);
		}
		else if (flag.equals("deletegood")) {
			deleteGoods(request, response);
		}
		else if (flag.equals("updatagoods")) {
			updataGoods(request, response);
		}
		else if (flag.equals("findgoodsId")) {
			findGoodsId(request, response);
		}
		else if (flag.equals("findgoodsName")) {
			findGoodsName(request, response);
		}
		else if (flag.equals("showGoods")) {
			showGoods(request, response);
		}
	}
	
	protected void showGoods(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Goods> list = goodsServiceImp.showGoods();
		Map map = new HashMap();
		map.put("code", "0");
		map.put("msg", "");
		map.put("count", GoodsDao.Number);
		map.put("data",list);
		json = JSON.toJSONString(map);
		Constant.out.print(json);
	}
	
	protected void addGoods(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("name"),
		instructions = request.getParameter("instructions"),
		type = request.getParameter("type"),
		picture = request.getParameter("picture"),
		brand = request.getParameter("brand");
		double price = Double.valueOf(request.getParameter("price"));
		int inventory = Integer.valueOf(request.getParameter("inventory"));
		
		goods = goodsServiceImp.addGoods(name, price, instructions, type, inventory, brand,picture);
		json = JSON.toJSONString(goods);
		Constant.out.write(json);
	}
	
	protected void deleteGoods(HttpServletRequest request, HttpServletResponse response) {
		int goodsid =Integer.valueOf(request.getParameter("goodsid"));
		goods=goodsServiceImp.deleteGoods(goodsid);
		json=JSON.toJSONString(goods.getGoodstatus());
		Constant.out.print(json);
	}
	
	protected void updataGoods(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("name"),
		picture=request.getParameter("picture"),
		instructions=request.getParameter("instructions"),
		type=request.getParameter("type"),
		brand=request.getParameter("brand");
		double price=Double.valueOf(request.getParameter("price"));
		int inventory=Integer.valueOf(request.getParameter("inventory")),
		sales=Integer.valueOf(request.getParameter("sales")),
		goodsid =Integer.valueOf(request.getParameter("goodsid"));
		goods=goodsServiceImp.updateGoods(name, price, instructions, picture, type, inventory, sales, brand, goodsid);
		json=JSON.toJSONString(goods);
		Constant.out.print(json);
	}
	
	protected void findGoodsName(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		
		ArrayList<Goods> list = goodsServiceImp.findGoodsName(name);
		Map map = new HashMap();
		map.put("code", "0");
		map.put("msg", "");
		map.put("count", GoodsDao.Number);
		map.put("data",list);
		json = JSON.toJSONString(map);
		Constant.out.print(json);
	}
	
	protected void findGoodsId(HttpServletRequest request, HttpServletResponse response) {
		int goodsid = Integer.valueOf(request.getParameter("goodsid"));
		ArrayList<Goods> list = goodsServiceImp.findGoodsId(goodsid);
		Map map = new HashMap();
		map.put("code", "0");
		map.put("msg", "");
		map.put("count", GoodsDao.Number);
		map.put("data",list);
		json = JSON.toJSONString(map);
		Constant.out.print(json);
	}
}
