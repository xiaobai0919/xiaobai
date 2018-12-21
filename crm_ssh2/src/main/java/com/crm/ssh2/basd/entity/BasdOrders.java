package com.crm.ssh2.basd.entity;

import com.crm.ssh2.base.entity.BaseEntity;

//历史订单
public class BasdOrders extends BaseEntity {

	private static final long serialVersionUID = 8048186722075507525L;

	private Integer boId;// 订单ID:主键 标识列
	private String boCustomer;// 客户名称
	private String boDate;// 下单日期

	private String boAddress;// 送货地址
	private String boStatus;// 订单状态: a 已回款 b 未回款

	public BasdOrders() {
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

	@Override
	public String toString() {
		return "BasdOrders [boId=" + boId + ", boCustomer=" + boCustomer + ", boDate=" + boDate + ", boAddress=" + boAddress
				+ ", boStatus=" + boStatus + "]";
	}

}
