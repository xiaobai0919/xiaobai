package com.crm.ssh2.sale.dao;

import java.util.List;

import com.crm.ssh2.sale.entity.SaleChance;
import com.crm.ssh2.util.PageBean;

public interface ISaleChanceDAO {
	void editStatus(SaleChance saleChance);
	//取制定计划里的营销信息与执行计划
	List<SaleChance> loadJH(SaleChance saleChance);
	//指派
	void ZP(SaleChance saleChance);
	//取编号最大值
	Integer dogetMaxScId();
	//增加
	void add(SaleChance saleChance);
	//修改
	void edit(SaleChance saleChance);
	//删除
	void del(SaleChance saleChance);
	//查单个
	SaleChance load(SaleChance saleChance);
	//所有
	List<SaleChance> list(String str,SaleChance saleChance, PageBean pageBean);
}
