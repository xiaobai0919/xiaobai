package com.crm.ssh2.right.biz.impl;

import java.util.List;

import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.right.biz.IRightBiz;
import com.crm.ssh2.right.dao.IRightDao;
import com.crm.ssh2.right.entity.Right;
import com.crm.ssh2.right.entity.RightUser;
import com.crm.ssh2.util.PageBean;

public class RightBizimpl extends BaseBiz implements IRightBiz {

	private static final long serialVersionUID = -2528902839618544243L;
	
	private IRightDao rightDao;
	
	public IRightDao getRightDao() {
		return rightDao;
	}
	public void setRightDao(IRightDao rightDao) {
		this.rightDao = rightDao;
	}
	
	public RightBizimpl() {
		
	}

	@Override
	public void add(Right right) {
		rightDao.add(right); 
	}

	@Override
	public void edit(Right right) {
		rightDao.edit(right);
	}

	@Override
	public void del(Right right) {
		rightDao.del(right);
	}

	@Override
	public Right load(Right right) {
		return rightDao.load(right);
	}

	@Override
	public List<Right> list(Right right,RightUser rightUser) {
		return rightDao.list(right,rightUser);
	}
	@Override
	public List<Right> list(Right right, PageBean pageBean) {
		// TODO Auto-generated method stub
		return rightDao.list(right,pageBean);
	}


}
