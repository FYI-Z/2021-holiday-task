package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.Goods;
import service.serviceImp.OrderServiceImp;
import util.Constant;

/*
 * description: 实现订单管理对应的操作
 * author: 李章
 * time: 2021.03.01
 * the name of the class: CommentsController
 * */
public class OrderController {
	OrderServiceImp orderServiceImp = new OrderServiceImp();
	Goods goods = new Goods();
	//显示所有订单
	public void PrintOrder(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			Map<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
			linkedHashMap.put("code", 0);
			linkedHashMap.put("msg", "success");
			linkedHashMap.put("item", orderServiceImp.AllOrder());
			String json = JSON.toJSONString(linkedHashMap);
			out.write(json);	
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//添加订单
	public void AddOrder(HttpServletRequest request, HttpServletResponse response) {
		String goodsid = request.getParameter("goodsid");
		String nickname = request.getParameter("nickname");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String number = request.getParameter("number");
		//计算总价,number*单价
		double total_price = Integer.parseInt(number) * goods.getPrice();
		String state = request.getParameter("state");										//df.format(total_price)控制total_price为两位小数
		String json = JSON.toJSONString(orderServiceImp.AddOrder(goodsid, nickname, name, total_price, address, number, state));
		Constant.JsonToFrontend(json, response); 
	}
	//删除订单
	public void DeleteOrder(HttpServletRequest request, HttpServletResponse response) {
		String[] list = request.getParameterValues("array[]");
		String json = JSON.toJSONString(orderServiceImp.DeleteOrder(list)); 
		Constant.JsonToFrontend(json, response);
		
	}
	//修改订单
	public void EditOrder(HttpServletRequest request, HttpServletResponse response) {
		String orderid = request.getParameter("orderid");
		String goodsid = request.getParameter("goodsid");
		String nickname = request.getParameter("nickname");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String number = request.getParameter("number");
		//计算总价,number*单价
		double total_price = Integer.parseInt(number) * goods.getPrice();
		String state = request.getParameter("state");
		String json = JSON.toJSONString(orderServiceImp.EditOrder(orderid, goodsid, nickname, name, total_price, address, number, state));
		Constant.JsonToFrontend(json, response); 
	}
	public void ChangeOrderState(HttpServletRequest request, HttpServletResponse response) {
		String orderid = request.getParameter("orderid");
		String state = request.getParameter("state");
		String json = JSON.toJSONString(orderServiceImp.ChangeOrderState(orderid, state));
		Constant.JsonToFrontend(json, response); 
	}
	public void SearchKey(HttpServletRequest request, HttpServletResponse response) {
		try {
			String keyword = request.getParameter("keyword");
			String searchtype = request.getParameter("searchtype");
			PrintWriter out = response.getWriter();
			Map<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
			linkedHashMap.put("code", 0);
			linkedHashMap.put("msg", "success");
			linkedHashMap.put("item", orderServiceImp.SearchKey(keyword, searchtype));
			String json = JSON.toJSONString(linkedHashMap);
			out.write(json);	
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
