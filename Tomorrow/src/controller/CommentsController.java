package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import service.serviceImp.CommentsServiceImp;
import util.Constant;

/*
 * description: 实现评论管理对应的操作
 * author: 李章
 * time: 2021.02.28
 * the name of the class: CommentsController
 * */
public class CommentsController {
	CommentsServiceImp commentsServiceImp = new CommentsServiceImp();
	//显示所有评论
	public void PrintComments(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			Map<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
			linkedHashMap.put("code", 0);
			linkedHashMap.put("msg", "success");
			linkedHashMap.put("item", commentsServiceImp.AllComments());
			String json = JSON.toJSONString(linkedHashMap);
			out.write(json);	
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//添加评论
	public void AddComments(HttpServletRequest request, HttpServletResponse response) {
		String goodsid = request.getParameter("goodsid");
		String userid = request.getParameter("userid");
		String comments = request.getParameter("comments");
		String json = JSON.toJSONString(commentsServiceImp.AddComments(goodsid, userid, comments));
		Constant.JsonToFrontend(json, response);
	}
	//删除评论
	public void DeleteComments(HttpServletRequest request, HttpServletResponse response) {
		String[] list = request.getParameterValues("array[]");
		String json = JSON.toJSONString(commentsServiceImp.DeleteComments(list)); 
		Constant.JsonToFrontend(json, response);
	}
	//修改评论
	public void EditComments(HttpServletRequest request, HttpServletResponse response) {
		String commentsid = request.getParameter("commentsid");
		String time = request.getParameter("time");
		String comments = request.getParameter("comments");
		String json = JSON.toJSONString(commentsServiceImp.EditComments(commentsid, time, comments)); //转化为json字符串
		Constant.JsonToFrontend(json, response);
	}

	public void SearchKey(HttpServletRequest request, HttpServletResponse response) {
		try {
			String keyword = request.getParameter("keyword");
			String searchtype = request.getParameter("searchtype");
			PrintWriter out = response.getWriter();
			Map<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
			linkedHashMap.put("code", 0);
			linkedHashMap.put("msg", "success");
			linkedHashMap.put("item", commentsServiceImp.SearchKey(keyword, searchtype));
			String json = JSON.toJSONString(linkedHashMap);
			out.write(json);	
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
