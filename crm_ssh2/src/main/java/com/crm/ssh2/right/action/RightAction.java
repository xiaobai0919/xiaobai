package com.crm.ssh2.right.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;

import com.crm.ssh2.base.action.BaseAction;
import com.crm.ssh2.right.biz.IRightBiz;
import com.crm.ssh2.right.entity.Right;
import com.crm.ssh2.right.entity.RightUser;
import com.crm.ssh2.util.PageBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class RightAction extends BaseAction implements ModelDriven<Right> {

	private Right right = new Right();
	private IRightBiz rightBiz;

	public IRightBiz getRightBiz() {
		return rightBiz;
	}
	public void setRightBiz(IRightBiz rightBiz) {
		this.rightBiz = rightBiz;
	}

	@Override
	public Right getModel() {
		return right;
	}
	
	public String list() throws ServletException, IOException {
		//获得输出流
		ServletOutputStream os = response.getOutputStream();
		//获得所有的功能
		RightUser ru = (RightUser)session.getAttribute("login");
		List<Right> rightList = null;
		if(null!=ru) {
			 rightList = rightBiz.list(right,ru);
		}
		//转换为指定的json格式
		List<Map<String, Object>> treeNodeList = new ArrayList<Map<String,Object>>();
		Map<String, Object> treeNode = null;
		Map<String, Object> attributes = null;//节点
		//循环获得到的所有功能
		for (Right r : rightList) {
			//实例化
			treeNode = new HashMap<String, Object>();
			
			//设置键值
			treeNode.put("id", r.getrCode());
			treeNode.put("text", r.getrText());
			treeNode.put("state", null!=r.getrParentCode()?"open":"closed");
			//绑定该节点的自定义属性
			attributes = new HashMap<String,Object>();
			//将功能所到的地址写入到attribute里
			attributes.put("url", null==r.getrUrl()?"":r.getrUrl().trim());
			treeNode.put("attributes", attributes);
			treeNodeList.add(treeNode);
		}
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, treeNodeList);
		os.flush();
		return null;
	}
	
	public String add() throws Exception {
		rightBiz.add(right); 
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("message", "增加成功"); 
		data.put("code", 0); 
		
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, data);
		os.flush();
		
		return null;
	}
	
	public String edit() throws Exception {
		rightBiz.edit(right);
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("message", "修改成功"); 
		data.put("code", 0); 
		
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, data);
		os.flush();
		
		return null;
	}
	
	public String del() throws Exception {
		rightBiz.del(right); 
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("message", "删除成功"); 
		data.put("code", 0); 
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, data);
		os.flush();
		return null;
	}
	
	public String load() {
		this.result = rightBiz.load(right);
		return this.getForward(EDIT);
	}
	
	public String lists() throws Exception {
		PageBean pageBean = this.parsePageBean();
 		List<Right> list2 = rightBiz.list(right,pageBean);
 		request.setAttribute("pageBean", pageBean);
 		Map<String, Object> data = new HashMap<String, Object>();
 		data.put("total",pageBean.getTotal());
 		data.put("rows", list2);
 		ServletOutputStream os = response.getOutputStream();
 		ObjectMapper om = new ObjectMapper();
 		om.writeValue(os, data);
 		os.flush();
		return null;
	}
	
	
}
