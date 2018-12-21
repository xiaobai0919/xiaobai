package com.crm.ssh2.basd.entity;

import com.crm.ssh2.base.entity.BaseEntity;

//数据字典
public class BasdDict extends BaseEntity {

	private static final long serialVersionUID = 8048186722075507525L;

	private Integer bdId;// 字典ID:主键 标识列
	private String bdType;// 字典类型
	private String bdItem;// 字典条目: 一般用来生成下拉框的文本

	private String bdValue;// 字典值: 一般用来生成下拉框的值
	private Integer bdIsEditable;//能否编辑: 1 可 0 不可

	public BasdDict() {
		super();
	}

	public Integer getBdId() {
		return bdId;
	}

	public void setBdId(Integer bdId) {
		this.bdId = bdId;
	}

	public String getBdType() {
		return bdType;
	}

	public void setBdType(String bdType) {
		this.bdType = bdType;
	}

	public String getBdItem() {
		return bdItem;
	}

	public void setBdItem(String bdItem) {
		this.bdItem = bdItem;
	}

	public String getBdValue() {
		return bdValue;
	}

	public void setBdValue(String bdValue) {
		this.bdValue = bdValue;
	}

	public Integer getBdIsEditable() {
		return bdIsEditable;
	}

	public void setBdIsEditable(Integer bdIsEditable) {
		this.bdIsEditable = bdIsEditable;
	}

	@Override
	public String toString() {
		return "BasdDict [bdId=" + bdId + ", bdType=" + bdType + ", bdItem=" + bdItem + ", bdValue=" + bdValue
				+ ", bdIsEditable=" + bdIsEditable + "]";
	}
}
