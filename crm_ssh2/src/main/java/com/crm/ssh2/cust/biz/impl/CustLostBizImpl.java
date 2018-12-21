package com.crm.ssh2.cust.biz.impl;

import java.util.List;

import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.cust.biz.ICustLostBiz;
import com.crm.ssh2.cust.dao.ICustLostDAO;
import com.crm.ssh2.cust.entity.CustLost;
import com.crm.ssh2.util.PageBean;

public class CustLostBizImpl extends BaseBiz implements ICustLostBiz {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8870363479441035462L;

	private ICustLostDAO custLostDAO;

	public ICustLostDAO getCustLostDAO() {
		return custLostDAO;
	}

	public void setCustLostDAO(ICustLostDAO custLostDAO) {
		this.custLostDAO = custLostDAO;
	}

	@Override
	public void add(CustLost custLost) {
		custLostDAO.add(custLost);

	}

	@Override
	public void edit(CustLost custLost) {
		custLostDAO.edit(custLost);

	}

	@Override
	public void edit3(CustLost custLost) {
		custLostDAO.edit3(custLost);
	}

	@Override
	public void del(CustLost custLost) {
		custLostDAO.del(custLost);
	}

	@Override
	public CustLost load(CustLost custLost) {

		return custLostDAO.load(custLost);
	}

	@Override
	public List<CustLost> list(CustLost custLost, PageBean pageBean) {
		return custLostDAO.list(custLost, pageBean);
	}

}
