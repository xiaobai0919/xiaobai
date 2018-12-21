package com.crm.ssh2.basd.biz;

import java.util.List;

import com.crm.ssh2.basd.entity.OrdersDetail;
import com.crm.ssh2.util.PageBean;

public interface IOrdersDetailBiz {
	
	List<OrdersDetail> list(OrdersDetail ordersDetail,PageBean pageBean);
	
	List<OrdersDetail> list2(OrdersDetail ordersDetail,PageBean pageBean);
}
