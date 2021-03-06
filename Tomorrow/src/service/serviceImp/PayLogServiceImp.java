package service.serviceImp;

import java.util.List;

import entity.PayLog;
import dao.PayLogDao;
import service.PayLogService;

/** 
* @author miku
* name：支付管理service层
* @version v0.0.1
* @date 2021年3月3日 下午11:01:40 
*/

public class PayLogServiceImp implements PayLogService{
	PayLogDao payLogDao = new PayLogDao();	
	
	//编号查找
	public PayLog findBySn(String sn) {
		return payLogDao.findBySn(sn,null);
	}
	public List<PayLog> list(String sn) {
		return payLogDao.list(sn);
	}
	//支付编号
	public PayLog findByPaySn(String pay_sn) {
		return payLogDao.findByPaySn(pay_sn);
	}
	//用户id
	public PayLog findByUserID(String userId) {
		return payLogDao.findByUserID(userId);
	}
	public int save(PayLog payLog) {
		return payLogDao.save(payLog);
	}
	
	public int update(PayLog payLog,String type) {
		return payLogDao.update(payLog,type);
	}
	
	public int del(String sn) {
		return payLogDao.del(sn);
	}
	
}
