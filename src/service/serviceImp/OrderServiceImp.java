package service.serviceImp;

import java.util.List;

import dao.OrderDao;
import entity.Order;
import service.OrderService;

/*
 * description: 对订单管理的操作进行逻辑处理
 * author: 李章
 * time: 2021.03.01
 * the name of the class: OrderServiceImp
 * */
public class OrderServiceImp implements OrderService {
	OrderDao orderDao = new OrderDao();
	static int sum = 0;
	//返回现有所有订单
	public List<Order> AllOrder() {
		sum = orderDao.getOrderSum();
		return orderDao.AllOrder();
	}
	//返回添加订单操作信息
	public String AddOrder(String goodsid, String nickname, String name, Double total_price, String address, String number, String state) {
		//判断有没有这个商品id
				/*if() {
					
				}
				else*/ if(orderDao.AddOrder(goodsid, nickname, name, total_price, address, number, state) != 0) {
					return "订单添加成功！";
				}
				else {
					return "订单添加失败！";
				}
	}
	//返回删除订单操作信息
	public String DeleteOrder(String[] list) {
		if(orderDao.DelteOrder(list) != 0) {
			return "订单删除成功！";
		}
		else {
			return "订单删除失败！";
		}
		
	}
	//返回修改订单操作信息
	public String EditOrder(String orderid, String goodsid, String nickname, String name, Double total_price, String address, String number, String state) {
		int count = orderDao.EditOrder(orderid, goodsid, nickname, name, total_price, address, number, state);
		if(count != -1) {
			return "修改成功！";
		}
		else {
			return "修改失败！";
		}
	}
	//返回订单状态改变信息
	public Object ChangeOrderState(String orderid, String state) {
		int count = orderDao.ChangeOrderState(orderid, state);
		if(count != -1) {
			return "修改成功！";
		}
		else {
			return "修改失败！";
		}
	}
	public List<Order> SearchKey(String keyword, String searchtype) {
		return orderDao.SearchKey(keyword, searchtype);
	}

	

}
