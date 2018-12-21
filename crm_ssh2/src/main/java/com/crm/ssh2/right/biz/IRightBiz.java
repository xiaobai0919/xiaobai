package com.crm.ssh2.right.biz;

import java.util.List;

import com.crm.ssh2.right.entity.Right;
import com.crm.ssh2.right.entity.RightUser;
import com.crm.ssh2.util.PageBean;

public interface IRightBiz {
	
	void add(Right right);
	
	void edit(Right right);
	
	void del(Right right);
	
	Right load(Right right);
	
	List<Right> list(Right right,RightUser rightUser);
	
	List<Right> list(Right right,PageBean pageBean);
}
