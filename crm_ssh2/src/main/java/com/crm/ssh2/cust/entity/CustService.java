package com.crm.ssh2.cust.entity;

import com.crm.ssh2.base.entity.BaseEntity;

//权限
public class CustService extends BaseEntity {

	private static final long serialVersionUID = 8048186722075507525L;

	private Integer csId;// 服务ID:主键 标识列
	private String csType;// 服务类型:数据字典(服务类型)
	private String csTitle;// 概要

	private String csCustNo;// 客户编号:
	private String csCustName;// 客户名字:
	private String csStatus;// 服务状态: 默认值 '新创建'  新创建 已分配 已处理 已归档

	private String csRequest;// 服务请求
	private Integer csCreateId;// 创建人ID
	private String csCreateBy;// 创建人名字

	private String csCreateDate;// 创建日期时间:默认值为系统当前日期时间
	private String csDueId;// 派给人ID
	private String csDueTo;// 派给人名字

	private String csDueDate;// 指派日期时间
	private String csDealBy;// 服务处理
	private Integer csDealId;// 处理人-某人ID

	private String csDeal;// 处理人-某人名字
	private String csDealDate;// 处理日期时间
	private String csResult;// 处理结果

	private Integer csSatisfy;// 满意度

	public CustService() {
		super();
	}

	public Integer getCsId() {
		return csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public String getCsType() {
		return csType;
	}

	public void setCsType(String csType) {
		this.csType = csType;
	}

	public String getCsTitle() {
		return csTitle;
	}

	public void setCsTitle(String csTitle) {
		this.csTitle = csTitle;
	}

	public String getCsCustNo() {
		return csCustNo;
	}

	public void setCsCustNo(String csCustNo) {
		this.csCustNo = csCustNo;
	}

	public String getCsCustName() {
		return csCustName;
	}

	public void setCsCustName(String csCustName) {
		this.csCustName = csCustName;
	}

	public String getCsStatus() {
		return csStatus;
	}

	public void setCsStatus(String csStatus) {
		this.csStatus = csStatus;
	}

	public String getCsRequest() {
		return csRequest;
	}

	public void setCsRequest(String csRequest) {
		this.csRequest = csRequest;
	}

	public Integer getCsCreateId() {
		return csCreateId;
	}

	public void setCsCreateId(Integer csCreateId) {
		this.csCreateId = csCreateId;
	}

	public String getCsCreateBy() {
		return csCreateBy;
	}

	public void setCsCreateBy(String csCreateBy) {
		this.csCreateBy = csCreateBy;
	}

	public String getCsCreateDate() {
		return csCreateDate;
	}

	public void setCsCreateDate(String csCreateDate) {
		this.csCreateDate = csCreateDate;
	}

	public String getCsDueId() {
		return csDueId;
	}

	public void setCsDueId(String csDueId) {
		this.csDueId = csDueId;
	}

	public String getCsDueTo() {
		return csDueTo;
	}

	public void setCsDueTo(String csDueTo) {
		this.csDueTo = csDueTo;
	}

	public String getCsDueDate() {
		return csDueDate;
	}

	public void setCsDueDate(String csDueDate) {
		this.csDueDate = csDueDate;
	}

	public String getCsDealBy() {
		return csDealBy;
	}

	public void setCsDealBy(String csDealBy) {
		this.csDealBy = csDealBy;
	}

	public Integer getCsDealId() {
		return csDealId;
	}

	public void setCsDealId(Integer csDealId) {
		this.csDealId = csDealId;
	}

	public String getCsDeal() {
		return csDeal;
	}

	public void setCsDeal(String csDeal) {
		this.csDeal = csDeal;
	}

	public String getCsDealDate() {
		return csDealDate;
	}

	public void setCsDealDate(String csDealDate) {
		this.csDealDate = csDealDate;
	}

	public String getCsResult() {
		return csResult;
	}

	public void setCsResult(String csResult) {
		this.csResult = csResult;
	}

	public Integer getCsSatisfy() {
		return csSatisfy;
	}

	public void setCsSatisfy(Integer csSatisfy) {
		this.csSatisfy = csSatisfy;
	}

	@Override
	public String toString() {
		return "CustService [csId=" + csId + ", csType=" + csType + ", csTitle=" + csTitle + ", csCustNo=" + csCustNo
				+ ", csCustName=" + csCustName + ", csStatus=" + csStatus + ", csRequest=" + csRequest + ", csCreateId="
				+ csCreateId + ", csCreateBy=" + csCreateBy + ", csCreateDate=" + csCreateDate + ", csDueId=" + csDueId
				+ ", csDueTo=" + csDueTo + ", csDueDate=" + csDueDate + ", csDealBy=" + csDealBy + ", csDealId="
				+ csDealId + ", csDeal=" + csDeal + ", csDealDate=" + csDealDate + ", csResult=" + csResult
				+ ", csSatisfy=" + csSatisfy + "]";
	}

}
