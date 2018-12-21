package com.crm.ssh2.cust.dao;

import java.util.List;

import com.crm.ssh2.cust.entity.CustCustomer;
import com.crm.ssh2.util.PageBean;

public interface ICustCustomerDAO {

	void add(CustCustomer custCustomer);

	void edit(CustCustomer custCustomer);

	void del(CustCustomer custCustomer);

	CustCustomer load(CustCustomer custCustomer);

	List<CustCustomer> list(CustCustomer custCustomer,PageBean pageBean);
}
