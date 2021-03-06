package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import entity.PayLog;
import util.Constant;
import util.DBUtil;
import util.SQLConstant;



/** 
* @author miku
* name：支付记录dao层
* @version v0.0.1
* @date 2021年3月3日 下午11:01:40 
*/

public class PayLogDao {
	
	
	PreparedStatement stmt = null;
	ResultSet results = null;
	String sql = null;
	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String today=simpleDateFormat.format(new Date());
	int flag = 0;
	
	
	public List<PayLog> list(String sn) {
		if(sn!=null) {
			sql+=SQLConstant.Select_PayLog+"where "+sn+"="+sn;
		}
		else {
			sql=SQLConstant.Select_PayLog;
		}
		
		List<PayLog>list = new ArrayList<PayLog>();
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			results = stmt.executeQuery();
			
			//Date today = new Date();
			while(results.next()) {
				PayLog payLog = new PayLog();
				payLog.setUserId(results.getString("userId"));
				payLog.setSn(results.getString("sn"));
				payLog.setPay_sn(results.getString("pay_sn"));
				payLog.setTotalAmount(results.getString("totalAmount"));
				payLog.setTitle(results.getString("title"));
				payLog.setInfo(results.getString("info"));
				payLog.setStatus(results.getInt("status"));
				payLog.setRefundAmount(results.getString("refundAmount"));
				payLog.setRefundInfo(results.getString("refundInfo"));
				payLog.setRefundSn(results.getString("refundSn"));
				payLog.setCreateTime(results.getString("createTime"));
				payLog.setPayTime(results.getString("payTime"));
				list.add(payLog);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	public PayLog findBySn(String sn,String type) {

		PayLog payLog = new PayLog();
		if("paySn".equalsIgnoreCase(type)) {
			sql=SQLConstant.Select_PayLog+"where pay_sn='"+sn+"'";
		}else if("userId".equalsIgnoreCase(type)){
			sql=SQLConstant.Select_PayLog+"where userid='"+sn+"'";
		}else {
			sql=SQLConstant.Select_PayLog+"where sn='"+sn+"'";
		}
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			results = stmt.executeQuery();
			
			
			while(results.next()) {
				payLog.setUserId(results.getString("userid"));
				payLog.setSn(results.getString("sn"));
				payLog.setPay_sn(results.getString("pay_sn"));
				payLog.setTotalAmount(results.getString("totalAmount"));
				payLog.setTitle(results.getString("title"));
				payLog.setInfo(results.getString("info"));
				payLog.setStatus(results.getInt("status"));
				payLog.setRefundAmount(results.getString("refundAmount"));
				payLog.setRefundInfo(results.getString("refundInfo"));
				payLog.setRefundSn(results.getString("refundSn"));
				payLog.setCreateTime(today);
				payLog.setPayTime(results.getString("payTime"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return payLog;
	}
	public PayLog findByPaySn(String paySn) {
		String pay_Sn = "paySn";
		return findBySn(paySn,pay_Sn);
	}
	
	//用户Id查找
	public PayLog findByUserID(String userId) {
		String user_Id = "userId";
		return findBySn(userId,user_Id);
	}
	
	//保存
	public int save(PayLog payLog) {
		
		sql = SQLConstant.Insert_PayLog+"'"+payLog.getUserId()+"','"+
		payLog.getSn()+"','"+payLog.getPay_sn()+"',"+payLog.getTotalAmount()+
		",'"+payLog.getTitle()+"','"+payLog.getInfo()+"',"+0+
		",'"+payLog.getRefundAmount()+"','"+payLog.getRefundInfo()+"','"+
		payLog.getRefundSn()+"','"+today+"','"+payLog.getPayTime()+"')";

		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			int addRow = stmt.executeUpdate();
			if(addRow>=0) {
				flag = addRow;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public int update(PayLog payLog,String type) {	
		String sql = null;
		if(type==null) {
			sql = SQLConstant.Update_PayLog+"status="+payLog.getStatus()+
					",paytime='"+payLog.getPayTime()+"', pay_sn='"+payLog.getPay_sn()+
					"' where sn='"+payLog.getSn()+"'";
		}
		else {
			sql = SQLConstant.Update_PayLog+"status="+payLog.getStatus()+
			" where sn='"+payLog.getSn()+"'";
		}
		
		
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			int addRow = stmt.executeUpdate();
			if(addRow>=0) {
				flag = addRow;
			}
		} catch (Exception e) {
		}
		return flag;
	}
	
	public int del(String sn) {
		sql = SQLConstant.delete_PayLog+"sn='"+sn+"'";
		int addRow = -1;
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			  addRow = stmt.executeUpdate();
		} catch (Exception e) {
		}
		return addRow;
	}
}
