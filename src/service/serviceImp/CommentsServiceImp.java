package service.serviceImp;

import java.util.List;

import dao.CommentsDao;
import entity.Comments;
import service.CommentsService;

/*
 * description: 对评论管理的操作进行逻辑处理
 * author: 李章
 * time: 2021.02.27
 * the name of the class: CommentsServiceImp
 * */
public class CommentsServiceImp implements CommentsService {
	CommentsDao commentsDao = new CommentsDao();
	static int sum = 0;
	//返回现有所有评论
	public List<Comments> AllComments(){
		sum = commentsDao.getCommentsSum();
		return commentsDao.AllComments();
	}
	
	public int getCommentsSum() {
		return sum;
	}
	//返回修改评论操作信息
	public String EditComments(String commentsid, String time, String comments) {
		int count = commentsDao.EditComments(commentsid, time, comments);
		if(count != -1) {
			return "修改成功！";
		}
		return "修改失败！";
	}
	//返回添加评论操作信息
	public String AddComments(String goodsid, String userid, String comments) {
		//判断有没有这个商品id
		/*if() {
			
		}
		else*/ if(commentsDao.AddComments(goodsid, userid,comments) != 0) {
			return "评论添加成功！";
		}
		else {
			return "评论添加失败！";
		}
	}
	//返回删除评论操作信息
	public String DeleteComments(String[] list) {
		if(commentsDao.DelteComments(list) != 0) {
			return "评论删除成功！";
		}
		else {
			return "评论删除失败！";
		}
	}

	public List<Comments> SearchKey(String keyword, String searchtype) {
		return commentsDao.SearchKey(keyword, searchtype);
	}


}
