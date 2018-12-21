package com.crm.ssh2.cust.biz;

import java.util.List;

import com.crm.ssh2.cust.entity.CustActivity;
import com.crm.ssh2.util.PageBean;

public interface ICustActivityBiz {

	void add(CustActivity custActivity);

	void edit(CustActivity custActivity);

	void del(CustActivity custActivity);

	CustActivity load(CustActivity custActivity);

	List<CustActivity> list(CustActivity custActivity,PageBean pageBean);
	
	List<CustActivity> list2(CustActivity custActivity,PageBean pageBean);
}
