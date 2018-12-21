package com.crm.ssh2.cust.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.crm.ssh2.base.action.BaseAction;
import com.crm.ssh2.cust.biz.ICustLinkmanBiz;
import com.crm.ssh2.cust.entity.CustLinkman;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class CustLinkmanAction extends BaseAction implements ModelDriven<CustLinkman> {

	private CustLinkman custLinkman = new CustLinkman();
	private ICustLinkmanBiz custLinkmanBiz;

	@Override
	public CustLinkman getModel() {
		return custLinkman;
	}

	public ICustLinkmanBiz getCustLinkmanBiz() {
		return custLinkmanBiz;
	}

	public void setCustLinkmanBiz(ICustLinkmanBiz custLinkmanBiz) {
		this.custLinkmanBiz = custLinkmanBiz;
	}

	public CustLinkmanAction() {
		super();
	}

	public String add() throws Exception {
		System.out.println("我来了LinkmanAction");
		System.out.println("客户编号"+custLinkman.getClkCustNo());
		System.out.println("客户姓名"+custLinkman.getClkCustName());
		
		custLinkmanBiz.add(custLinkman);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("message", "新增联系人"); 
		data.put("code", 0); 
		
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, data);
		os.flush();
		
		return null;
	}

	public String del() throws Exception {
		System.out.println("进入delAction没？");
		custLinkmanBiz.del(custLinkman);
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
		custLinkmanBiz.edit(custLinkman);
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
		this.result = this.custLinkmanBiz.load(custLinkman);
		return this.getForward(EDIT);
	}

	public String list() throws Exception {
		List<CustLinkman> custLinkmanList = custLinkmanBiz.list(custLinkman, this.parsePageBean());

		for (CustLinkman custLinkman : custLinkmanList) {
			System.out.println(custLinkman);
		}

		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, custLinkmanList);
		os.flush();

		return null;
	}

	public String list2() throws Exception {
		this.result = custLinkmanBiz.list2(custLinkman, this.parsePageBean());

		return LIST;
	}

}
