package com.crm.ssh2.sale.biz.impl;

import java.util.List;

import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.sale.biz.ISalePlanBiz;
import com.crm.ssh2.sale.dao.ISalePlanDAO;
import com.crm.ssh2.sale.entity.SalePlan;
import com.crm.ssh2.util.PageBean;

public class SalePlanBizImpl extends BaseBiz implements ISalePlanBiz {

	private static final long serialVersionUID = 1057956748635895957L;
	
	private ISalePlanDAO salePlanDao;
	
	public ISalePlanDAO getSalePlanDao() {
		return salePlanDao;
	}
	public void setSalePlanDao(ISalePlanDAO salePlanDao) {
		this.salePlanDao = salePlanDao;
	}
	
	public SalePlanBizImpl() {
		
	}

	@Override
	public void add(SalePlan salePlan) {
		salePlanDao.add(salePlan);
	}

	@Override
	public void edit(SalePlan salePlan) {
		salePlanDao.edit(salePlan);
	}

	@Override
	public void del(SalePlan salePlan) {
		salePlanDao.del(salePlan);
	}

	@Override
	public SalePlan load(SalePlan salePlan) {
		return salePlanDao.load(salePlan);
	}

	@Override
	public List<SalePlan> list(SalePlan salePlan, PageBean pageBean) {
		return salePlanDao.list(salePlan,pageBean);
	}

}
