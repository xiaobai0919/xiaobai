package com.crm.ssh2.basd.dao;

import java.util.List;

import com.crm.ssh2.basd.entity.OrdersDetail;
import com.crm.ssh2.util.PageBean;

public interface IOrdersDetailDAO {

	List<OrdersDetail> list(OrdersDetail ordersDetail,PageBean pageBean);
	
	List<OrdersDetail> list2(OrdersDetail ordersDetail,PageBean pageBean);
}
