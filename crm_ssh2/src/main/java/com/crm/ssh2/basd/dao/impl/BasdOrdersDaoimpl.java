package com.crm.ssh2.basd.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.ssh2.basd.dao.IBasdOrdersDao;
import com.crm.ssh2.basd.entity.BasdOrders;
import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class BasdOrdersDaoimpl extends BaseDao implements IBasdOrdersDao {

	private static final long serialVersionUID = -6467083385205391357L;

	@Override
	public void add(BasdOrders basdOrders) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(BasdOrders basdOrders) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(BasdOrders basdOrders) {
		// TODO Auto-generated method stub

	}

	@Override
	public BasdOrders load(BasdOrders basdOrders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BasdOrders> list(BasdOrders basdOrders, PageBean pageBean) {
		String hql = " from BasdOrders where 1=1";
		Map<String, Object> args = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(basdOrders.getBoCustomer())) {
			hql += " and boCustomer like :bo_customer";
			args.put("bo_customer", "%" + basdOrders.getBoCustomer().trim() + "%");
		}
		return this.executeQuery(hql, args, pageBean);
	}

	@Override
	public List<BasdOrders> list2(BasdOrders basdOrders, PageBean pageBean) {
		String hql = " from BasdOrders where 1=1";
		Map<String, Object> args = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(basdOrders.getBoCustomer())) {
			hql += " and boCustomer = :bo_customer";
			args.put("bo_customer", basdOrders.getBoCustomer().trim());
		}
		return this.executeQuery(hql, args, pageBean);
	}

}
