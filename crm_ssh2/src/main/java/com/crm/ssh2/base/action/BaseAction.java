package com.crm.ssh2.base.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.crm.ssh2.util.PageBean;

public abstract class BaseAction implements ServletRequestAware,ServletResponseAware {
	protected static final String SUCCESS = "success";
	protected static final String FAILED = "failed";
	protected static final String LIST = "list";
	protected static final String DETAIL = "detail";
	protected static final String EDIT = "edit";
	protected static final String ADD = "add";

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected ServletContext application;

	protected Object result;// 返回结果
	protected Object resulta;// 返回结果
	protected Object message;// 操作消息
	protected int code = 0;// 操作代码 0 成功 非0失败

	private String forward;

	public BaseAction() {
		super();
	}

	public String getForward() {
		return forward;
	}

	public String getForward(String defaultForward) {
		if (null == this.forward || "".equals(forward.trim())) {
			return defaultForward;
		}
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public Object getResult() {
		return result;
	}
	
	public Object getResulta() {
		return resulta;
	}

	public Object getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
		this.application = session.getServletContext();
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	
	protected PageBean parsePageBean() {
		PageBean pageBean = new PageBean();
		pageBean.setRequest(request);
		request.setAttribute("pageBean", pageBean);
		return pageBean;
	}
	
	

	

}
