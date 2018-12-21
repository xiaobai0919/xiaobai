package com.crm.ssh2.right.dao;

import java.util.List;

import com.crm.ssh2.right.entity.RightUser;
import com.crm.ssh2.util.PageBean;

public interface IRightUserDao {
	
	void add(RightUser rightUser);
	
	RightUser login(RightUser rightUser);
	
	void edit(RightUser rightUser);
	
	void del(RightUser rightUser);
	
	RightUser load(RightUser rightUser);
	
	List<RightUser> list(RightUser rightUser,PageBean pageBean);
}
