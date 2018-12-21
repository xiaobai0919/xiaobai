package com.crm.ssh2.basd.biz.impl;

import java.util.List;

import com.crm.ssh2.basd.biz.IBasdStorageBiz;
import com.crm.ssh2.basd.dao.IBasdStorageDao;
import com.crm.ssh2.basd.entity.BasdStorage;
import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.util.PageBean;

public class BasdStorageBizimpl extends BaseBiz implements IBasdStorageBiz {

	private static final long serialVersionUID = 3340859933509058117L;

	private IBasdStorageDao basdStorageDao;

	public IBasdStorageDao getBasdStorageDao() {
		return basdStorageDao;
	}

	public void setBasdStorageDao(IBasdStorageDao basdStorageDao) {
		this.basdStorageDao = basdStorageDao;
	}

	@Override
	public void add(BasdStorage basdStorage) {
		basdStorageDao.add(basdStorage); 
	}

	@Override
	public void edit(BasdStorage basdStorage) {
		basdStorageDao.edit(basdStorage);
	}

	@Override
	public void del(BasdStorage basdStorage) {
		basdStorageDao.del(basdStorage);
	}

	@Override
	public BasdStorage load(BasdStorage basdStorage) {
		return basdStorageDao.load(basdStorage);
	}

	@Override
	public List<BasdStorage> list(BasdStorage basdStorage, PageBean pageBean) {
		return basdStorageDao.list(basdStorage, pageBean);
	}

}
