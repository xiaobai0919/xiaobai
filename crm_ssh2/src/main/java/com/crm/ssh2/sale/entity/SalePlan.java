package com.crm.ssh2.sale.entity;

import com.crm.ssh2.base.entity.BaseEntity;

public class SalePlan extends BaseEntity {

	/**
	 * 营销计划类
	 */
	private static final long serialVersionUID = 4279515256829614070L;

	private Integer spId; // 计划ID
	
	private Integer scId;
	//如果TaOrderItem与类TaOrder关联，那么被引用的类TaOrder将被定义为类TaOrderItem的属性
	//多对一
	private SaleChance saleChance;
	
	private String spDate; // 机会执行日期
	private String spTodo; // 计划内容
	private String spResult; // 计划执行结果
	
	public Integer getSpId() {
		return spId;
	}
	public void setSpId(Integer spId) {
		this.spId = spId;
	}
	public Integer getScId() {
		return scId;
	}
	public void setScId(Integer scId) {
		this.scId = scId;
	}
	public String getSpDate() {
		return spDate;
	}
	public SaleChance getSaleChance() {
		return saleChance;
	}
	
	public void setSaleChance(SaleChance saleChance) {
		this.saleChance = saleChance;
	}
	public void setSpDate(String spDate) {
		this.spDate = spDate;
	}
	public String getSpTodo() {
		return spTodo;
	}
	public void setSpTodo(String spTodo) {
		this.spTodo = spTodo;
	}
	public String getSpResult() {
		return spResult;
	}
	public void setSpResult(String spResult) {
		this.spResult = spResult;
	}
	
	public SalePlan() {
		
	}
	@Override
	public String toString() {
		return "SalePlan [spId=" + spId + ", scId=" + scId + ", saleChance=" + saleChance + ", spDate=" + spDate
				+ ", spTodo=" + spTodo + "]";
	}
	
	
	
	
}

