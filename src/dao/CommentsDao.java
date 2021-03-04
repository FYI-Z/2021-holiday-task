package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entity.Comments;
import util.DBUtil;
import util.SQLConstant;

/*
 * description: 
 * author: 李章
 * time: 2021.02.28
 * the name of the class: CommentsDao 
 * */
public class CommentsDao {
	static int sum = 0;
	PreparedStatement st = null;
	ResultSet rs = null;
	//将现有评论存入List		
	public List<Comments> AllComments(){
		List<Comments> list = new ArrayList<>();
		String sql = SQLConstant.Select_Comments;
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeQuery();
			while(rs.next()) {
				sum++;
				Comments comments = new Comments();
				comments.setCommentsid(rs.getString("commentsid"));
				comments.setGoodsid(rs.getString("goodsid"));
				comments.setUserid(rs.getString("userid"));
				comments.setComments(rs.getString("comments"));
				comments.setTime(rs.getString("time"));
				list.add(comments);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//返回评论总数
	public int getCommentsSum() {
		return sum;
	}
	//修改评论
	public int EditComments(String commentsid, String time, String comments) {
		int rs = -1;
		PreparedStatement st = null;
		String sql = SQLConstant.Update_Comments + " " + "set time='"+time+"',comments='"+comments+"' where commentsid='"+commentsid+"';";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//添加评论
	public int AddComments(String goodsid, String userid, String comments) {
		//获取当前时间
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String time = formatter.format(date);	
		String sql = SQLConstant.Insert_Comments + " " +"value(null,'"+goodsid+"', '"+userid+"', '"+comments+"', '"+time+"')";
		st = DBUtil.getPreparedStatement(sql);
		int count = 0;
		try {
			count = st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	//删除评论
	public int DelteComments(String[] list) {
		int count = 0;
		for(String string : list) {
			String sql = SQLConstant.Delete_Comments + " " + "where commentsid = '"+string+"';";
			st = DBUtil.getPreparedStatement(sql);
			try {
				count = count + st.executeUpdate(sql);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	public List<Comments> SearchKey(String keyword, String searchtype) {
		List<Comments> list = new ArrayList<>();
		String sql = SQLConstant.Select_Comments + " " + "where "+searchtype+" like '%"+keyword+"%' ";
		try {
			st = DBUtil.getPreparedStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				sum++;
				Comments comments = new Comments();
				comments.setCommentsid(rs.getString("commentsid"));
				comments.setGoodsid(rs.getString("goodsid"));
				comments.setUserid(rs.getString("userid"));
				comments.setComments(rs.getString("comments"));
				comments.setTime(rs.getString("time"));
				list.add(comments);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
