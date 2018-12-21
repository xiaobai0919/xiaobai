package com.crm.ssh2.basd.biz.impl;

import java.util.List;

import com.crm.ssh2.basd.biz.IBasdProductBiz;
import com.crm.ssh2.basd.dao.IBasdProductDao;
import com.crm.ssh2.basd.entity.BasdProduct;
import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.util.PageBean;

public class BasdProductBizimpl extends BaseBiz implements IBasdProductBiz {

	private static final long serialVersionUID = 3340859933509058117L;

	private IBasdProductDao basdProductDao;

	public IBasdProductDao getBasdProductDao() {
		return basdProductDao;
	}

	public void setBasdProductDao(IBasdProductDao basdProductDao) {
		this.basdProductDao = basdProductDao;
	}

	@Override
	public void add(BasdProduct basdProduct) {
		basdProductDao.add(basdProduct); 
	}

	@Override
	public void edit(BasdProduct basdProduct) {
		basdProductDao.edit(basdProduct);
	}

	@Override
	public void del(BasdProduct basdProduct) {
		basdProductDao.del(basdProduct);
	}

	@Override
	public BasdProduct load(BasdProduct basdProduct) {
		return basdProductDao.load(basdProduct);
	}

	@Override
	public List<BasdProduct> list(BasdProduct basdProduct, PageBean pageBean) {
		return basdProductDao.list(basdProduct, pageBean);
	}

}
