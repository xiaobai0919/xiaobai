package com.crm.ssh2.sale.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.crm.ssh2.base.action.BaseAction;
import com.crm.ssh2.sale.biz.ISalePlanBiz;
import com.crm.ssh2.sale.entity.SaleChance;
import com.crm.ssh2.sale.entity.SalePlan;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class SalePlanAction extends BaseAction implements ModelDriven<SalePlan> {

	private SalePlan salePlan = new SalePlan();
	private ISalePlanBiz salePlanBiz;

	@Override
	public SalePlan getModel() {
		return salePlan;
	}

	public ISalePlanBiz getSalePlanBiz() {
		return salePlanBiz;
	}

	public void setSalePlanBiz(ISalePlanBiz salePlanBiz) {
		this.salePlanBiz = salePlanBiz;
	}

	public SalePlanAction() {
		super();
	}

	public String add() throws IOException {
		SaleChance saleChance = new SaleChance();
		String scId = request.getParameter("scId");
		saleChance.setScId(Integer.parseInt(scId));
		salePlan.setSaleChance(saleChance);
		
		String spDate = request.getParameter("spDate");
		String spTodo = request.getParameter("spTodo");
		salePlan.setSpDate(spDate);
		salePlan.setSpTodo(spTodo);
		
		salePlanBiz.add(salePlan);
		
//		//获得输出流
		ServletOutputStream os = response.getOutputStream();
//		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
//		//写入键值
		data.put("message", "增加计划成功");//数据集合
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}

	public String del() throws IOException {
		salePlanBiz.del(salePlan);
		
		//获得输出流
		ServletOutputStream os = response.getOutputStream();
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键值
		data.put("message", "删除成功");//数据集合
		data.put("scId", salePlan.getScId());
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return SUCCESS;
	}

	public String edit() throws IOException {
		salePlanBiz.edit(salePlan);
		
		//获得输出流
		ServletOutputStream os = response.getOutputStream();
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键值
		data.put("message", "修改成功");//数据集合
		data.put("scId", salePlan.getScId());
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}

	public String load() {
		this.result = this.salePlanBiz.load(salePlan);
		return this.getForward(EDIT);
	}

	public String list() {
		this.result = this.salePlanBiz.list(salePlan, this.parsePageBean());
		return LIST;
	}

}
