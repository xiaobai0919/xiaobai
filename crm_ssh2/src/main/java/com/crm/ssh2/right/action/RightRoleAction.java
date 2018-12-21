package com.crm.ssh2.right.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.crm.ssh2.base.action.BaseAction;
import com.crm.ssh2.right.biz.IRightRoleBiz;
import com.crm.ssh2.right.entity.RightRole;
import com.crm.ssh2.util.PageBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class RightRoleAction extends BaseAction implements ModelDriven<RightRole> {

	private RightRole rightRole = new RightRole();

	private IRightRoleBiz rightRoleBiz;

	public IRightRoleBiz getRightRoleBiz() {
		return rightRoleBiz;
	}

	public void setRightRoleBiz(IRightRoleBiz rightRoleBiz) {
		this.rightRoleBiz = rightRoleBiz;
	}

	@Override
	public RightRole getModel() {
		return rightRole;
	}
	
	public String add() throws Exception {
		rightRoleBiz.add(rightRole);
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("message", "增加成功");
		data.put("code", 0);
		
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		return null;
	}
	
	public String edit() throws Exception {
		rightRoleBiz.edit(rightRole);
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("message", "修改成功");
		data.put("code", 0);
		
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		return null;
	}
	
	public String del() throws Exception {
		rightRoleBiz.del(rightRole);
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("message", "删除成功");
		data.put("code", 0);
		
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		return null;
	}
	
	public String load() {
		this.result = rightRoleBiz.load(rightRole);
		return this.getForward(EDIT);
	}
	
	public String list() throws Exception{
		PageBean pageBean = this.parsePageBean();
		List<RightRole> rightRolelist = rightRoleBiz.list(rightRole,pageBean);
		for (RightRole r : rightRolelist) {
			if(null!=r.getRrFlag()&&2==r.getRrFlag()) {
				r.setFlagState("不可用");
			}else {
				r.setFlagState("可用");
			}
		}
		request.setAttribute("pageBean", pageBean);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", pageBean.getTotal());
		data.put("rows", rightRolelist);
		ServletOutputStream os = response.getOutputStream();
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		return null;
	}
}
