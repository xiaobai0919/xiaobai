package com.crm.ssh2.basd.action;

import java.util.List;

import javax.servlet.ServletOutputStream;

import com.crm.ssh2.basd.biz.IBasdOrdersBiz;
import com.crm.ssh2.basd.entity.BasdOrders;
import com.crm.ssh2.base.action.BaseAction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class BasdOrdersAction extends BaseAction implements ModelDriven<BasdOrders> {

	private BasdOrders basdOrders = new BasdOrders();

	private IBasdOrdersBiz basdOrdersBiz;

	public IBasdOrdersBiz getBasdOrdersBiz() {
		return basdOrdersBiz;
	}

	public void setBasdOrdersBiz(IBasdOrdersBiz basdOrdersBiz) {
		this.basdOrdersBiz = basdOrdersBiz;
	}

	@Override
	public BasdOrders getModel() {
		return basdOrders;
	}

	public String add() {
		basdOrdersBiz.add(basdOrders);
		this.message = "新增成功";
		return SUCCESS;
	}

	public String edit() {
		basdOrdersBiz.edit(basdOrders);
		this.message = "修改成功";
		return SUCCESS;
	}

	public String del() {
		basdOrdersBiz.del(basdOrders);
		this.message = "删除成功";
		return SUCCESS;
	}

	public String load() {
		this.result = basdOrdersBiz.load(basdOrders);
		return this.getForward(EDIT);
	}

	public String list() throws Exception {
		List<BasdOrders> BasdOrdersList = basdOrdersBiz.list(basdOrders, this.parsePageBean());

		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, BasdOrdersList);
		os.flush();

		return null;
	}

	public String list2() {
		String parameter = request.getParameter("boCustomer");
		basdOrders.setBoCustomer(parameter);
		List<BasdOrders> list2 = basdOrdersBiz.list2(basdOrders, this.parsePageBean());

		this.result = basdOrdersBiz.list2(basdOrders, this.parsePageBean());
		return LIST;
	}
}
