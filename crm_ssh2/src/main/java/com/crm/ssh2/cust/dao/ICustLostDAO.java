package com.crm.ssh2.cust.dao;

import java.util.List;

import com.crm.ssh2.cust.entity.CustLost;
import com.crm.ssh2.util.PageBean;

public interface ICustLostDAO {

	void add(CustLost custLost);

	void edit(CustLost custLost);
	
	void edit3(CustLost custLost);

	void del(CustLost custLost);

	CustLost load(CustLost custLost);

	List<CustLost> list(CustLost custLost,PageBean pageBean);
}
