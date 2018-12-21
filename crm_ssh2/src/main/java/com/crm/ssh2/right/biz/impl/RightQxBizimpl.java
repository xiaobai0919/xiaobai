package com.crm.ssh2.right.biz.impl;

import java.util.List;

import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.right.biz.IRightQxBiz;
import com.crm.ssh2.right.dao.IRightQxDao;
import com.crm.ssh2.right.entity.RightQx;
import com.crm.ssh2.util.PageBean;

public class RightQxBizimpl extends BaseBiz implements IRightQxBiz {

	private static final long serialVersionUID = -2528902839618544243L;
	
	private IRightQxDao rightQxDao;
	
	public IRightQxDao getRightRoleRightDao() {
		return rightQxDao;
	}

	public void setRightRoleRightDao(IRightQxDao rightQxDao) {
		this.rightQxDao = rightQxDao;
	}

	@Override
	public void add(RightQx rightQx) {
		rightQxDao.add(rightQx); 
	}

	@Override
	public void edit(RightQx rightQx) {
		rightQxDao.edit(rightQx);
	}

	@Override
	public void del(RightQx rightQx) {
		rightQxDao.del(rightQx);
	}

	@Override
	public RightQx load(RightQx rightQx) {
		return rightQxDao.load(rightQx);
	}

	@Override
	public List<RightQx> list(RightQx rightQx, PageBean pageBean) {
		return rightQxDao.list(rightQx, pageBean);
	}


}
