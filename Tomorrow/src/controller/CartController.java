package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import service.serviceImp.PayLogServiceImp;

import util.StringUtil;

import service.serviceImp.CartServiceImp;

import entity.CartItem;
import entity.Goods;
import entity.PayLog;



/** 
* @author miku
* name：购物车控制器
* @version v0.0.1
* @date 2021年3月3日 下午11:01:40 
*/
public class CartController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		response.setContentType("appication/json;Charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String status = request.getParameter("status");
	    String userid = request.getParameter("userid");
	    String goodsid = String.valueOf(request.getParameter("goodsid"));
		CartServiceImp cartServiceImp = new CartServiceImp();
		if("detail".equalsIgnoreCase(status)) {
			detailGood(request,response,cartServiceImp,goodsid);
		}
		else if("add".equalsIgnoreCase(status)) {
			if("-1".equalsIgnoreCase(goodsid)) {
				list(request,response,cartServiceImp,userid);
			}else {
				save(request,response,cartServiceImp,userid,goodsid);
				list(request,response,cartServiceImp,userid);
			}
		}
	}
	/** 
	* @author miku
	* name：遍历购物车
	* @version v0.0.1
	* @date 2021年3月3日 下午11:01:40 
	*/
	private void list(HttpServletRequest request, HttpServletResponse response, CartServiceImp cartServiceImp,String userid) {
		response.setContentType("appication/json;Charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			List<CartItem> list = cartServiceImp.list(userid);
			String json = JSON.toJSONString(list);
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** 
	* @author miku
	* name：保存信息
	* @version v0.0.1
	* @date 2021年3月3日 下午11:01:40 
	*/
	private void save(HttpServletRequest request, HttpServletResponse response, CartServiceImp cartServiceImp,String userid,String goodsid) {
		CartItem item = new CartItem();
		 int number = Integer.valueOf(request.getParameter("number"));
		 double price= Double.valueOf(request.getParameter("price"));

		 double totalAmount = price*number;
		 String title = request.getParameter("title");
		 String sn = StringUtil.generateSn("cywl", "");
		item.setUserid(userid);
		item.setNumber(number);
		item.setGoodsid(goodsid);
		item.setSubtotal(totalAmount);
		item.setSn(sn);
		cartServiceImp.save(item);
		
		PayLog payLog = new PayLog();
		payLog.setUserId(userid);
		payLog.setSn(sn);
		payLog.setTotalAmount(""+totalAmount);
		payLog.setTitle(title);
		PayLogServiceImp payLogServiceImp = new PayLogServiceImp();
		payLogServiceImp.save(payLog);
	}

	/** 
	* @author miku
	* name：商品详细信息
	* @version v0.0.1
	* @date 2021年3月3日 下午11:01:40 
	*/
	private void detailGood(HttpServletRequest request, HttpServletResponse response,CartServiceImp cartServiceImp,String goodsid) {
		try {
			PrintWriter out = response.getWriter();
			List<Goods> list = new ArrayList<Goods>();
			list.add(cartServiceImp.detail(goodsid));
			String json = JSON.toJSONString(list);
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
