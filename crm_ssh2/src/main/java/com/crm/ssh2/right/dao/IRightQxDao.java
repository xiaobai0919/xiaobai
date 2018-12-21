package com.crm.ssh2.right.dao;

import java.util.List;

import com.crm.ssh2.right.entity.RightQx;
import com.crm.ssh2.util.PageBean;

public interface IRightQxDao {
	
	void add(RightQx rightQx);
	
	void edit(RightQx rightQx);
	
	void del(RightQx rightQx);
	
	RightQx load(RightQx rightQx);
	
	List<RightQx> list(RightQx rightQx,PageBean pageBean);
}
