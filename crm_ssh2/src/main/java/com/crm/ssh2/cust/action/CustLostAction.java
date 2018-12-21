package com.crm.ssh2.cust.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.crm.ssh2.base.action.BaseAction;
import com.crm.ssh2.cust.biz.ICustLostBiz;
import com.crm.ssh2.cust.entity.CustLost;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class CustLostAction extends BaseAction implements ModelDriven<CustLost> {

	private CustLost custLost = new CustLost();
	private ICustLostBiz custLostBiz;

	@Override
	public CustLost getModel() {
		return custLost;
	}

	public ICustLostBiz getCustLostBiz() {
		return custLostBiz;
	}

	public void setCustLostBiz(ICustLostBiz custLostBiz) {
		this.custLostBiz = custLostBiz;
	}

	public CustLostAction() {
		super();
	}

	public String add() {
		custLostBiz.add(custLost);
		this.message = "增加成功";
		return SUCCESS;
	}

	public String del() {
		custLostBiz.del(custLost);
		this.message = "删除成功";
		return SUCCESS;
	}

	//暂缓流失
	public String edit() throws Exception {
		custLostBiz.edit(custLost);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("message", "保存成功"); 
		data.put("code", 0); 
		
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, data);
		os.flush();
		
		return null;
	}
	
	//确认流失
	public String edit3() throws Exception {
		custLostBiz.edit3(custLost);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("message", "保存成功"); 
		data.put("code", 0); 
		
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, data);
		os.flush();
		
		return null;
	}
	

	public String load() {
		this.result = this.custLostBiz.load(custLost);
		return this.getForward(EDIT);
	}

	public String list() throws Exception {
		List<CustLost> custLostList = custLostBiz.list(custLost, this.parsePageBean());
		
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, custLostList);
		os.flush();
		return null;
	}

}
