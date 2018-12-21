package com.crm.ssh2.basd.action;

import com.crm.ssh2.basd.biz.IBasdOrdersLineBiz;
import com.crm.ssh2.basd.entity.BasdOrdersLine;
import com.crm.ssh2.base.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class BasdOrdersLineAction extends BaseAction implements ModelDriven<BasdOrdersLine> {

	private BasdOrdersLine basdOrdersLine = new BasdOrdersLine();

	private IBasdOrdersLineBiz basdOrdersLineBiz;

	public IBasdOrdersLineBiz getBasdOrdersLineBiz() {
		return basdOrdersLineBiz;
	}

	public void setBasdOrdersLineBiz(IBasdOrdersLineBiz basdOrdersLineBiz) {
		this.basdOrdersLineBiz = basdOrdersLineBiz;
	}

	@Override
	public BasdOrdersLine getModel() {
		return basdOrdersLine;
	}
	
	public String add() {
		basdOrdersLineBiz.add(basdOrdersLine);
		this.message = "新增成功";
		return SUCCESS;
	}
	
	public String edit() {
		basdOrdersLineBiz.edit(basdOrdersLine);
		this.message = "修改成功";
		return SUCCESS;
	}
	
	public String del() {
		basdOrdersLineBiz.del(basdOrdersLine);
		this.message = "删除成功";
		return SUCCESS;
	}
	
	public String load() {
		this.result = this.basdOrdersLineBiz.load(basdOrdersLine);
		return this.getForward(EDIT);
	}
	
	public String list() {
		this.result = this.basdOrdersLineBiz.list(basdOrdersLine,this.parsePageBean());
		return LIST;
	}
}
