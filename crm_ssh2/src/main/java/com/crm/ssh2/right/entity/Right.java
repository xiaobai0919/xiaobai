package com.crm.ssh2.right.entity;

import com.crm.ssh2.base.entity.BaseEntity;

//权限
public class Right extends BaseEntity {

	private static final long serialVersionUID = 8048186722075507525L;

	private String rCode;// 权限代码: 主键 标识列 1
	private String rParentCode;// 父权限代码
	private String rType;// 权限类型: Folder, Document 
	private String rText;// 权限名称 1
	private String rUrl;// 权限对应的URL
	private String rTip;// 权限提示1

	public String getrCode() {
		return rCode;
	}
	public void setrCode(String rCode) {
		this.rCode = rCode;
	}
	public String getrParentCode() {
		return rParentCode;
	}
	public void setrParentCode(String rParentCode) {
		this.rParentCode = rParentCode;
	}
	public String getrType() {
		return rType;
	}
	public void setrType(String rType) {
		this.rType = rType;
	}
	public String getrText() {
		return rText;
	}
	public void setrText(String rText) {
		this.rText = rText;
	}
	public String getrUrl() {
		return rUrl;
	}
	public void setrUrl(String rUrl) {
		this.rUrl = rUrl;
	}
	public String getrTip() {
		return rTip;
	}
	public void setrTip(String rTip) {
		this.rTip = rTip;
	}
	
	public Right() {
		super();
	}
	
	
	
	public Right(String rCode, String rParentCode, String rType, String rText, String rUrl, String rTip) {
		super();
		this.rCode = rCode;
		this.rParentCode = rParentCode;
		this.rType = rType;
		this.rText = rText;
		this.rUrl = rUrl;
		this.rTip = rTip;
	}
	@Override
	public String toString() {
		return "Right [rCode=" + rCode + ", rParentCode=" + rParentCode + ", rType=" + rType + ", rText=" + rText
				+ ", rUrl=" + rUrl + ", rTip=" + rTip + "]";
	}
	
	
}
