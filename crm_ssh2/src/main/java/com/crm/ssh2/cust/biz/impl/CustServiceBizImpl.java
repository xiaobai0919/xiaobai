package com.crm.ssh2.cust.biz.impl;

import java.util.List;

import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.cust.biz.ICustServiceBiz;
import com.crm.ssh2.cust.dao.ICustServiceDAO;
import com.crm.ssh2.cust.dao.impl.CustServiceDAOImpl;
import com.crm.ssh2.cust.entity.CustService;
import com.crm.ssh2.util.PageBean;

public class CustServiceBizImpl extends BaseBiz implements ICustServiceBiz {

	private static final long serialVersionUID = 2872994563986156419L;
	
	private ICustServiceDAO custServiceDao;
	
	public ICustServiceDAO getCustServiceDao() {
		return custServiceDao;
	}
	public void setCustServiceDao(ICustServiceDAO custServiceDao) {
		this.custServiceDao = custServiceDao;
	}

	@Override
	public void add(CustService custService) {
		custServiceDao.add(custService);
	}

	@Override
	public void edit(CustService custService) {
		custServiceDao.edit(custService);
	}

	@Override
	public void del(CustService custService) {
		custServiceDao.del(custService);
	}

	@Override
	public CustService load(CustService custService) {
		return custServiceDao.load(custService);
	}

	@Override
	public List<CustService> list(String str,CustService custService, PageBean pageBean) {
		return custServiceDao.list(str,custService, pageBean);
	}
	@Override
	public Integer getMaxCsId() {
		return custServiceDao.getMaxCsId();
	}
	@Override
	public void editCL(CustService custService) {
		custServiceDao.editCL(custService);
	}
	@Override
	public void editFK(CustService custService) {
		custServiceDao.editFK(custService);
	}

}
