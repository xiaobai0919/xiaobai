package com.crm.ssh2.basd.biz.impl;

import java.util.List;

import com.crm.ssh2.basd.biz.IBasdDictBiz;
import com.crm.ssh2.basd.dao.IBasdDictDao;
import com.crm.ssh2.basd.entity.BasdDict;
import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.util.PageBean;

public class BasdDictBizimpl extends BaseBiz implements IBasdDictBiz {

	private static final long serialVersionUID = 3340859933509058117L;

	private IBasdDictDao basdDictDao;

	public IBasdDictDao getBasdDictDao() {
		return basdDictDao;
	}

	public void setBasdDictDao(IBasdDictDao basdDictDao) {
		this.basdDictDao = basdDictDao;
	}
	
	public BasdDictBizimpl() {
		
	}

	@Override
	public void add(BasdDict basdDict) {
		basdDictDao.add(basdDict); 
	}

	@Override
	public void edit(BasdDict basdDict) {
		basdDictDao.edit(basdDict);
	}

	@Override
	public void del(BasdDict basdDict) {
		basdDictDao.del(basdDict);
	}

	@Override
	public BasdDict load(BasdDict basdDict) {
		return basdDictDao.load(basdDict);
	}

	@Override
	public List<BasdDict> list(BasdDict basdDict, PageBean pageBean) {
		return basdDictDao.list(basdDict, pageBean);
	}

	@Override
	public Integer dogetMaxBdId() {
		return basdDictDao.dogetMaxBdId();
	}

}
