package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import entity.PayLog;
import pay.alipay.Alipay;
import service.PayLogService;
import service.serviceImp.PayLogServiceImp;
import util.Constant;
import util.SQLConstant;
import util.StringUtil;

/** 
* @author miku
* name：支付管理控制器
* @version v0.0.1
* @date 2021年3月3日 下午11:01:40 
*/

public class PayLogController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("appication/json;Charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String pageStatus = request.getParameter("pageStatus");
		String userid = request.getParameter("userid");
		String sn = request.getParameter("sn");
		
		PayLogServiceImp payLogService = new PayLogServiceImp();
		 if("add".equalsIgnoreCase(pageStatus)) {
			add(request, response,payLogService);
		}
		 else if("del".equalsIgnoreCase(pageStatus)) {
			 del(request, response,payLogService,sn);
		 }
		 else if("list".equalsIgnoreCase(pageStatus)){
			 list(request,response,payLogService,userid);
		 }
		 else if("view".equalsIgnoreCase(pageStatus)) {
			 view(request,response,payLogService,sn);
		 }
		 else if("close".equalsIgnoreCase(pageStatus)) {
			String msg =  close(request,response,payLogService,sn);
			PrintWriter out;
			try {
				out = response.getWriter();
				out .print(msg);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		doGet(request, response);
	}
	/** 
	* @author miku
	* name：关闭支付订单
	* @version v0.0.1
	* @date 2021年3月3日 下午11:01:40 
	*/
	
	private String close(HttpServletRequest request, HttpServletResponse response,PayLogServiceImp payLogService,String sn) {
		PayLog payLog = payLogService.findBySn(sn);
		payLog.setStatus(SQLConstant.pay_status_close);
		payLogService.update(payLog,"close");
		return "sucess";
	}


	/** 
	* @author miku
	* name：查看支付订单
	* @version v0.0.1
	* @date 2021年3月3日 下午11:01:40 
	*/
	private void view(HttpServletRequest request, HttpServletResponse response, PayLogServiceImp payLogService,String sn) {
		try {
			PrintWriter out = response.getWriter();
			List<PayLog> list = new ArrayList<PayLog>();
			list.add(payLogService.findBySn(sn));
			String jsonArray = JSON.toJSONString(list);
			out.print(jsonArray);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/** 
	* @author miku
	* name：删除支付订单
	* @version v0.0.1
	* @date 2021年3月3日 下午11:01:40 
	*/
	private void del(HttpServletRequest request, HttpServletResponse response, PayLogServiceImp payLogService,String sn) {
		payLogService.del(sn);
		
	}

	/** 
	* @author miku
	* name:添加订单
	* @version v0.0.1
	* @date 2021年3月1日 上午8:48:40 
	*/
	public void add(HttpServletRequest request, HttpServletResponse response, PayLogServiceImp payLogService) {
		PayLog payLog = new PayLog();
		String userId = request.getParameter("userId");
		String title = request.getParameter("title");
		String totalAmount = request.getParameter("totalAmount");
		String info = request.getParameter("info");
		
		payLog.setUserId(userId);
		payLog.setSn(StringUtil.generateSn("cywl", ""));
		payLog.setInfo(info);
		payLog.setTotalAmount(totalAmount);
		payLog.setTitle(title);
		
		try {
			PrintWriter out = response.getWriter();
			payLogService.save(payLog);
			Map<String, String> map = new HashMap<String, String>();
			map.put("sn", payLog.getSn());
			String jsonArray = JSON.toJSONString(map);
			out.write(jsonArray);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/** 
	* @author miku
	* name：遍历所有支付记录
	* @version v0.0.1
	* @date 2021年3月3日 下午11:01:40 
	*/
	public void list(HttpServletRequest request, HttpServletResponse response, PayLogServiceImp payLogService,String userid) {
		try {
			PrintWriter out = response.getWriter();
			List<PayLog> list = payLogService.list(null);
			String jsonArray = JSON.toJSONString(list);
			out.print(jsonArray);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
