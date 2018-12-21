package com.crm.ssh2.basd.biz;

import java.util.List;

import com.crm.ssh2.basd.entity.BasdOrders;
import com.crm.ssh2.util.PageBean;

public interface IBasdOrdersBiz {
	
	void add(BasdOrders basdOrders);
	
	void edit(BasdOrders basdOrders);
	
	void del(BasdOrders basdOrders);
	
	BasdOrders load(BasdOrders basdOrders);
	
	List<BasdOrders> list(BasdOrders basdOrders,PageBean pageBean);
	
	List<BasdOrders> list2(BasdOrders basdOrders,PageBean pageBean);
}
