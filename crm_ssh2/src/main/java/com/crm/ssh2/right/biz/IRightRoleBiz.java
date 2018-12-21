package com.crm.ssh2.right.biz;

import java.util.List;

import com.crm.ssh2.right.entity.RightRole;
import com.crm.ssh2.util.PageBean;

public interface IRightRoleBiz {
	
	void add(RightRole rightRole);
	
	void edit(RightRole rightRole);
	
	void del(RightRole rightRole);
	
	RightRole load(RightRole rightRole);
	
	List<RightRole> list(RightRole rightRole,PageBean pageBean);
}
