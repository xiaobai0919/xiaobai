package com.crm.ssh2.basd.biz;

import java.util.List;

import com.crm.ssh2.basd.entity.BasdStorage;
import com.crm.ssh2.util.PageBean;

public interface IBasdStorageBiz {
	
	void add(BasdStorage basdStorage);
	
	void edit(BasdStorage basdStorage);
	
	void del(BasdStorage basdStorage);
	
	BasdStorage load(BasdStorage basdStorage);
	
	List<BasdStorage> list(BasdStorage basdStorage,PageBean pageBean);
}
