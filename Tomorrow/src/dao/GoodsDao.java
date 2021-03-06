package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Goods;
import util.*;
public class GoodsDao {
	private static PreparedStatement st = null;
	private static ResultSet rs = null;
	String sql = "";
	int count = 0;
	public static int Number = 0;
	
	public ArrayList<Goods> findGoodsCom(Goods goods){
		ArrayList<Goods> list = new ArrayList<Goods>();
		sql=SQLConstant.Find_GoodsComprehensive;
		String name = "%"+goods.getName()+"%";
		String type = "%"+goods.getType()+"%";	
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setString(1, name);
			st.setString(2, type);
			rs=st.executeQuery();
			while(rs.next()) {
				goods = new Goods();
				goods.setGoodsid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setInstructions(rs.getString("instructions"));
				goods.setPicture(rs.getString("picture"));
				goods.setType(rs.getString("type"));
				goods.setInventory(rs.getInt("inventory"));
				goods.setSales(rs.getInt("sales"));
				goods.setBrand(rs.getString("brand"));
				list.add(goods);
			}
			rs.close();
			st.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public ArrayList<Goods> showGoods(Goods goods){
		ArrayList<Goods> list = new ArrayList<Goods>();
		sql=SQLConstant.show_Goods;
		try {
			st=DBUtil.getPreparedStatement(sql);
			rs=st.executeQuery();
			Number=0;
			while(rs.next()) {
				goods = new Goods();
				goods.setGoodsid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setInstructions(rs.getString("instructions"));
				goods.setPicture(rs.getString("picture"));
				goods.setType(rs.getString("type"));
				goods.setInventory(rs.getInt("inventory"));
				goods.setSales(rs.getInt("sales"));
				goods.setBrand(rs.getString("brand"));
				Number++;
				list.add(goods);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Goods> findGoodsName(Goods goods){
		ArrayList<Goods> list = new ArrayList<Goods>();
		sql=SQLConstant.Find_GoodsName;
		String name = "%"+goods.getName()+"%";
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setString(1, name);
			rs=st.executeQuery();
			while(rs.next()) {
				goods = new Goods();
				goods.setGoodsid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setInstructions(rs.getString("instructions"));
				goods.setPicture(rs.getString("picture"));
				goods.setType(rs.getString("type"));
				goods.setInventory(rs.getInt("inventory"));
				goods.setSales(rs.getInt("sales"));
				goods.setBrand(rs.getString("brand"));
				list.add(goods);
			}
			rs.close();
			st.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Goods> findGoodsId(Goods goods){
		ArrayList<Goods> list = new ArrayList<Goods>();
		sql=SQLConstant.Find_GoodsId;
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setInt(1, goods.getGoodsid());
			rs=st.executeQuery();
			while(rs.next()) {
				goods = new Goods();
				goods.setGoodsid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setInstructions(rs.getString("instructions"));
				goods.setPicture(rs.getString("picture"));
				goods.setType(rs.getString("type"));
				goods.setInventory(rs.getInt("inventory"));
				goods.setSales(rs.getInt("sales"));
				goods.setBrand(rs.getString("brand"));
				list.add(goods);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public Goods updataGoods(Goods goods) {
		sql=SQLConstant.Updata_Goods;
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setString(1, goods.getName());
			st.setDouble(2, goods.getPrice());
			st.setString(3, goods.getInstructions());
			st.setString(4, goods.getPicture());
			st.setString(5, goods.getType());
			st.setInt(6, goods.getInventory());
			st.setInt(7, goods.getSales());
			st.setString(8, goods.getBrand());
			st.setInt(9, goods.getGoodsid());
			count=st.executeUpdate();
			if(count>0) {
				goods.setGoodstatus("修改成功");
			}
			else {
				goods.setGoodstatus("修改失败");
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			goods.setGoodstatus("修改失败");
		}
		return goods;
	}
	
	public Goods deleteGoods(Goods goods) {
		sql= SQLConstant.Delete_Goods;
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setInt(1, goods.getGoodsid());
			count=st.executeUpdate();
			if(count>0) {
				System.out.println("删除成功");
				goods.setGoodstatus("删除成功");
			}
			else {
				System.out.println("删除失败");
				goods.setGoodstatus("删除失败");
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;
	}
	public Goods addGoods(Goods goods) {
		sql=SQLConstant.Insert_Goods;
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setString(1, goods.getName());
			st.setDouble(2, goods.getPrice());
			st.setString(3, goods.getInstructions());
			st.setString(4, goods.getPicture());
			st.setString(5, goods.getType());
			st.setInt(6, goods.getInventory());
			st.setString(7, goods.getBrand());
			count=st.executeUpdate();
			if (count>0) {
				System.out.println("增加成功");
			}
			else {
				System.out.println("增加失败");
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;
	}
}
