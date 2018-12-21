package com.crm.ssh2.sale.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.sale.biz.ISaleChanceBiz;
import com.crm.ssh2.sale.biz.impl.SaleChanceBizImpl;
import com.crm.ssh2.sale.dao.ISalePlanDAO;
import com.crm.ssh2.sale.entity.SaleChance;
import com.crm.ssh2.sale.entity.SalePlan;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class SalePlanDAOImpl extends BaseDao implements ISalePlanDAO {

	private static final long serialVersionUID = 2288298060327396189L;

	@Override
	public void add(SalePlan salePlan) {
		this.getHibernateTemplate().save(salePlan);
	}

	@Override
	public void edit(SalePlan salePlan) {
		SalePlan sp = this.getHibernateTemplate().load(SalePlan.class, salePlan.getSpId());
		if(null!=sp) {
			sp.setSpId(salePlan.getSpId());
			sp.setScId(salePlan.getScId());
			sp.setSpDate(salePlan.getSpDate());
			sp.setSpTodo(salePlan.getSpTodo());
			sp.setSpResult(salePlan.getSpResult());
		}
	}

	@Override
	public void del(SalePlan salePlan) {
		SalePlan sp = this.getHibernateTemplate().load(SalePlan.class, salePlan.getSpId());
		if(null!=sp) {
			this.getHibernateTemplate().delete(salePlan);
		}
	}

	@Override
	public SalePlan load(SalePlan salePlan) {
		return this.getHibernateTemplate().get(SalePlan.class, salePlan.getSpId());
	}

	@Override
	public List<SalePlan> list(SalePlan salePlan, PageBean pageBean) {
		
		return null;
	}

}
