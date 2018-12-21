package com.crm.ssh2.cust.biz.impl;

import java.util.List;

import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.cust.biz.ICustLinkmanBiz;
import com.crm.ssh2.cust.dao.ICustLinkmanDAO;
import com.crm.ssh2.cust.entity.CustLinkman;
import com.crm.ssh2.util.PageBean;

public class CustLinkmanBizImpl extends BaseBiz implements ICustLinkmanBiz {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4420335513990752012L;

	private ICustLinkmanDAO custLinkmanDAO;

	public ICustLinkmanDAO getCustLinkmanDAO() {
		return custLinkmanDAO;
	}

	public void setCustLinkmanDAO(ICustLinkmanDAO custLinkmanDAO) {
		this.custLinkmanDAO = custLinkmanDAO;
	}

	@Override
	public void add(CustLinkman custLinkman) {
		custLinkmanDAO.add(custLinkman);
	}

	@Override
	public void edit(CustLinkman custLinkman) {
		custLinkmanDAO.edit(custLinkman);

	}

	@Override
	public void del(CustLinkman custLinkman) {
		custLinkmanDAO.del(custLinkman);

	}

	@Override
	public CustLinkman load(CustLinkman custLinkman) {
		return custLinkmanDAO.load(custLinkman);
	}

	@Override
	public List<CustLinkman> list(CustLinkman custLinkman, PageBean pageBean) {
		return custLinkmanDAO.list(custLinkman, pageBean);
	}

	@Override
	public List<CustLinkman> list2(CustLinkman custLinkman, PageBean pageBean) {
		// TODO Auto-generated method stub
		 return custLinkmanDAO.list2(custLinkman, pageBean);
	}

}
