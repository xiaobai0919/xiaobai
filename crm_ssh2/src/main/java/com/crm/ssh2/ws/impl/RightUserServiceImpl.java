package com.crm.ssh2.ws.impl;

import java.util.List;

import javax.jws.WebService;

import org.apache.axis2.extensions.spring.receivers.ApplicationContextHolder;

import com.crm.ssh2.right.biz.IRightUserBiz;
import com.crm.ssh2.right.entity.RightUser;
import com.crm.ssh2.ws.IRightUserService;

@WebService
public class RightUserServiceImpl implements IRightUserService {

	
	private IRightUserBiz rightUserBiz;
	
	public IRightUserBiz getRightUserBiz() {
		return rightUserBiz;
	}
	public void setRightUserBiz(IRightUserBiz rightUserBiz) {
		this.rightUserBiz = rightUserBiz;
	}

	public RightUserServiceImpl() {
		
	}
	
	
	
	@Override
	public List<RightUser> list(RightUser rightUser) {
		rightUser.setRuName("xiaobai");
		return rightUserBiz.list(rightUser, null);
	}

}
