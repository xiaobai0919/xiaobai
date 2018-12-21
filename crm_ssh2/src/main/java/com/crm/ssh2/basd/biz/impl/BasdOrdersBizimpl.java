package com.crm.ssh2.basd.biz.impl;

import java.util.List;

import com.crm.ssh2.basd.biz.IBasdOrdersBiz;
import com.crm.ssh2.basd.dao.IBasdOrdersDao;
import com.crm.ssh2.basd.entity.BasdOrders;
import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.util.PageBean;

public class BasdOrdersBizimpl extends BaseBiz implements IBasdOrdersBiz {

	private static final long serialVersionUID = 3340859933509058117L;

	private IBasdOrdersDao basdOrdersDao;

	public IBasdOrdersDao getBasdOrdersDao() {
		return basdOrdersDao;
	}

	public void setBasdOrdersDao(IBasdOrdersDao basdOrdersDao) {
		this.basdOrdersDao = basdOrdersDao;
	}

	@Override
	public void add(BasdOrders basdOrders) {
		basdOrdersDao.add(basdOrders); 
	}

	@Override
	public void edit(BasdOrders basdOrders) {
		basdOrdersDao.edit(basdOrders);
	}

	@Override
	public void del(BasdOrders basdOrders) {
		basdOrdersDao.del(basdOrders);
	}

	@Override
	public BasdOrders load(BasdOrders basdOrders) {
		return basdOrdersDao.load(basdOrders);
	}

	@Override
	public List<BasdOrders> list(BasdOrders basdOrders, PageBean pageBean) {
		return basdOrdersDao.list(basdOrders, pageBean);
	}

	@Override
	public List<BasdOrders> list2(BasdOrders basdOrders, PageBean pageBean) {
		return basdOrdersDao.list2(basdOrders, pageBean);
	}

}
