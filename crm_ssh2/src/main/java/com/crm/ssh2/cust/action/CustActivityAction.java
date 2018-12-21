package com.crm.ssh2.cust.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.crm.ssh2.base.action.BaseAction;
import com.crm.ssh2.cust.biz.ICustActivityBiz;
import com.crm.ssh2.cust.entity.CustActivity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class CustActivityAction extends BaseAction implements ModelDriven<CustActivity> {

	private CustActivity custActivity = new CustActivity();
	private ICustActivityBiz custActivityBiz;

	@Override
	public CustActivity getModel() {
		return custActivity;
	}

	public ICustActivityBiz getCustActivityBiz() {
		return custActivityBiz;
	}

	public void setCustActivityBiz(ICustActivityBiz custActivityBiz) {
		this.custActivityBiz = custActivityBiz;
	}

	public CustActivityAction() {
		super();
	}

	public String add() throws Exception {
		custActivityBiz.add(custActivity);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("message", "新增记录"); 
		data.put("code", 0); 
		
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, data);
		os.flush();
		
		return null;
	}

	public String del() throws Exception {
		custActivityBiz.del(custActivity);
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
		custActivityBiz.edit(custActivity);
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
		this.result = this.custActivityBiz.load(custActivity);
		return this.getForward(EDIT);
	}

	public String list() throws Exception {
		List<CustActivity> CustActivityList = this.custActivityBiz.list(custActivity, this.parsePageBean());

		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, CustActivityList);
		os.flush();
		return null;
	}

	public String list2() throws Exception {
		this.result = custActivityBiz.list2(custActivity, this.parsePageBean());

		return LIST;
	}

}
