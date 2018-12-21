package com.crm.ssh2.cust.biz;

import java.util.List;

import com.crm.ssh2.cust.entity.CustService;
import com.crm.ssh2.util.PageBean;

public interface ICustServiceBiz {

	void add(CustService custService);

	void edit(CustService custService);

	void del(CustService custService);

	CustService load(CustService custService);

	List<CustService> list(String str,CustService custService, PageBean pageBean);
	
	Integer getMaxCsId();
	
	void editCL(CustService custService);
	
	void editFK(CustService custService);
}
