package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Constant;

/*
 * description: 对评论管理操作的处理
 * author: 李章
 * time: 2021.02.27
 * the name of the class: CommentsHandler
 * */
public class CommentsHandler extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			doPost(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			response.setContentType(Constant.ContentType);
			CommentsController commentsController = new CommentsController();
			String method = request.getParameter("method");
			if(method.equals("getAll")) {
				commentsController.PrintComments(request, response);
			}else if(method.equals("add")) {
				commentsController.AddComments(request, response);
			}else if(method.equals("del")) {
				commentsController.DeleteComments(request, response);
			}
			else if(method.equals("edit")) {
				commentsController.EditComments(request, response);
			}else if(method.equals("searchKey")) {
				commentsController.SearchKey(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
