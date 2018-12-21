package com.crm.ssh2.basd.entity;

import com.crm.ssh2.base.entity.BaseEntity;

public class OrdersDetail extends BaseEntity {

	/**
	 * 订单详情视图
	 */
	private static final long serialVersionUID = 4890001956693312566L;

	private Integer boId;
	private String boCustomer;
	private String boDate;
	private String boAddress;
	private String boStatus;
	private Integer bolCount;
	private Float bolPrice;
	private Integer bolBpId;
	private String bolUnit;
	private String bpName;
	private Float bpPrice;

	public OrdersDetail() {
		super();
	}

	public Integer getBoId() {
		return boId;
	}

	public void setBoId(Integer boId) {
		this.boId = boId;
	}

	public String getBoCustomer() {
		return boCustomer;
	}

	public void setBoCustomer(String boCustomer) {
		this.boCustomer = boCustomer;
	}

	public String getBoDate() {
		return boDate;
	}

	public void setBoDate(String boDate) {
		this.boDate = boDate;
	}

	public String getBoAddress() {
		return boAddress;
	}

	public void setBoAddress(String boAddress) {
		this.boAddress = boAddress;
	}

	public String getBoStatus() {
		return boStatus;
	}

	public void setBoStatus(String boStatus) {
		this.boStatus = boStatus;
	}

	public Integer getBolCount() {
		return bolCount;
	}

	public void setBolCount(Integer bolCount) {
		this.bolCount = bolCount;
	}

	public Float getBolPrice() {
		return bolPrice;
	}

	public void setBolPrice(Float bolPrice) {
		this.bolPrice = bolPrice;
	}

	public Integer getBolBpId() {
		return bolBpId;
	}

	public void setBolBpId(Integer bolBpId) {
		this.bolBpId = bolBpId;
	}

	public String getBpName() {
		return bpName;
	}

	public void setBpName(String bpName) {
		this.bpName = bpName;
	}

	public Float getBpPrice() {
		return bpPrice;
	}

	public void setBpPrice(Float bpPrice) {
		this.bpPrice = bpPrice;
	}

	public String getBolUnit() {
		return bolUnit;
	}

	public void setBolUnit(String bolUnit) {
		this.bolUnit = bolUnit;
	}

	@Override
	public String toString() {
		return "OrdersDetail [boId=" + boId + ", boCustomer=" + boCustomer + ", boDate=" + boDate + ", boAddress="
				+ boAddress + ", boStatus=" + boStatus + ", bolCount=" + bolCount + ", bolPrice=" + bolPrice
				+ ", bolBpId=" + bolBpId + ", bolUnit=" + bolUnit + ", bpName=" + bpName + ", bpPrice=" + bpPrice + "]";
	}

}
