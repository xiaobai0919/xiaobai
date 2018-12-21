package com.crm.ssh2.basd.entity;

import com.crm.ssh2.base.entity.BaseEntity;

//订单明细
public class BasdOrdersLine extends BaseEntity {

	private static final long serialVersionUID = 8048186722075507525L;

	private Integer bolId;// 订单明显ID:主键 标识列
	private Integer bolBoId;// 订单ID: 外键 引用
	private Integer bolBpId;// 产品ID: 外键 引用

	private Integer bolCount;// 数量
	private String bolUnit;// 单位
	private Double bolPrice;// 单价

	public BasdOrdersLine() {
		super();
	}

	public Integer getBolId() {
		return bolId;
	}

	public void setBolId(Integer bolId) {
		this.bolId = bolId;
	}

	public Integer getBolBoId() {
		return bolBoId;
	}

	public void setBolBoId(Integer bolBoId) {
		this.bolBoId = bolBoId;
	}

	public Integer getBolBpId() {
		return bolBpId;
	}

	public void setBolBpId(Integer bolBpId) {
		this.bolBpId = bolBpId;
	}

	public Integer getBolCount() {
		return bolCount;
	}

	public void setBolCount(Integer bolCount) {
		this.bolCount = bolCount;
	}

	public String getBolUnit() {
		return bolUnit;
	}

	public void setBolUnit(String bolUnit) {
		this.bolUnit = bolUnit;
	}

	public Double getBolPrice() {
		return bolPrice;
	}

	public void setBolPrice(Double bolPrice) {
		this.bolPrice = bolPrice;
	}

	@Override
	public String toString() {
		return "BasdOrdersLine [bolId=" + bolId + ", bolBoId=" + bolBoId + ", bolBpId=" + bolBpId + ", bolCount="
				+ bolCount + ", bolUnit=" + bolUnit + ", bolPrice=" + bolPrice + "]";
	}

}
