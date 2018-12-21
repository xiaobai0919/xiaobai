package com.crm.ssh2.basd.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.crm.ssh2.basd.biz.IBasdStorageBiz;
import com.crm.ssh2.basd.entity.BasdStorage;
import com.crm.ssh2.base.action.BaseAction;
import com.crm.ssh2.sale.entity.SaleChance;
import com.crm.ssh2.util.PageBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class BasdStorageAction extends BaseAction implements ModelDriven<BasdStorage> {

	private BasdStorage basdStorage = new BasdStorage();

	private IBasdStorageBiz basdStorageBiz;

	public IBasdStorageBiz getBasdStorageBiz() {
		return basdStorageBiz;
	}

	public void setBasdStorageBiz(IBasdStorageBiz basdStorageBiz) {
		this.basdStorageBiz = basdStorageBiz;
	}

	@Override
	public BasdStorage getModel() {
		return basdStorage;
	}
	
	public String add() {
		basdStorageBiz.add(basdStorage);
		this.message = "新增成功";
		return SUCCESS;
	}
	
	public String edit() {
		basdStorageBiz.edit(basdStorage);
		this.message = "修改成功";
		return SUCCESS;
	}
	
	public String del() {
		basdStorageBiz.del(basdStorage);
		this.message = "删除成功";
		return SUCCESS;
	}
	
	public String load() {
		this.result = this.basdStorageBiz.load(basdStorage);
		return this.getForward(EDIT);
	}
	
	public String list() throws IOException {
		//获得输出流
		ServletOutputStream os = response.getOutputStream();
		//分页操作
		PageBean pageBean = new PageBean();
		pageBean.setRequest(request);
		request.setAttribute("pageBean", pageBean);
		//查询数据
		List<BasdStorage> basdStorageList = basdStorageBiz.list(basdStorage, pageBean);
		System.out.println(basdStorageList.size()+"++++++++++++++++++++++");
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键值
		data.put("total", pageBean.getTotal());//总页数
		data.put("rows", basdStorageList);//数据集合
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}
}
