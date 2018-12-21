package com.crm.ssh2.right.entity;

import com.crm.ssh2.base.entity.BaseEntity;

//角色权限
public class RightQx extends BaseEntity {

	private static final long serialVersionUID = 8048186722075507525L;

	private Integer rqId;// ID:主键 标识列
	private Integer rqrRoleId;// 角色ID
	private String rqrCode;// 权限ID

	public RightQx() {
		super();
	}

	public Integer getRqId() {
		return rqId;
	}

	public void setRqId(Integer rqId) {
		this.rqId = rqId;
	}

	public Integer getRqrRoleId() {
		return rqrRoleId;
	}

	public void setRqrRoleId(Integer rqrRoleId) {
		this.rqrRoleId = rqrRoleId;
	}

	public String getRqrCode() {
		return rqrCode;
	}

	public void setRqrCode(String rqrCode) {
		this.rqrCode = rqrCode;
	}

	@Override
	public String toString() {
		return "RightQx [rqId=" + rqId + ", rqrRoleId=" + rqrRoleId + ", rqrCode=" + rqrCode + "]";
	}
	
}
