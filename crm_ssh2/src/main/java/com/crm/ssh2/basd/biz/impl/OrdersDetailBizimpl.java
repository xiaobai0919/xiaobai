package com.crm.ssh2.basd.biz.impl;

import java.util.List;

import com.crm.ssh2.basd.biz.IOrdersDetailBiz;
import com.crm.ssh2.basd.dao.IOrdersDetailDAO;
import com.crm.ssh2.basd.entity.OrdersDetail;
import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.util.PageBean;

public class OrdersDetailBizimpl extends BaseBiz implements IOrdersDetailBiz {

	private static final long serialVersionUID = 3340859933509058117L;

	private IOrdersDetailDAO ordersDetailDAO;

	public IOrdersDetailDAO getOrdersDetailDAO() {
		return ordersDetailDAO;
	}

	public void setOrdersDetailDAO(IOrdersDetailDAO ordersDetailDAO) {
		this.ordersDetailDAO = ordersDetailDAO;
	}

	@Override
	public List<OrdersDetail> list(OrdersDetail ordersDetail, PageBean pageBean) {
		return ordersDetailDAO.list(ordersDetail, pageBean);
	}

	@Override
	public List<OrdersDetail> list2(OrdersDetail ordersDetail, PageBean pageBean) {
		return ordersDetailDAO.list2(ordersDetail, pageBean);
	}

}
