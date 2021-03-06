package util;

/*
 * description: 对数据库操作的语句
 * author: 三人小组
 * time: 2021.02.26
 * the name of the class: SQLConstant
 * */

public class SQLConstant {
	public static String Insert_Comments = "insert into comments";
	public static String Delete_Comments = "delete from comments";
	public static String Select_Comments = "select * from comments";
	public static String Update_Comments = "update comments";
	public static String Select_Goods = "select * from goods";
	public static String Insert_Order = "insert into orders";
	public static String Delete_Order = "delete from orders";
	public static String Select_Order = "select * from orders";
	public static String Update_Order = "update orders";
	public static String Find_GoodsComprehensive="SELECT * FROM goods WHERE name LIKE ? AND type LIKE ?;  ";
	public static String Insert_Usertable="insert into user VALUES ";
	public static String Find_Usertable="SELECT * FROM user WHERE ";
	public static String Find_AllUsertable="SELECT * FROM user ";
	public static String Insert_Token="insert into token VALUE ";
	public static String Find_Token="SELECT * FROM token WHERE ";
	public static String Update_Token="UPDATE token SET ";
	public static String Delete_Usertable="DELETE FROM `user` WHERE userid = ? ";
	public static String Update_Usertable="UPDATE user SET password=? ,nickname = ?, sex = ? , age = ? , phone =? ,permission = ? , email =? WHERE userid = ?;";
	public static String Insert_Goods="INSERT INTO goods VALUES (null,?,?,?,?,?,?,0,?);";
	public static String Delete_Goods="DELETE FROM goods WHERE  goodsid = ?; ";
	public static String Updata_Goods= "UPDATE goods SET name=? ,price=?, instructions=?,picture=?, type=?, inventory=?,sales=?,brand=?  WHERE goodsid = ?;";
	public static String Find_GoodsId="SELECT * FROM goods WHERE goodsid LIKE ?  ";
	public static String Find_GoodsName="SELECT * FROM goods WHERE name LIKE ?";
	public static String show_Goods="SELECT * FROM goods";
	public static String Inser_Address="INSERT INTO address VALUES (NULL,?,?,?,?);";
	public static String Delete_Address="DELETE  FROM address WHERE addressid = ?;";
	public static String Find_Address="SELECT * FROM address WHERE userid = ?;";
	public static String Undata_Address="UPDATE address SET userid=? ,name=?,phone=?,address=?  WHERE addressid = ?;";
	public static String Show_Address="SELECT * FROM address";
	
	
	public static String lifeCycle = "1800";
	public static String Select_PayLog = "select *from paylog ";
	public static String Insert_PayLog = "insert into paylog value(";
	public static String Update_PayLog = "update paylog set ";
	public static String delete_PayLog = "delete from paylog where ";
	public static String select_Goods = "select *from goods ";
	public static String select_ShopCart = "select *from shoppingcart where goodsid=";
	public static String select_Double = "SELECT * from shoppingcart, goods where shoppingcart.goodsid=goods.goodsid AND shoppingcart.userid='";
	public static String Insert_ShopCart = "insert into shoppingcart value('";
	public static String Update_ShopCart = "update shoppingcart set";
	
	public final static int pay_status_wait = 0;
	public final static int pay_status_paid = 1;
	public final static int pay_status_refunded = 2;
	public final static int pay_status_close = 3;
	
}
