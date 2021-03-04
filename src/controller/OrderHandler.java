package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Constant;

/*
 * description: 对订单管理操作的处理
 * author: 李章
 * time: 2021.03.01
 * the name of the class: OrderHandler
 * */
public class OrderHandler extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			doPost(request, response);
		}catch(Exception e) {
			System.out.println("OrderHandler中doGet异常！！！");
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			response.setContentType(Constant.ContentType);
			OrderController orderController = new OrderController();
			String method = request.getParameter("method");
			System.out.println(method);
			if(method.equals("getAll")) {
				orderController.PrintOrder(request, response);
			}else if(method.equals("add")) {
				orderController.AddOrder(request, response);
			}else if(method.equals("del")) {
				orderController.DeleteOrder(request, response);
			}
			else if(method.equals("edit")) {
				orderController.EditOrder(request, response);
			}else if(method.equals("changeState")) {
				orderController.ChangeOrderState(request, response);
			}else if(method.equals("searchKey")) {
				orderController.SearchKey(request, response);
			}
		}catch(Exception e) {
			System.out.println("OrderHandler中doPost异常！！！");
			e.printStackTrace();
		}
	}
}
