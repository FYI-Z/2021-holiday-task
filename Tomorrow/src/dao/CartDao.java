package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import entity.CartItem;
import entity.Goods;
import entity.PayLog;
import util.Constant;
import util.DBUtil;
import util.SQLConstant;


/** 
* @author miku
* name：购物车dao层
* @version v0.0.1
* @date 2021年3月3日 下午11:01:40 
*/

public class CartDao {
	PreparedStatement stmt = null;
	ResultSet results = null;
	String sql = null;
	
	public Goods detail(String goodsid) {
		sql = SQLConstant.select_Goods+"where goodsid="+goodsid;
		Goods goods = new Goods();
		
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			results = stmt.executeQuery();
			while(results.next()) {
				goods.setGoodsid(results.getInt("goodsid"));
				goods.setName(results.getString("name"));
				goods.setPrice(results.getDouble("price"));
				goods.setInstructions(results.getString("instructions"));
				goods.setPicture(results.getString("picture"));
				goods.setType(results.getString("type"));
				goods.setInventory(results.getInt("inventory"));
				goods.setSales(results.getInt("sales"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}
	public List<CartItem> listCart(String userid) {
		sql = SQLConstant.select_Double+userid+"'";
		List<CartItem>list = new ArrayList<CartItem>();
		
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			results = stmt.executeQuery();
			while(results.next()) {
				CartItem cart = new CartItem();
				cart.setSn(results.getString("sn"));
				cart.setUserid(results.getString("userid"));
				cart.setNumber(results.getInt("number"));
				cart.setSubtotal(results.getDouble("total_price"));
				cart.setName(results.getString("name"));
				cart.setPicture(results.getString("picture"));
				list.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int save(CartItem oItem) {
		
		CartItem item = findByGoodsid(oItem.getGoodsid());
		if(item==null) {
			sql = SQLConstant.Insert_ShopCart+item.getSn()+"','"+item.getUserid()+"','"+item.getGoodsid()+"',"+item.getNumber()+","+item.getSubtotal()+")";
		}
		else {
			int updateByGoodsid = updateByGoodsid(oItem, item);
			return updateByGoodsid;
		}
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			int res = stmt.executeUpdate();
			if(res>0) {
				return res;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public CartItem findByGoodsid(String goodsid) { 
		sql = SQLConstant.select_ShopCart+goodsid;
		CartItem item = new CartItem();
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			results = stmt.executeQuery();
			while(results.next()) {
				item.setNumber(results.getInt("number"));
				item.setSubtotal(results.getDouble("total_price"));
			}
			} catch (Exception e) {
		}
		return item;
	}
	
	public int updateByGoodsid(CartItem item,CartItem oItem) {
		double price = item.getSubtotal()+oItem.getSubtotal();
		int number=item.getNumber()+oItem.getNumber();
		sql = SQLConstant.Update_ShopCart+" total_price="+price+",number="+number+" where goodsid="+item.getGoodsid();
		
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			int res = stmt.executeUpdate();
			if(res>0) {
				return res;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
