package com.crm.ssh2.cust.entity;

import com.crm.ssh2.base.entity.BaseEntity;

public class CustActivity extends BaseEntity {

	/**
	 * 交往记录类
	 */
	private static final long serialVersionUID = 1L;

	private Integer caID; // 交往记BasdOrders录ID

	private String caCustNo; // 客户编号
	private String caCustName; // 客户名称

	private String caDate; // 交往日期  默认系统当前时间
	private String caPlace; // 交往地点
	private String caTitle; // 概要

	private String caRemark; // 备注
	private String caDesc; // 详细

	public CustActivity() {
		super();
	}

	public Integer getCaID() {
		return caID;
	}

	public void setCaID(Integer caID) {
		this.caID = caID;
	}

	public String getCaCustNo() {
		return caCustNo;
	}

	public void setCaCustNo(String caCustNo) {
		this.caCustNo = caCustNo;
	}

	public String getCaCustName() {
		return caCustName;
	}

	public void setCaCustName(String caCustName) {
		this.caCustName = caCustName;
	}

	public String getCaDate() {
		return caDate;
	}

	public void setCaDate(String caDate) {
		this.caDate = caDate;
	}

	public String getCaPlace() {
		return caPlace;
	}

	public void setCaPlace(String caPlace) {
		this.caPlace = caPlace;
	}

	public String getCaTitle() {
		return caTitle;
	}

	public void setCaTitle(String caTitle) {
		this.caTitle = caTitle;
	}

	public String getCaRemark() {
		return caRemark;
	}

	public void setCaRemark(String caRemark) {
		this.caRemark = caRemark;
	}

	public String getCaDesc() {
		return caDesc;
	}

	public void setCaDesc(String caDesc) {
		this.caDesc = caDesc;
	}

	@Override
	public String toString() {
		return "CustActivity [caID=" + caID + ", caCustNo=" + caCustNo + ", caCustName=" + caCustName + ", caDate="
				+ caDate + ", caPlace=" + caPlace + ", caTitle=" + caTitle + ", caRemark=" + caRemark + ", caDesc="
				+ caDesc + "]";
	}

}
