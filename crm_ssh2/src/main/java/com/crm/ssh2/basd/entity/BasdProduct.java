package com.crm.ssh2.basd.entity;

import com.crm.ssh2.base.entity.BaseEntity;

//产品信息
public class BasdProduct extends BaseEntity {

	private static final long serialVersionUID = 8048186722075507525L;

	private Integer bpId;// 产品ID:主键 标识列
	private String bpName;// 名称
	private String bpType;// 型号

	private String bpBatch;// 等级/批次
	private String bpUnit;// 单位
	private Double bpPrice;// 单价

	private String bpMenu;// 备注

	public BasdProduct() {
		super();
	}

	public Integer getBpId() {
		return bpId;
	}

	public void setBpId(Integer bpId) {
		this.bpId = bpId;
	}

	public String getBpName() {
		return bpName;
	}

	public void setBpName(String bpName) {
		this.bpName = bpName;
	}

	public String getBpType() {
		return bpType;
	}

	public void setBpType(String bpType) {
		this.bpType = bpType;
	}

	public String getBpBatch() {
		return bpBatch;
	}

	public void setBpBatch(String bpBatch) {
		this.bpBatch = bpBatch;
	}

	public String getBpUnit() {
		return bpUnit;
	}

	public void setBpUnit(String bpUnit) {
		this.bpUnit = bpUnit;
	}

	public Double getBpPrice() {
		return bpPrice;
	}

	public void setBpPrice(Double bpPrice) {
		this.bpPrice = bpPrice;
	}

	public String getBpMenu() {
		return bpMenu;
	}

	public void setBpMenu(String bpMenu) {
		this.bpMenu = bpMenu;
	}

	@Override
	public String toString() {
		return "BasdProduct [bpId=" + bpId + ", bpName=" + bpName + ", bpType=" + bpType + ", bpBatch=" + bpBatch
				+ ", bpUnit=" + bpUnit + ", bpPrice=" + bpPrice + ", bpMenu=" + bpMenu + "]";
	}

	
}
