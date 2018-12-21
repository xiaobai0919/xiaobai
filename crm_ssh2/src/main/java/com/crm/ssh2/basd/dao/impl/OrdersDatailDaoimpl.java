package com.crm.ssh2.basd.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.ssh2.basd.dao.IOrdersDetailDAO;
import com.crm.ssh2.basd.entity.OrdersDetail;
import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.util.PageBean;

public class OrdersDatailDaoimpl extends BaseDao implements IOrdersDetailDAO {

	private static final long serialVersionUID = -6467083385205391357L;

	@Override
	public List<OrdersDetail> list(OrdersDetail ordersDetail, PageBean pageBean) {
		String hql = " from OrdersDetail where 1=1";
		Map<String, Object> args = new HashMap<String, Object>();
		if (null != ordersDetail.getBoId()) {
			hql += " and boId = :bo_id";
			args.put("bo_id", ordersDetail.getBoId());
		}
		return this.executeQuery(hql, args, pageBean);
	}

	@Override
	public List<OrdersDetail> list2(OrdersDetail ordersDetail, PageBean pageBean) {
		String hql = " from OrdersDetail where 1=1";
		Map<String, Object> args = new HashMap<String, Object>();
		if (null != ordersDetail.getBoId()) {
			hql += " and boId = :bo_id";
			args.put("bo_id", ordersDetail.getBoId());
		}
		return this.executeQuery(hql, args, pageBean);
	}

}
