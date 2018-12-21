package com.crm.ssh2.right.entity;

import com.crm.ssh2.base.entity.BaseEntity;

//系统用户
public class RightUser extends BaseEntity {

	private static final long serialVersionUID = 8048186722075507525L;

	private Integer ruId;// 用户编号
	private String ruName;// 用户名
	private String ruPassword;// 密码

	private Integer ruRoleId;// 角色ID
	private Integer ruFlag;// 用户标识: 0 不可用 1 可用
	private String flagState;// 状态

	private String ruRoleName; // 角色名
	
	public String getFlagState() {
		return flagState;
	}

	public void setFlagState(String flagState) {
		this.flagState = flagState;
	}

	public Integer getRuId() {
		return ruId;
	}

	public void setRuId(Integer ruId) {
		this.ruId = ruId;
	}

	public String getRuName() {
		return ruName;
	}

	public void setRuName(String ruName) {
		this.ruName = ruName;
	}

	public String getRuPassword() {
		return ruPassword;
	}

	public void setRuPassword(String ruPassword) {
		this.ruPassword = ruPassword;
	}

	public Integer getRuRoleId() {
		return ruRoleId;
	}

	public void setRuRoleId(Integer ruRoleId) {
		this.ruRoleId = ruRoleId;
	}

	public Integer getRuFlag() {
		return ruFlag;
	}

	public void setRuFlag(Integer ruFlag) {
		this.ruFlag = ruFlag;
	}
	
	public RightUser(Integer ruId, String ruName, String ruPassword, Integer ruRoleId, Integer ruFlag) {
		this.ruId = ruId;
		this.ruName = ruName;
		this.ruPassword = ruPassword;
		this.ruRoleId = ruRoleId;
		this.ruFlag = ruFlag;
	}
	

	public String getRuRoleName() {
		return ruRoleName;
	}

	public void setRuRoleName(String ruRoleName) {
		this.ruRoleName = ruRoleName;
	}

	public RightUser() {
		super();
	}

	public RightUser(Integer ruId, String ruName, String ruPassword, Integer ruRoleId, Integer ruFlag,
			String ruRoleName,String flagState) {
		super();
		this.ruId = ruId;
		this.ruName = ruName;
		this.ruPassword = ruPassword;
		this.ruRoleId = ruRoleId;
		this.ruFlag = ruFlag;
		this.ruRoleName = ruRoleName;
		this.flagState = flagState;
	}
	
	public RightUser(Integer ruId, String ruName, String ruPassword, Integer ruRoleId, Integer ruFlag,
			String ruRoleName) {
		super();
		this.ruId = ruId;
		this.ruName = ruName;
		this.ruPassword = ruPassword;
		this.ruRoleId = ruRoleId;
		this.ruFlag = ruFlag;
		this.ruRoleName = ruRoleName;
	}

	@Override
	public String toString() {
		return "RightUser [ruId=" + ruId + ", ruName=" + ruName + ", ruPassword=" + ruPassword + ", ruRoleId="
				+ ruRoleId + ", ruFlag=" + ruFlag + ", flagState=" + flagState + ", ruRoleName=" + ruRoleName + "]";
	}

}
