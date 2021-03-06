package com.crm.ssh2.basd.dao;

import java.util.List;

import com.crm.ssh2.basd.entity.BasdOrdersLine;
import com.crm.ssh2.util.PageBean;

public interface IBasdOrdersLineDao {
	
	void add(BasdOrdersLine basdOrdersLine);
	
	void edit(BasdOrdersLine basdOrdersLine);
	
	void del(BasdOrdersLine basdOrdersLine);
	
	BasdOrdersLine load(BasdOrdersLine basdOrdersLine);
	
	List<BasdOrdersLine> list(BasdOrdersLine basdOrdersLine,PageBean pageBean);
}
