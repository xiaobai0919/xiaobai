package com.crm.ssh2.right.entity;

import com.crm.ssh2.base.entity.BaseEntity;

//系统角色
public class RightRole extends BaseEntity {

	private static final long serialVersionUID = 8048186722075507525L;

	private Integer rrId;// 角色ID: 主键 标识列
	private String rrName;// 角色名
	private String rrDesc;// 角色说明

	private Integer rrFlag;// 角色标识: 0 不可用 1 可用
	private String flagState;// 状态

	public String getFlagState() {
		return flagState;
	}

	public void setFlagState(String flagState) {
		this.flagState = flagState;
	}

	public RightRole() {
		super();
	}

	public RightRole(Integer rrId) {
		super();
		this.rrId = rrId;
	}

	public Integer getRrId() {
		return rrId;
	}

	public void setRrId(Integer rrId) {
		this.rrId = rrId;
	}

	public String getRrName() {
		return rrName;
	}

	public void setRrName(String rrName) {
		this.rrName = rrName;
	}

	public String getRrDesc() {
		return rrDesc;
	}

	public void setRrDesc(String rrDesc) {
		this.rrDesc = rrDesc;
	}

	public Integer getRrFlag() {
		return rrFlag;
	}

	public void setRrFlag(Integer rrFlag) {
		this.rrFlag = rrFlag;
	}

	@Override
	public String toString() {
		return "RightRole [rrId=" + rrId + ", rrName=" + rrName + ", rrDesc=" + rrDesc + ", rrFlag=" + rrFlag
				+ ", flagState=" + flagState + "]";
	}

}
