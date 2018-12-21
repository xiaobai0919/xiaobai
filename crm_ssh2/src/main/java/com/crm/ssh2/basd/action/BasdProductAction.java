package com.crm.ssh2.basd.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.crm.ssh2.basd.biz.IBasdProductBiz;
import com.crm.ssh2.basd.entity.BasdProduct;
import com.crm.ssh2.base.action.BaseAction;
import com.crm.ssh2.util.PageBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class BasdProductAction extends BaseAction implements ModelDriven<BasdProduct> {

	private BasdProduct basdProduct = new BasdProduct();

	private IBasdProductBiz basdProductBiz;

	public IBasdProductBiz getBasdProductBiz() {
		return basdProductBiz;
	}

	public void setBasdProductBiz(IBasdProductBiz basdProductBiz) {
		this.basdProductBiz = basdProductBiz;
	}

	@Override
	public BasdProduct getModel() {
		return basdProduct;
	}
	
	public String add() {
		basdProductBiz.add(basdProduct);
		this.message = "新增成功";
		return SUCCESS;
	}
	
	public String edit() {
		basdProductBiz.edit(basdProduct);
		this.message = "修改成功";
		return SUCCESS;
	}
	
	public String del() {
		basdProductBiz.del(basdProduct);
		this.message = "删除成功";
		return SUCCESS;
	}
	
	public String load() {
		this.result = this.basdProductBiz.load(basdProduct);
		return this.getForward(EDIT);
	}
	
	public String list() throws IOException {
		List<BasdProduct> basdProductList = basdProductBiz.list(basdProduct,this.parsePageBean());
		
		//获得输出流
		ServletOutputStream os = response.getOutputStream();
		//分页操作
		PageBean pageBean = new PageBean();
		pageBean.setRequest(request);
		request.setAttribute("pageBean", pageBean);
		//组装datagrid对象所需要json数组
		Map<String, Object> data = new HashMap<String, Object>();
		//写入键、值
		data.put("total", pageBean.getTotal());
		data.put("rows", basdProductList);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}
}
