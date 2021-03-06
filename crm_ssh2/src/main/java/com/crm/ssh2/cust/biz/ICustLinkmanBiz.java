package com.crm.ssh2.cust.biz;

import java.util.List;

import com.crm.ssh2.cust.entity.CustLinkman;
import com.crm.ssh2.util.PageBean;

public interface ICustLinkmanBiz {

	void add(CustLinkman custLinkman);

	void edit(CustLinkman custLinkman);

	void del(CustLinkman custLinkman);

	CustLinkman load(CustLinkman custLinkman);

	List<CustLinkman> list(CustLinkman custLinkman, PageBean pageBean);
	
	List<CustLinkman> list2(CustLinkman custLinkman, PageBean pageBean);
}
