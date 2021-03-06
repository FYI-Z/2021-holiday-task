package entity;

/** 
* @author miku
* name：购物车实体类
* @version v0.0.1
* @date 2021年3月3日 下午11:01:40 
*/

public class CartItem {
	//goods
	private Goods goods;
	//total_price
	private Double subtotal;
	//count
	private Integer number;
	//cartid
	private String sn;
	//userid
	private String userid;
	//goodsid
	private String goodsid;
	private String name;
	private String picture;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public CartItem(Goods goods, Integer number) {
		super();
		this.goods = goods;
		this.number = number;
	}
	public CartItem() {
		super();
	}
}
