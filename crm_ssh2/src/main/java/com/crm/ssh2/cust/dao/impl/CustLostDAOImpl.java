package com.crm.ssh2.cust.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.cust.dao.ICustLostDAO;
import com.crm.ssh2.cust.entity.CustLost;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class CustLostDAOImpl extends BaseDao implements ICustLostDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6575510375539184149L;

	@Override
	public void add(CustLost custLost) {
		this.getHibernateTemplate().save(custLost);

	}

	/* 暂缓流失 */
	@Override
	public void edit(CustLost custLost) {
		CustLost load = this.getHibernateTemplate().load(CustLost.class, custLost.getClId());
		if (null != load) {
			load.setClStatus("2");
			load.setClReason(custLost.getClReason());
		}
	}

	/* 确认流失 */
	@Override
	public void edit3(CustLost custLost) {
		CustLost load = this.getHibernateTemplate().load(CustLost.class, custLost.getClId());
		if (null != load) {
			load.setClStatus("3");
			load.setClReason(custLost.getClReason());
		}
	}

	@Override
	public void del(CustLost custLost) {
		CustLost load = this.getHibernateTemplate().get(CustLost.class, custLost.getClCustNo());
		if (null != load) {
			this.getHibernateTemplate().delete(load);
		}

	}

	@Override
	public CustLost load(CustLost custLost) {
		CustLost load = this.getHibernateTemplate().get(CustLost.class, custLost.getClCustNo());
		return load;
	}

	@Override
	public List<CustLost> list(CustLost custLost, PageBean pageBean) {
		String hql = " from CustLost where 1=1 ";
		Map<String, Object> args = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(custLost.getClCustName())) {
			hql += " and clCustName like :cl_cust_name";
			args.put("cl_cust_name", "%" + custLost.getClCustName().trim() + "%");
		}
		return this.executeQuery(hql, args, pageBean);
	}

}
