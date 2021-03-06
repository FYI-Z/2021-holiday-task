package service.serviceImp;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;

import dao.GoodsDao;
import entity.Goods;
import service.GoodsService;
public class GoodsServiceImp implements GoodsService {
	Goods goods = new Goods();
	GoodsDao goodsDao = new GoodsDao();
	
	public ArrayList<Goods> findGoodsCom(String name,String type) {
		goods.setName(name);
		goods.setType(type);
		ArrayList<Goods> list=goodsDao.findGoodsCom(goods);
		return list;
	}
	
	public ArrayList<Goods> showGoods(){
		ArrayList<Goods> list=goodsDao.showGoods(goods);
		System.out.println(JSON.toJSON(list));
		return list;
	}
	
	public ArrayList<Goods> findGoodsName(String name) {
		goods.setName(name);
		ArrayList<Goods> list=goodsDao.findGoodsName(goods);
		return list;
	}
	
	public ArrayList<Goods> findGoodsId(int goodsid) {
		goods.setGoodsid(goodsid);
		ArrayList<Goods> list=goodsDao.findGoodsId(goods);
		return list;
	}
	
	public Goods updateGoods(String name,double price,String instructions,String picture,String type, int inventory,int sales,String brand,int goodsid) {
		goods.setName(name);
		goods.setPrice(price);
		goods.setInstructions(instructions);
		goods.setPicture(picture);
		goods.setType(type);
		goods.setInventory(inventory);
		goods.setSales(sales);
		goods.setBrand(brand);
		goods.setGoodsid(goodsid);
		goods=goodsDao.updataGoods(goods);
		return goods;
	}
	
	public Goods deleteGoods(int goodsid) {
		goods.setGoodsid(goodsid);
		goods=goodsDao.deleteGoods(goods);
		return goods;
	}
	
	public Goods addGoods(String name,double price ,String instructions,String type, int inventory,String brand,String picture) {
		goods.setName(name);
		goods.setPrice(price);
		goods.setInstructions(instructions);
		goods.setType(type);
		goods.setInventory(inventory);
		goods.setPicture(picture);
		goods.setSales(0);
		goods.setBrand(brand);
		goods = goodsDao.addGoods(goods);
		return goods;
	}
}
