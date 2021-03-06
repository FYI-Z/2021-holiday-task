package pay.alipay;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import entity.PayLog;
import config.AlipayConfig;
import service.serviceImp.PayLogServiceImp;
import util.Constant;

/** 
* @author miku
* name：支付宝请求支付
* @version v0.0.1
* @date 2021年3月3日 下午11:01:40 
*/

public class Alipay {
	
	
	
	
	public static void alipay(HttpServletRequest request, HttpServletResponse response, String sn) {
		
				PayLogServiceImp payLogServiceImp = new PayLogServiceImp();
				PayLog payLog = payLogServiceImp.findBySn(sn);
				int totalAmount = Integer.valueOf(payLog.getTotalAmount());
				
        //获得初始化的AlipayClient
                AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

                //设置请求参数
                AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
                alipayRequest.setReturnUrl(AlipayConfig.return_url);
                alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
                
                HashMap<String, String> param = new HashMap<String,String>();
        		//商户订单号，商户网站订单系统中唯一订单号，必填
        		param.put("out_trade_no", payLog.getSn());
        		//付款金额，必填
        		param.put("total_amount", payLog.getTotalAmount());
        		//订单名称，必填
        		param.put("subject", payLog.getTitle());
        		//商品描述，可空
        		param.put("body", payLog.getInfo());
        		
        		param.put("product_code", "FAST_INSTANT_TRADE_PAY");
        		
        		alipayRequest.setBizContent(JSONObject.toJSONString(param));
        		
        		String html = null;
	       		 try {
	       			 //请求
	       			html = alipayClient.pageExecute(alipayRequest).getBody();
	       			response.setContentType("text/html;charset=" + AlipayConfig.charset);
					response.getWriter().write(html);//直接将完整的表单html输出到页面
					response.getWriter().flush();
					response.getWriter().close();
	       		} catch (Exception e) {
	       			e.printStackTrace();
	       		}
	}
	
	  public static boolean checkSign(HttpServletRequest request) {
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
				//乱码解决，这段代码在出现乱码时使用
				params.put(name, valueStr);
			}
			
			try {
				return AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
			} catch (AlipayApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //调用SDK验证签名
			return false;

	  }
	  
	  
	  
}
