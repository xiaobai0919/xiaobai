package com.crm.ssh2.cust.biz.impl;

import java.util.List;

import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.cust.biz.ICustActivityBiz;
import com.crm.ssh2.cust.dao.ICustActivityDAO;
import com.crm.ssh2.cust.entity.CustActivity;
import com.crm.ssh2.util.PageBean;

public class CustActivityBizImpl extends BaseBiz implements ICustActivityBiz {

	/**
	 * 
	 */  
	private static final long serialVersionUID = -1110292550392282878L;

	private ICustActivityDAO custActivityDAO;

	public ICustActivityDAO getCustActivityDAO() {
		return custActivityDAO;
	}

	public void setCustActivityDAO(ICustActivityDAO custActivityDAO) {
		this.custActivityDAO = custActivityDAO;
	}

	@Override
	public void add(CustActivity custActivity) {
		custActivityDAO.add(custActivity);

	}

	@Override
	public void edit(CustActivity custActivity) {
		custActivityDAO.edit(custActivity);

	}

	@Override
	public void del(CustActivity custActivity) {
		custActivityDAO.del(custActivity);

	}

	@Override
	public CustActivity load(CustActivity custActivity) {
		// TODO Auto-generated method stub
		return custActivityDAO.load(custActivity);
	}

	@Override
	public List<CustActivity> list(CustActivity custActivity, PageBean pageBean) {
		// TODO Auto-generated method stub
		return custActivityDAO.list(custActivity, pageBean);
	}

	@Override
	public List<CustActivity> list2(CustActivity custActivity, PageBean pageBean) {
		// TODO Auto-generated method stub
		return custActivityDAO.list2(custActivity, pageBean);
	}

}
