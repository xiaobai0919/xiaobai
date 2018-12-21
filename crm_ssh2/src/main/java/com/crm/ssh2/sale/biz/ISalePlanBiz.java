package com.crm.ssh2.sale.biz;

import java.util.List;

import com.crm.ssh2.sale.entity.SalePlan;
import com.crm.ssh2.util.PageBean;

public interface ISalePlanBiz {

	void add(SalePlan salePlan);

	void edit(SalePlan salePlan);

	void del(SalePlan salePlan);

	SalePlan load(SalePlan salePlan);

	List<SalePlan> list(SalePlan salePlan, PageBean pageBean);
}
