package com.crm.ssh2.basd.entity;

import com.crm.ssh2.base.entity.BaseEntity;

//库存
public class BasdStorage extends BaseEntity {

	private static final long serialVersionUID = 8048186722075507525L;

	private Integer bsId;// 库存ID:主键 标识列
	private Integer bpId;// 产品ID:外键 引用
	private String bsWarehouse;// 仓库

	private String bsWare;// 货位
	private Integer bsCount;// 件数
	private String bsMenu;// 备注
	
	private String bpName;// 名称
	private String bpType;// 型号
	private String bpBatch;// 等级/批次
	
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

	public BasdStorage() {
		super();
	}

	public Integer getBsId() {
		return bsId;
	}

	public void setBsId(Integer bsId) {
		this.bsId = bsId;
	}

	public Integer getBpId() {
		return bpId;
	}

	public void setBpId(Integer bpId) {
		this.bpId = bpId;
	}

	public String getBsWarehouse() {
		return bsWarehouse;
	}

	public void setBsWarehouse(String bsWarehouse) {
		this.bsWarehouse = bsWarehouse;
	}

	public String getBsWare() {
		return bsWare;
	}

	public void setBsWare(String bsWare) {
		this.bsWare = bsWare;
	}

	public Integer getBsCount() {
		return bsCount;
	}

	public void setBsCount(Integer bsCount) {
		this.bsCount = bsCount;
	}

	public String getBsMenu() {
		return bsMenu;
	}

	public void setBsMenu(String bsMenu) {
		this.bsMenu = bsMenu;
	}
	
	public BasdStorage(Integer bsId, Integer bpId, String bsWarehouse, String bsWare, Integer bsCount, String bsMenu,
			String bpName, String bpType, String bpBatch) {
		super();
		this.bsId = bsId;
		this.bpId = bpId;
		this.bsWarehouse = bsWarehouse;
		this.bsWare = bsWare;
		this.bsCount = bsCount;
		this.bsMenu = bsMenu;
		this.bpName = bpName;
		this.bpType = bpType;
		this.bpBatch = bpBatch;
	}

	@Override
	public String toString() {
		return "BasdStorage [bsId=" + bsId + ", bpId=" + bpId + ", bsWarehouse=" + bsWarehouse + ", bsWare=" + bsWare
				+ ", bsCount=" + bsCount + ", bsMenu=" + bsMenu + ", bpName=" + bpName + ", bpType=" + bpType
				+ ", bpBatch=" + bpBatch + "]";
	}
	
}
