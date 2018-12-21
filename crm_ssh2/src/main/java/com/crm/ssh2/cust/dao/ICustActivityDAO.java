package com.crm.ssh2.cust.dao;

import java.util.List;

import com.crm.ssh2.cust.entity.CustActivity;
import com.crm.ssh2.util.PageBean;

public interface ICustActivityDAO {

	void add(CustActivity custActivity);

	void edit(CustActivity custActivity);

	void del(CustActivity custActivity);

	CustActivity load(CustActivity custActivity);

	List<CustActivity> list(CustActivity custActivity,PageBean pageBean);
	
	List<CustActivity> list2(CustActivity custActivity,PageBean pageBean);
}
