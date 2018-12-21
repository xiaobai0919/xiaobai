package com.crm.ssh2.cust.entity;

import com.crm.ssh2.base.entity.BaseEntity;

public class CustLost extends BaseEntity {

	/**
	 * 客户流失类
	 */
	private static final long serialVersionUID = 5683820272147765696L;

	private Integer clId;// 客户流失ID

	private String clCustNo;// 客户编号
	private String clCustName; // 客户名称

	private Integer clCustManagerId;// 客户经理ID
	private String clCustManagerName;// 客户经理名字
	private String clLastOrderDate;// 上次下单时间

	private String clLostDate;// 流失时间

	private String clDelay;// 暂缓措施
	private String clReason;// 流失原因

	private String clStatus;// 状态 1 预警 2 暂缓流失 3 确认流失

	public CustLost() {
		super();
	}

	public Integer getClId() {
		return clId;
	}

	public void setClId(Integer clId) {
		this.clId = clId;
	}

	public String getClCustNo() {
		return clCustNo;
	}

	public void setClCustNo(String clCustNo) {
		this.clCustNo = clCustNo;
	}

	public String getClCustName() {
		return clCustName;
	}

	public void setClCustName(String clCustName) {
		this.clCustName = clCustName;
	}

	public int getClCustManagerId() {
		return clCustManagerId;
	}

	public void setClCustManagerId(int clCustManagerId) {
		this.clCustManagerId = clCustManagerId;
	}

	public String getClCustManagerName() {
		return clCustManagerName;
	}

	public void setClCustManagerName(String clCustManagerName) {
		this.clCustManagerName = clCustManagerName;
	}

	public String getClLastOrderDate() {
		return clLastOrderDate;
	}

	public void setClLastOrderDate(String clLastOrderDate) {
		this.clLastOrderDate = clLastOrderDate;
	}

	public String getClLostDate() {
		return clLostDate;
	}

	public void setClLostDate(String clLostDate) {
		this.clLostDate = clLostDate;
	}

	public String getClDelay() {
		return clDelay;
	}

	public void setClDelay(String clDelay) {
		this.clDelay = clDelay;
	}

	public String getClReason() {
		return clReason;
	}

	public void setClReason(String clReason) {
		this.clReason = clReason;
	}

	public String getClStatus() {
		return clStatus;
	}

	public void setClStatus(String clStatus) {
		this.clStatus = clStatus;
	}

	@Override
	public String toString() {
		return "CustLost [clId=" + clId + ", clCustNo=" + clCustNo + ", clCustName=" + clCustName + ", clCustManagerId="
				+ clCustManagerId + ", clCustManagerName=" + clCustManagerName + ", clLastOrderDate=" + clLastOrderDate
				+ ", clLostDate=" + clLostDate + ", clDelay=" + clDelay + ", clReason=" + clReason + ", clStatus="
				+ clStatus + "]";
	}

}
