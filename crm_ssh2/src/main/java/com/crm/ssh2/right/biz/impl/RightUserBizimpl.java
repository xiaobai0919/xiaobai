package com.crm.ssh2.right.biz.impl;

import java.util.List;

import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.right.biz.IRightUserBiz;
import com.crm.ssh2.right.dao.IRightUserDao;
import com.crm.ssh2.right.entity.RightUser;
import com.crm.ssh2.util.PageBean;

public class RightUserBizimpl extends BaseBiz implements IRightUserBiz {

	private static final long serialVersionUID = -2528902839618544243L;
	
	private IRightUserDao rightUserDao;
	
	public IRightUserDao getRightUserDao() {
		return rightUserDao;
	}

	public void setRightUserDao(IRightUserDao rightUserDao) {
		this.rightUserDao = rightUserDao;
	}

	@Override
	public void add(RightUser rightUser) {
		rightUserDao.add(rightUser); 
	}

	@Override
	public void edit(RightUser rightUser) {
		rightUserDao.edit(rightUser);
	}

	@Override
	public void del(RightUser rightUser) {
		rightUserDao.del(rightUser);
	}

	@Override
	public RightUser load(RightUser rightUser) {
		return rightUserDao.load(rightUser);
	}

	@Override
	public List<RightUser> list(RightUser rightUser, PageBean pageBean) {
		return rightUserDao.list(rightUser, pageBean);
	}

	@Override
	public RightUser login(RightUser rightUser) {
		return rightUserDao.login(rightUser);
	}


}
