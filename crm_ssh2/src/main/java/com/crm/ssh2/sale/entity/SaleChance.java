package com.crm.ssh2.sale.entity;

import java.util.HashSet;
import java.util.Set;

import com.crm.ssh2.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

public class SaleChance extends BaseEntity {

	/**
	 * 营销机会类
	 */
	private static final long serialVersionUID = 8124542800011910868L;

	private Integer scId; // 营销机会ID
	private String scSource; // 机会来源
	private String scCustName; // 客户名称

	private String scTitle; // 概要
	private Integer scRate; // 成功几率
	private String scLinkman; // 联系人

	private String scTel; // 联系人电话
	private String scDesc; // 机会描述
	private Integer scCreateId; // 创建人ID

	private String scCreateBy; // 创建人名字
	private String scCreateDate; // 创建日期时间
	private Integer scDueId; // 指派给某人ID

	private String scDueTo; // 指派给某人名字
	private String scDueDate; // 指派日期时间
	private String scStatus; // 状态
	
	//Set无序不能重复
	private Set<SalePlan> salePlan = new HashSet<SalePlan>();
	public Set<SalePlan> getSalePlan() {
		return salePlan;
	}
	
	@JsonBackReference
	public void setSalePlan(Set<SalePlan> salePlan) {
		this.salePlan = salePlan;
	}

	public SaleChance() {
		super();
	}

	public Integer getScId() {
		return scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}

	public String getScSource() {
		return scSource;
	}

	public void setScSource(String scSource) {
		this.scSource = scSource;
	}

	public String getScCustName() {
		return scCustName;
	}

	public void setScCustName(String scCustName) {
		this.scCustName = scCustName;
	}

	public String getScTitle() {
		return scTitle;
	}

	public void setScTitle(String scTitle) {
		this.scTitle = scTitle;
	}

	public Integer getScRate() {
		return scRate;
	}

	public void setScRate(Integer scRate) {
		this.scRate = scRate;
	}

	public String getScLinkman() {
		return scLinkman;
	}

	public void setScLinkman(String scLinkman) {
		this.scLinkman = scLinkman;
	}

	public String getScTel() {
		return scTel;
	}

	public void setScTel(String scTel) {
		this.scTel = scTel;
	}

	public String getScDesc() {
		return scDesc;
	}

	public void setScDesc(String scDesc) {
		this.scDesc = scDesc;
	}

	public Integer getScCreateId() {
		return scCreateId;
	}

	public void setScCreateId(Integer scCreateId) {
		this.scCreateId = scCreateId;
	}

	public String getScCreateBy() {
		return scCreateBy;
	}

	public void setScCreateBy(String scCreateBy) {
		this.scCreateBy = scCreateBy;
	}

	public String getScCreateDate() {
		return scCreateDate;
	}

	public void setScCreateDate(String scCreateDate) {
		this.scCreateDate = scCreateDate;
	}

	public Integer getScDueId() {
		return scDueId;
	}

	public void setScDueId(Integer scDueId) {
		this.scDueId = scDueId;
	}

	public String getScDueTo() {
		return scDueTo;
	}

	public void setScDueTo(String scDueTo) {
		this.scDueTo = scDueTo;
	}

	public String getScDueDate() {
		return scDueDate;
	}

	public void setScDueDate(String scDueDate) {
		this.scDueDate = scDueDate;
	}

	public String getScStatus() {
		return scStatus;
	}

	public void setScStatus(String scStatus) {
		this.scStatus = scStatus;
	}

	@Override
	public String toString() {
		return "SaleChance [scId=" + scId + ", scSource=" + scSource + ", scCustName=" + scCustName + ", scTitle="
				+ scTitle + ", scRate=" + scRate + ", scLinkman=" + scLinkman + ", scTel=" + scTel + ", scDesc="
				+ scDesc + ", scCreateId=" + scCreateId + ", scCreateBy=" + scCreateBy + ", scCreateDate="
				+ scCreateDate + ", scDueId=" + scDueId + ", scDueTo=" + scDueTo + ", scDueDate=" + scDueDate
				+ ", scStatus=" + scStatus + "]";
	}

	
}
