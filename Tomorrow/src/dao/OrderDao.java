package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entity.Order;
import util.DBUtil;
import util.SQLConstant;

/*
 * description: 订单管理数据库操作
 * author: 李章
 * time: 2021.03.02
 * the name of the class: OrderDao 
 * */
public class OrderDao {
	static int sum = 0;
	PreparedStatement st = null;
	ResultSet rs = null;
	//将现有订单存入List
	public List<Order> AllOrder() {
		List<Order> list = new ArrayList<>();
		String sql = SQLConstant.Select_Order;
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeQuery();
			while(rs.next()) {
				sum++;
				Order order = new Order();
				order.setOrderid(rs.getString("orderid"));
				order.setGoodsid(rs.getString("goodsid"));
				order.setNickname(rs.getString("nickname"));
				order.setName(rs.getString("name"));
				order.setTotal_price(rs.getString("total_price"));
				order.setTime(rs.getString("time"));
				order.setAddress(rs.getString("address"));
				order.setNumber(rs.getString("number"));
				order.setState(rs.getString("state"));
				list.add(order);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getOrderSum() {
		return sum;
	}
	//添加订单
	public int AddOrder(String goodsid, String nickname, String name, Double total_price, String address, String number, String state) {
		//获取当前时间
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String time = formatter.format(date);
		String sql = SQLConstant.Insert_Order + " " +"value(null,'"+goodsid+"', '"+nickname+"', '"+name+"', '"+total_price+"', '"+time+"', '"+address+"', '"+number+"', '"+state+"')";
		st = DBUtil.getPreparedStatement(sql);
		int count = 0;
		try {
			count = st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	//删除订单
	public int DelteOrder(String[] list) {
		int count = 0;
		for(String string : list) {
			String sql = SQLConstant.Delete_Order + " " + "where orderid = '"+string+"';";
			st = DBUtil.getPreparedStatement(sql);
			try {
				count = count + st.executeUpdate(sql);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	//修改订单
	public int EditOrder(String orderid, String goodsid, String nickname, String name, Double total_price, String address,
			String number, String state) {
		int rs = -1;
		PreparedStatement st = null;
		String sql = SQLConstant.Update_Order + " " + "set goodsid='"+goodsid+"', nickname='"+nickname+"', name='"+name+"', total_price='"+total_price+"',"
				+ "address='"+address+"', number= '"+number+"', state='"+state+"' where orderid='"+orderid+"';";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public int ChangeOrderState(String orderid, String state) {
		int rs = -1;
		PreparedStatement st = null;
		String sql = SQLConstant.Update_Order + " " + "set state='"+state+"' where orderid='"+orderid+"';";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public List<Order> SearchKey(String keyword, String searchtype) {
		List<Order> list = new ArrayList<>();
		String sql = SQLConstant.Select_Order + " " + "where "+searchtype+" like '%"+keyword+"%' ";
		try {
			st = DBUtil.getPreparedStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				sum++;
				Order order = new Order();
				order.setOrderid(rs.getString("orderid"));
				order.setGoodsid(rs.getString("goodsid"));
				order.setNickname(rs.getString("nickname"));
				order.setName(rs.getString("name"));
				order.setTotal_price(rs.getString("total_price"));
				order.setTime(rs.getString("time"));
				order.setAddress(rs.getString("address"));
				order.setNumber(rs.getString("number"));
				order.setState(rs.getString("state"));
				list.add(order);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
