package com.crm.ssh2.basd.biz.impl;

import java.util.List;

import com.crm.ssh2.basd.biz.IBasdOrdersLineBiz;
import com.crm.ssh2.basd.dao.IBasdOrdersLineDao;
import com.crm.ssh2.basd.entity.BasdOrdersLine;
import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.util.PageBean;

public class BasdOrdersLineBizimpl extends BaseBiz implements IBasdOrdersLineBiz {

	private static final long serialVersionUID = 3340859933509058117L;

	private IBasdOrdersLineDao basdOrdersLineDao;

	public IBasdOrdersLineDao getBasdOrdersLineDao() {
		return basdOrdersLineDao;
	}

	public void setBasdOrdersLineDao(IBasdOrdersLineDao basdOrdersLineDao) {
		this.basdOrdersLineDao = basdOrdersLineDao;
	}

	@Override
	public void add(BasdOrdersLine basdOrdersLine) {
		basdOrdersLineDao.add(basdOrdersLine); 
	}

	@Override
	public void edit(BasdOrdersLine basdOrdersLine) {
		basdOrdersLineDao.edit(basdOrdersLine);
	}

	@Override
	public void del(BasdOrdersLine basdOrdersLine) {
		basdOrdersLineDao.del(basdOrdersLine);
	}

	@Override
	public BasdOrdersLine load(BasdOrdersLine basdOrdersLine) {
		return basdOrdersLineDao.load(basdOrdersLine);
	}

	@Override
	public List<BasdOrdersLine> list(BasdOrdersLine basdOrdersLine, PageBean pageBean) {
		return basdOrdersLineDao.list(basdOrdersLine, pageBean);
	}

}
