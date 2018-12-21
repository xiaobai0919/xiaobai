package com.crm.ssh2.cust.action;

import com.crm.ssh2.base.action.BaseAction;
import com.crm.ssh2.cust.biz.ICustCustomerBiz;
import com.crm.ssh2.cust.entity.CustCustomer;
import com.opensymphony.xwork2.ModelDriven;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

public class CustCustomerAction extends BaseAction implements ModelDriven<CustCustomer> {

	private CustCustomer custCustomer = new CustCustomer();
	private ICustCustomerBiz custCustomerBiz;

	@Override
	public CustCustomer getModel() {
		return custCustomer;
	}

	public ICustCustomerBiz getCustCustomerBiz() {
		return custCustomerBiz;
	}

	public void setCustCustomerBiz(ICustCustomerBiz custCustomerBiz) {
		this.custCustomerBiz = custCustomerBiz;
	}

	public String add() {
		custCustomerBiz.add(custCustomer);
		this.message = "增加成功";
		return SUCCESS;
	}

	public String del() throws Exception {
		custCustomerBiz.del(custCustomer);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("message", "删除成功");
		data.put("code", 0);
		
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, data);
		os.flush();
		
		return null;
	}

	public String edit() throws Exception {
		custCustomerBiz.edit(custCustomer);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("message", "修改成功"); 
		data.put("code", 0); 
		
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, data);
		os.flush();
		
		return null;
	}

	public String load() {
		this.result = this.custCustomerBiz.load(custCustomer);
		return this.getForward(EDIT);
	}

	public String list() throws IOException {
		System.out.println("到了Action");
		List<CustCustomer> custCustomerList = custCustomerBiz.list(custCustomer, this.parsePageBean());

		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, custCustomerList);
		os.flush();

		return null;
	}
	
}
