package entity;
import java.util.Date;

import util.Constant;
import util.SQLConstant;

import java.math.BigDecimal;

/** 
* @author miku
* 支付记录实体类
* @version v0.0.1
* @date 2021年3月1日 上午8:48:40 
*/

public class PayLog {
	

	
	private String userId;//用户id
	private String sn;//支付编号
	private String pay_sn;//支付平台交易号
	private String totalAmount;//支付金额
	private String title;//支付订单标题
	private String info;//支付订单详情
	private Integer status = SQLConstant.pay_status_wait;//支付订单状态
	private String refundAmount;//退款金额
	private String refundInfo;//退款原因
	private String refundSn;//退款编号
	private String createTime ;//创建时间
	private String payTime;//支付时间
	
	

	
	
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	
	@Override
	public String toString() {
		return "PayLog [userId=" + userId + ", sn=" + sn + ", pay_sn=" + pay_sn + ", totalAmount=" + totalAmount
				+ ", title=" + title + ", info=" + info + ", status=" + status + ", refundAmount=" + refundAmount
				+ ", refundInfo=" + refundInfo + ", refundSn=" + refundSn + ", createTime=" + createTime + ", payTime="
				+ payTime + "]";
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount2) {
		this.totalAmount = totalAmount2;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getPay_sn() {
		return pay_sn;
	}
	public void setPay_sn(String pay_sn) {
		this.pay_sn = pay_sn;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getRefundInfo() {
		return refundInfo;
	}
	public void setRefundInfo(String refundInfo) {
		this.refundInfo = refundInfo;
	}
	public String getRefundSn() {
		return refundSn;
	}
	public void setRefundSn(String refundSn) {
		this.refundSn = refundSn;
	}
	
}
