package com.crm.ssh2.sale.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.crm.ssh2.base.biz.BaseBiz;
import com.crm.ssh2.sale.biz.ISaleChanceBiz;
import com.crm.ssh2.sale.dao.ISaleChanceDAO;
import com.crm.ssh2.sale.entity.SaleChance;
import com.crm.ssh2.util.PageBean;

public class SaleChanceBizImpl extends BaseBiz implements ISaleChanceBiz {

	private static final long serialVersionUID = -3548074517933223800L;
	
	private ISaleChanceDAO saleChanceDAO;
	
	public ISaleChanceDAO getSaleChanceDAO() {
		return saleChanceDAO;
	}
	public void setSaleChanceDAO(ISaleChanceDAO saleChanceDAO) {
		this.saleChanceDAO = saleChanceDAO;
	}
	
	public SaleChanceBizImpl() {
		
	}

	@Override
	public void add(SaleChance saleChance) {
		saleChanceDAO.add(saleChance);
	}

	@Override
	public void edit(SaleChance saleChance) {
		saleChanceDAO.edit(saleChance);
	}

	@Override
	public void del(SaleChance saleChance) {
		saleChanceDAO.del(saleChance);
	}

	@Override
	public SaleChance load(SaleChance saleChance) {
		return saleChanceDAO.load(saleChance);
	}

	@Override
	public List<SaleChance> list(String str,SaleChance saleChance, PageBean pageBean) {
		return saleChanceDAO.list(str,saleChance, pageBean);
	}
	
	@Override
	public Integer dogetMaxScId() {
		return saleChanceDAO.dogetMaxScId();
	}
	@Override
	public void ZP(SaleChance saleChance) {
		saleChanceDAO.ZP(saleChance);
	}

	@Override
	public List<SaleChance> loadJH(SaleChance saleChance) {
		return saleChanceDAO.loadJH(saleChance);
	}
	@Override
	public void editStatus(SaleChance saleChance) {
		saleChanceDAO.editStatus(saleChance);
	}

}
