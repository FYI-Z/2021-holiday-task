package entity;

/*
 * description: 评论的实体类
 * author: 李章
 * time: 2021.02.26
 * the name of the class: Comment
 * */
public class Comments {
	private String commentsid;
	private String goodsid;
	private String userid;
	private String comments;
	private String time;
	
	public String getCommentsid() {
		return commentsid;
	}
	public void setCommentsid(String commentsid) {
		this.commentsid = commentsid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
