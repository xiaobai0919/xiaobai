package com.crm.ssh2.cust.biz.impl;

import java.util.List;

import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.cust.biz.ICustCustomerBiz;
import com.crm.ssh2.cust.dao.ICustCustomerDAO;
import com.crm.ssh2.cust.entity.CustCustomer;
import com.crm.ssh2.util.PageBean;

public class CustCustomerBizImpl extends BaseBiz implements ICustCustomerBiz {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6815083426140018946L;

	private ICustCustomerDAO custCustomerDAO;

	public ICustCustomerDAO getCustCustomerDAO() {
		return custCustomerDAO;
	}

	public void setCustCustomerDAO(ICustCustomerDAO custCustomerDAO) {
		this.custCustomerDAO = custCustomerDAO;
	}

	@Override
	public void add(CustCustomer custCustomer) {
		// TODO Auto-generated method stub
		custCustomerDAO.add(custCustomer);
	}

	@Override
	public void edit(CustCustomer custCustomer) {
		// TODO Auto-generated method stub
		custCustomerDAO.edit(custCustomer);
	}

	@Override
	public void del(CustCustomer custCustomer) {
		// TODO Auto-generated method stub
		custCustomerDAO.del(custCustomer);
	}

	@Override
	public CustCustomer load(CustCustomer custCustomer) {
		// TODO Auto-generated method stub
		return custCustomerDAO.load(custCustomer);
	}

	@Override
	public List<CustCustomer> list(CustCustomer custCustomer, PageBean pageBean) {
		System.out.println("custCustomer"+custCustomer);
		return custCustomerDAO.list(custCustomer, pageBean);
	}

}
