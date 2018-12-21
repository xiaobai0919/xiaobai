package com.crm.ssh2.basd.action;

import java.util.List;

import javax.servlet.ServletOutputStream;

import com.crm.ssh2.basd.biz.IOrdersDetailBiz;
import com.crm.ssh2.basd.entity.BasdOrders;
import com.crm.ssh2.basd.entity.OrdersDetail;
import com.crm.ssh2.base.action.BaseAction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class OrdersDetailAction extends BaseAction implements ModelDriven<OrdersDetail>{

	private OrdersDetail ordersDetail = new OrdersDetail();
	private IOrdersDetailBiz ordersDetailBiz;
	
	@Override
	public OrdersDetail getModel() {
		return ordersDetail;
	}

	public IOrdersDetailBiz getOrdersDetailBiz() {
		return ordersDetailBiz;
	}

	public void setOrdersDetailBiz(IOrdersDetailBiz ordersDetailBiz) {
		this.ordersDetailBiz = ordersDetailBiz;
	}
	
	public String list() throws Exception {
		
		String parameter = request.getParameter("boId");
		List<OrdersDetail> ordersDetaillist = ordersDetailBiz.list(ordersDetail, this.parsePageBean());

		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, ordersDetaillist);
		os.flush();

		return null;
	}
	
	
	public String list2(){
		String parameter = request.getParameter("boId");
		System.out.println("订单编号："+parameter);
		ordersDetail.setBoId(Integer.parseInt(parameter));
		this.result = ordersDetailBiz.list2(ordersDetail, this.parsePageBean());
		return LIST;
	}
	

}
