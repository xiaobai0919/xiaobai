package com.crm.ssh2.right.biz;

import java.util.List;

import com.crm.ssh2.right.entity.RightQx;
import com.crm.ssh2.util.PageBean;

public interface IRightQxBiz {
	
	void add(RightQx rightQx);
	
	void edit(RightQx rightQx);
	
	void del(RightQx rightQx);
	
	RightQx load(RightQx rightQx);
	
	List<RightQx> list(RightQx rightQx,PageBean pageBean);
}
