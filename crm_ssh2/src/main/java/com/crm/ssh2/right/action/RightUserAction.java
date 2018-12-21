package com.crm.ssh2.right.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.crm.ssh2.base.action.BaseAction;
import com.crm.ssh2.right.biz.IRightUserBiz;
import com.crm.ssh2.right.entity.RightUser;
import com.crm.ssh2.util.PageBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class RightUserAction extends BaseAction implements ModelDriven<RightUser> {

	private RightUser rightUser = new RightUser();

	private IRightUserBiz rightUserBiz;

	public IRightUserBiz getRightUserBiz() {
		return rightUserBiz;
	}

	public void setRightUserBiz(IRightUserBiz rightUserBiz) {
		this.rightUserBiz = rightUserBiz;
	}

	@Override
	public RightUser getModel() {
		return rightUser;
	}

	
	public String login() {
		RightUser login = rightUserBiz.login(rightUser);
		if(null!=login) {
			session.setAttribute("login", login);
			return "login";
		}
		return LIST;
	}

	public String add() throws Exception {
		rightUserBiz.add(rightUser);
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
		rightUserBiz.edit(rightUser);
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
		rightUserBiz.del(rightUser);
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
		this.result = rightUserBiz.load(rightUser);
		return this.getForward(EDIT);
	}

	public String list() throws Exception {
		PageBean pageBean = this.parsePageBean();
		List<RightUser> list2 = rightUserBiz.list(rightUser, pageBean);
		for (RightUser r : list2) {
			if(null!=r.getRuFlag()&&2==r.getRuFlag()) {
				r.setFlagState("不可用");
			}else {
				r.setFlagState("可用");
			}
		}
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
