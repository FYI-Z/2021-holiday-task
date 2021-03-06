package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import entity.PayLog;
import config.AlipayConfig;
import pay.alipay.Alipay;
import service.serviceImp.PayLogServiceImp;
import util.Constant;
import util.SQLConstant;
import util.StringUtil;

/** 
* @author miku
* name：支付宝支付控制类
* @version v0.0.1
* @date 2021年3月3日 下午11:01:40 
*/

public class PayController extends HttpServlet {
	


	public void doPost(HttpServletRequest request, HttpServletResponse response)  {
		try {
			doGet(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		String pageStatus = request.getParameter("pageStatus");
		String sn = request.getParameter("sn");
		if("toPay".equalsIgnoreCase(pageStatus)) {
			System.out.println("进入topay支付页面");
			Alipay.alipay(request,response,sn);
			
		}else {
			System.out.println("进入notify支付页面");
			notify(request,response);
		}
		
	}	
	/** 
	* @author miku
	* name：支付成功时的通知函数
	* @version v0.0.1
	* @date 2021年3月3日 下午11:01:40 
	*/
	
	public static  void notify(HttpServletRequest request,HttpServletResponse response) {
		PrintWriter out = null;
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today=simpleDateFormat.format(new Date());
		PayLogServiceImp payLogServiceImp = new PayLogServiceImp();
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}
		
		boolean signVerified = false;
		try {
			signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		} //调用SDK验证签名

		String status = null;
		String sn = null;
		String pay_sn = null;
		if(signVerified) {//验证成功
			//商户订单号
			try {
				 sn = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
				 pay_sn = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
				 status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
				} catch (Exception e) {
				e.printStackTrace();
			}
			PayLog payLog = payLogServiceImp.findBySn(sn);
			//交易状态
			if(status.equals("TRADE_FINISHED")){
				payLog.setSn(sn);
				payLog.setPay_sn(pay_sn);
				payLog.setStatus(SQLConstant.pay_status_paid);
				payLog.setPayTime(today);
				payLogServiceImp.update(payLog,null);
			}else if (status.equals("TRADE_SUCCESS")){
				payLog.setSn(sn);
				payLog.setPay_sn(pay_sn);
				payLog.setStatus(SQLConstant.pay_status_paid);
				payLog.setPayTime(today);
				payLogServiceImp.update(payLog,null);
			}
			out.println("success");
			
		}else {//验证失败
			out.println("fail");
		}
	}
  
  
}
