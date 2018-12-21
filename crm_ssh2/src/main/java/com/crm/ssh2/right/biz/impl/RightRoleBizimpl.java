package com.crm.ssh2.right.biz.impl;

import java.util.List;

import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.right.biz.IRightRoleBiz;
import com.crm.ssh2.right.dao.IRightRoleDao;
import com.crm.ssh2.right.entity.RightRole;
import com.crm.ssh2.util.PageBean;

public class RightRoleBizimpl extends BaseBiz implements IRightRoleBiz {

	private static final long serialVersionUID = -2528902839618544243L;
	
	private IRightRoleDao rightRoleDao;
	
	public IRightRoleDao getRightRoleDao() {
		return rightRoleDao;
	}

	public void setRightRoleDao(IRightRoleDao rightRoleDao) {
		this.rightRoleDao = rightRoleDao;
	}

	@Override
	public void add(RightRole rightRole) {
		rightRoleDao.add(rightRole); 
	}

	@Override
	public void edit(RightRole rightRole) {
		rightRoleDao.edit(rightRole);
	}

	@Override
	public void del(RightRole rightRole) {
		rightRoleDao.del(rightRole);
	}

	@Override
	public RightRole load(RightRole rightRole) {
		return rightRoleDao.load(rightRole);
	}

	@Override
	public List<RightRole> list(RightRole rightRole, PageBean pageBean) {
		return rightRoleDao.list(rightRole, pageBean);
	}


}
