package com.crm.ssh2.cust.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.cust.dao.ICustActivityDAO;
import com.crm.ssh2.cust.entity.CustActivity;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class CustActivityDAOImpl extends BaseDao implements ICustActivityDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8709652706800330415L;

	@Override
	public void add(CustActivity custActivity) {
		this.getHibernateTemplate().save(custActivity);
	}

	@Override
	public void edit(CustActivity custActivity) {
		CustActivity load = this.getHibernateTemplate().load(CustActivity.class, custActivity.getCaID());
		if(null!=load) {
			load.setCaDate(custActivity.getCaDate());
			load.setCaPlace(custActivity.getCaPlace());
			load.setCaTitle(custActivity.getCaTitle());
			load.setCaRemark(custActivity.getCaRemark());
			load.setCaDesc(custActivity.getCaDesc());
		}

	}

	@Override
	public void del(CustActivity custActivity) {
		CustActivity load = this.getHibernateTemplate().load(CustActivity.class, custActivity.getCaID());
		if (null != load) {
			this.getHibernateTemplate().delete(custActivity);
		}

	}

	@Override
	public CustActivity load(CustActivity custActivity) {
		CustActivity load = this.getHibernateTemplate().get(CustActivity.class, custActivity.getCaID());
		return load;
	}

	@Override
	public List<CustActivity> list(CustActivity custActivity, PageBean pageBean) {
		String hql = " from CustActivity where 1=1";
		Map<String, Object> args = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(custActivity.getCaCustNo())) {
			hql += " and caCustNo like :ca_cust_no";
			args.put("ca_cust_no", "%" + custActivity.getCaCustNo().trim() + "%");
		}
		return this.executeQuery(hql, args, pageBean);
	}

	@Override
	public List<CustActivity> list2(CustActivity custActivity, PageBean pageBean) {
		String hql = " from CustActivity where 1=1";
		Map<String, Object> args = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(custActivity.getCaCustNo())) {
			hql += " and caCustNo =:ca_cust_no";
			args.put("ca_cust_no", custActivity.getCaCustNo().trim());
		}
		return this.executeQuery(hql, args, pageBean);
	}

}
