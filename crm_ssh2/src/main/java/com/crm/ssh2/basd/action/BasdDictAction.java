package com.crm.ssh2.basd.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.crm.ssh2.basd.biz.IBasdDictBiz;
import com.crm.ssh2.basd.entity.BasdDict;
import com.crm.ssh2.base.action.BaseAction;
import com.crm.ssh2.util.PageBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class BasdDictAction extends BaseAction implements ModelDriven<BasdDict> {

	private BasdDict basdDict = new BasdDict();
	private IBasdDictBiz basdDictBiz;

	public IBasdDictBiz getBasdDictBiz() {
		return basdDictBiz;
	}
	public void setBasdDictBiz(IBasdDictBiz basdDictBiz) {
		this.basdDictBiz = basdDictBiz;
	}

	@Override
	public BasdDict getModel() {
		return basdDict;
	}
	
	public String add() throws IOException {
		basdDictBiz.add(basdDict);

		//获得输出流response.getOutputStream();
		ServletOutputStream os = response.getOutputStream();
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键值
		data.put("message", "增加成功");
		data.put("code", 0);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}
	
	public String edit() throws IOException {
		System.out.println(basdDict.getBdValue()+"==============="+basdDict.getBdItem());
		basdDictBiz.edit(basdDict);
		
		//获得输出流response.getOutputStream();
		ServletOutputStream os = response.getOutputStream();
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键值
		data.put("message", "修改成功");
		data.put("code", 0);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}
	
	public String del() throws IOException {
		basdDictBiz.del(basdDict);
		
		//获得输出流response.getOutputStream();
		ServletOutputStream os = response.getOutputStream();
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键值
		data.put("message", "删除成功");
		data.put("code", 0);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}
	
	public String load() {
		BasdDict bd = basdDictBiz.load(basdDict);
		request.setAttribute("bd", bd);
		
		return "load";
	}
	
	public String list() throws IOException {
		//获得输出流response.getOutputStream();
		ServletOutputStream os = response.getOutputStream();
		//分页操作
		PageBean pageBean = new PageBean();
		pageBean.setRequest(request);
		request.setAttribute("pageBean", pageBean);
		
		//查询数据
		List<BasdDict> basdDictList = basdDictBiz.list(basdDict, pageBean);

		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键值
		data.put("total", pageBean.getTotal());//总页数
		data.put("rows", basdDictList);//数据集合
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}
	
	public String toadd() {
		Integer bdId = basdDictBiz.dogetMaxBdId();
		request.setAttribute("bdId", bdId+1);
		
		return ADD;
	}
	
	
}
