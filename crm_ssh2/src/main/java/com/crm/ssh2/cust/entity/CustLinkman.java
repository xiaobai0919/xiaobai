package com.crm.ssh2.cust.entity;

import com.crm.ssh2.base.entity.BaseEntity;

public class CustLinkman extends BaseEntity {

	/**
	 * 联系人类
	 */
	private static final long serialVersionUID = 5111621597342126827L;

	private Integer clkID;// 联系人ID

	private String clkCustNo; // 客户编号
	private String clkCustName; // 客户名称

	private String clkName; // 联系人名字
	private String clkSex; // 性别
	private String clkPostion; // 职位

	private String clkTel; // 办公电话

	private String clkMobile; // 手机
	private String clkMenu; // 备注

	public CustLinkman() {
		super();
	}

	public Integer getClkID() {
		return clkID;
	}

	public void setClkID(Integer clkID) {
		this.clkID = clkID;
	}

	public String getClkCustNo() {
		return clkCustNo;
	}

	public void setClkCustNo(String clkCustNo) {
		this.clkCustNo = clkCustNo;
	}

	public String getClkCustName() {
		return clkCustName;
	}

	public void setClkCustName(String clkCustName) {
		this.clkCustName = clkCustName;
	}

	public String getClkName() {
		return clkName;
	}

	public void setClkName(String clkName) {
		this.clkName = clkName;
	}

	public String getClkSex() {
		return clkSex;
	}

	public void setClkSex(String clkSex) {
		this.clkSex = clkSex;
	}

	public String getClkPostion() {
		return clkPostion;
	}

	public void setClkPostion(String clkPostion) {
		this.clkPostion = clkPostion;
	}

	public String getClkTel() {
		return clkTel;
	}

	public void setClkTel(String clkTel) {
		this.clkTel = clkTel;
	}

	public String getClkMobile() {
		return clkMobile;
	}

	public void setClkMobile(String clkMobile) {
		this.clkMobile = clkMobile;
	}

	public String getClkMenu() {
		return clkMenu;
	}

	public void setClkMenu(String clkMenu) {
		this.clkMenu = clkMenu;
	}

	@Override
	public String toString() {
		return "CustLinkman [clkID=" + clkID + ", clkCustNo=" + clkCustNo + ", clkCustName=" + clkCustName
				+ ", clkName=" + clkName + ", clkSex=" + clkSex + ", clkPostion=" + clkPostion + ", clkTel=" + clkTel
				+ ", clkMobile=" + clkMobile + ", clkMemo=" + clkMenu + "]";
	}

}
