package service.serviceImp;

import java.util.List;

import entity.CartItem;
import entity.Goods;
import dao.CartDao;
import service.CartService;

/** 
* @author miku
* name：购物车service层
* @version v0.0.1
* @date 2021年3月3日 下午11:01:40 
*/

public class CartServiceImp implements CartService{
	CartDao cartDao = new CartDao();
	
	public Goods detail(String goodsid) {
		return cartDao.detail(goodsid);
	}
	public int save(CartItem item) {
		return cartDao.save(item);
	}
	public List<CartItem> list(String userid) {
		return cartDao.listCart(userid);
	}
}
