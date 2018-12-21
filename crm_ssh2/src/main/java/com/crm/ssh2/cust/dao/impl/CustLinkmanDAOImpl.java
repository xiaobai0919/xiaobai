package com.crm.ssh2.cust.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.cust.dao.ICustLinkmanDAO;
import com.crm.ssh2.cust.entity.CustLinkman;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class CustLinkmanDAOImpl extends BaseDao implements ICustLinkmanDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5935372171716105405L;

	@Override
	public void add(CustLinkman custLinkman) {
		this.getHibernateTemplate().save(custLinkman);
	}

	@Override
	public void edit(CustLinkman custLinkman) {
		CustLinkman load = this.getHibernateTemplate().load(CustLinkman.class, custLinkman.getClkID());
		if (null != load) {
			load.setClkName(custLinkman.getClkName());
			load.setClkPostion(custLinkman.getClkPostion());
			load.setClkTel(custLinkman.getClkTel());
			load.setClkMobile(custLinkman.getClkMobile());
			load.setClkMenu(custLinkman.getClkMenu());
		}
	}

	@Override
	public void del(CustLinkman custLinkman) {
		CustLinkman ck = this.getHibernateTemplate().load(CustLinkman.class, custLinkman.getClkID());
		if(null!=ck) {
			this.getHibernateTemplate().delete(custLinkman);
		}
	}

	@Override
	public CustLinkman load(CustLinkman custLinkman) {
		CustLinkman load = this.getHibernateTemplate().get(CustLinkman.class, custLinkman.getClkID());
		return load;
	}

	@Override
	public List<CustLinkman> list(CustLinkman custLinkman, PageBean pageBean) {
		String hql = " from CustLinkman where 1=1";
		Map<String, Object> args = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(custLinkman.getClkCustNo())) {
			hql += " and clkCustNo like :clk_cust_no";
			args.put("clk_cust_no", "%" + custLinkman.getClkCustNo().trim() + "%");
		}
		return this.executeQuery(hql, args, pageBean);
	}

	@Override
	public List<CustLinkman> list2(CustLinkman custLinkman, PageBean pageBean) {
		String hql = " from CustLinkman where 1=1";
		Map<String, Object> args = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(custLinkman.getClkCustNo())) {
			hql += " and clkCustNo =:clk_cust_no";
			args.put("clk_cust_no",  custLinkman.getClkCustNo().trim());
		}
		return this.executeQuery(hql, args, pageBean);
	}

}
